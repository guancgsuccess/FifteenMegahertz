package com.fm.service.impl;

import com.alibaba.fastjson.JSON;
import com.fm.cache.RedisUtil;
import com.fm.dao.CustomerDao;
import com.fm.dao.ImageDao;
import com.fm.dao.ImageFavoriteDao;
import com.fm.entity.*;
import com.fm.service.ImageService;
import com.fm.util.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created on 2018/9/29.
 * @author guochangji
 */
@Service
public class ImageServiceImpl implements ImageService {
    private final ImageDao imageDao;
    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private CustomerDao customerDao;


    @Autowired
    private ImageFavoriteDao imageFavoriteDao;

    @Autowired
    public ImageServiceImpl(ImageDao imageDao) {
        this.imageDao = imageDao;
    }


    @Override
    public Integer deleteById(Integer id) {
        return imageDao.deleteByPrimaryKey(id);
    }

    @Override
    public Integer update(Image entity) {
        return null;
    }

    @Override
    public Integer save(Image entity) {
        return this.imageDao.insert(entity);
    }

    @Override
    public List<Image> findAll() {
        return this.imageDao.selectByExample(null);
    }

    @Override
    public Image findById(Integer id) {
        return imageDao.selectByPrimaryKey(id);
    }
    /**
     * 用缓存记录图片总数(有用户上传图片就清空缓存)
     * @return
     */
    @Override
    public Long findSumCount() {
        if(redisUtil.hasKey("imageSumCount")){
            return Long.valueOf(redisUtil.get("imageSumCount"));
        }else {
            ImageExample imageExample=new ImageExample();
            imageExample.createCriteria().andImageStatusEqualTo(1).andCategoryIdNotEqualTo(15);
            Long count=this.imageDao.countByExample(imageExample);
            redisUtil.set("imageSumCount",count.toString());
            return count;
        }

    }

    /**
     * 缓存分页数据和首页数据(24小时更新一次)
     * @param currentPage 当前页数
     * @param categoryId 类别ID
     * @param priceType 是否收费
     * @param sortType  排序方式
     * @param keyword 关键字
     * @return 返回查询数据
     */
    @Override
    public PageModel findByPageWithCondition(Integer currentPage, Integer categoryId, Integer priceType, Integer sortType,String keyword) {
        PageModel pageModel=new PageModel();
        pageModel.setPageSize(20);
        pageModel.setCurrentPageCode(currentPage);
        ImageExample imageExample=new ImageExample();
        ImageExample.Criteria criteria1= imageExample.createCriteria();
        ImageExample.Criteria criteria2 = imageExample.createCriteria();
        String order="";
        if(categoryId!=0){
            criteria1.andCategoryIdEqualTo(categoryId);
            criteria2.andCategoryIdEqualTo(categoryId);
        }
        if(priceType!=0){
            criteria1.andImageIsFreeEqualTo(priceType);
            criteria2.andImageIsFreeEqualTo(priceType);
        }
        if(sortType!=0){
            switch (sortType){
                case 1:
                    order="image_clicks desc";
                    break;
                case 2:
                    order="image_downloads desc";
                    break;
                case 3:
                    order="image_collections desc";
                    break;
                case 4:
                    order="image_likes desc";
                    break;
                case 5:
                    order="image_upload_time desc";
                    break;
                default:
                    break;
            }
            imageExample.setOrderByClause(order);
        }
        criteria1.andImageStatusEqualTo(1);
        criteria2.andImageStatusEqualTo(1);
        criteria1.andCategoryIdNotEqualTo(15);
        criteria2.andCategoryIdNotEqualTo(15);
        Long total=0L;
        if(keyword!=null&& !"".equals(keyword)){
            criteria1.andImageNameLike("%"+keyword+"%");
            criteria2.andImageKeywordLike("%"+keyword+"%");
            imageExample.or(criteria2);
            total=imageDao.countByExample(imageExample);
        }else if(categoryId==0&&priceType==0){
            total=findSumCount();
        }else {
            total=imageDao.countByExample(imageExample);
        }
        //总记录数
        pageModel.setTotalRecord(total.intValue());
        //总页数
        pageModel.setTotalPages((pageModel.getTotalRecord() % pageModel.getPageSize() ==0 ? pageModel.getTotalRecord() / pageModel.getPageSize() : pageModel.getTotalRecord() / pageModel.getPageSize() +1));
        pageModel.setStartRecord((pageModel.getCurrentPageCode()-1) * pageModel.getPageSize());
        imageExample.setOffset(pageModel.getStartRecord());
        imageExample.setLimit(pageModel.getPageSize());
        List<Image> images;

        if(sortType==4){
            //首页缓存
            if(redisUtil.hasKey("pageHome")){
                if(redisUtil.hExists("pageHome",JSON.toJSONString(imageExample))){
                    images=JSON.parseArray(redisUtil.hGet("pageHome",JSON.toJSONString(imageExample)).toString(),Image.class);
                }else {
                    images=this.imageDao.selectByExample(imageExample);
                    redisUtil.hPut("pageHome",JSON.toJSONString(imageExample), JSON.toJSONString(images));
                    redisUtil.expire("pageHome",24, TimeUnit.HOURS);
                }
            }else {
                images=this.imageDao.selectByExample(imageExample);
                redisUtil.hPut("pageHome",JSON.toJSONString(imageExample), JSON.toJSONString(images));
                redisUtil.expire("pageHome",24, TimeUnit.HOURS);
            }
        }else {
            //图库缓存
            if(redisUtil.hasKey("page")){
                if(redisUtil.hExists("page",JSON.toJSONString(imageExample))){
                    images=JSON.parseArray(redisUtil.hGet("page",JSON.toJSONString(imageExample)).toString(),Image.class);
                }else {
                    images=this.imageDao.selectByExample(imageExample);
                    redisUtil.hPut("page",JSON.toJSONString(imageExample), JSON.toJSONString(images));
                }
            }else {
                images=this.imageDao.selectByExample(imageExample);
                redisUtil.hPut("page",JSON.toJSONString(imageExample), JSON.toJSONString(images));
            }
        }



        List<Map<String,Object>> imageInfo=new ArrayList<>();
        for(Image image:images){
            Map<String,Object> map=new HashMap<>(2);
            map.put("imageId",image.getImageId());
            map.put("imageCompressPath",image.getComprePath());
            imageInfo.add(map);
        }
        pageModel.setModelList(imageInfo);
        return pageModel;
    }


    /**
     * 用缓存记录浏览数,定时写回数据库
     * @param imageId 图片ID
     *
     */
    @Override
    public void updateClicks(Integer imageId) {
        if(redisUtil.hasKey("imageIdIncrementClicks")){
            if(redisUtil.hExists("imageIdIncrementClicks",imageId.toString())){
                redisUtil.hIncrBy("imageIdIncrementClicks",imageId.toString(),1);
            }else {
                redisUtil.hPut("imageIdIncrementClicks",imageId.toString(),"1");
            }
        }else {
            redisUtil.hPut("imageIdIncrementClicks",imageId.toString(),"1");
        }
    }

    @Override
    public Integer findAuthorIdByImageId(Integer imageId) {
        return findById(imageId).getCustId();
    }

    /**
     * 根据用户的ID查询他发布作品ID的集合(写入缓存)
     * @param imageId 当前图片ID
     * @return
     */
    @Override
    public List<Integer> findImageIdsByAuthorId(Integer imageId) {

        List<Image> images;
        Integer custId=findAuthorIdByImageId(imageId);
        if(redisUtil.hasKey("imageIds")){
            if(redisUtil.hExists("imageIds",custId.toString())){
                images=JSON.parseArray(redisUtil.hGet("imageIds",custId.toString()).toString(),Image.class);
            }else {
                ImageExample imageExample=new ImageExample();
                imageExample.createCriteria().andCustIdEqualTo(custId).andCategoryIdNotEqualTo(15);
                images=this.imageDao.selectByExample(imageExample);
                redisUtil.hPut("imageIds",custId.toString(),JSON.toJSONString(images));
            }
        }else{
            ImageExample imageExample=new ImageExample();
            imageExample.createCriteria().andCustIdEqualTo(custId).andCategoryIdNotEqualTo(15);
            images=this.imageDao.selectByExample(imageExample);
            redisUtil.hPut("imageIds",custId.toString(),JSON.toJSONString(images));
        }
        List<Integer> ids=new ArrayList<>();
        for(Image image:images){
            ids.add(image.getImageId());
        }
        List<Integer> idsNew=new ArrayList<>();
        idsNew.add(imageId);
        for(Integer id:ids){
            if(!id.equals(idsNew.get(0))){
                idsNew.add(id);
            }
        }
        return idsNew;
    }

    /**
     * 添加图片并清除分页缓存(首页不清除)
     * @param custId 作者ID
     * @param image 图片参数对象
     * @return 0:成功;1:失败;2:图片已存在
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer addImage(Integer custId,Image image) throws Exception {
        ImageExample imageExample=new ImageExample();
        imageExample.createCriteria().andNocomprePathEqualTo(image.getNocomprePath());
        if(this.imageDao.selectByExample(imageExample).size()==0){
            image.setCustId(custId);
            image.setComprePath(image.getNocomprePath()+"-15M");
            if("".equals(image.getCameraBrand())){
                image.setCameraBrand(null);
            }
            if("".equals(image.getCameraModel())){
                image.setCameraModel(null);
            }
            if("".equals(image.getCameraFocalLenth())){
                image.setCameraFocalLenth(null);
            }
            if("".equals(image.getCameraAperture())){
                image.setCameraAperture(null);
            }
            if("".equals(image.getCameraIso())){
                image.setCameraIso(null);
            }
            if("".equals(image.getCameraExposureTime())){
                image.setCameraExposureTime(null);
            }
            if("".equals(image.getImageBrightness())){
                image.setImageBrightness(null);
            }
            Customer customer=this.customerDao.selectByPrimaryKey(custId);
            try {
                this.imageDao.insertSelective(image);
                if(customer.getRangeExp()+30>=100){
                    this.customerDao.updateExpByPrimaryKey(customer.getRangeExp()-70,custId);
                    this.customerDao.updateLevelByPrimaryKey(custId);
                }else {
                    this.customerDao.updateExpByPrimaryKey(customer.getRangeExp()+30,custId);
                }
                if(redisUtil.hasKey("page")){
                    redisUtil.delete("page");
                }
                if(redisUtil.hasKey("imageSumCount")){
                    redisUtil.delete("imageSumCount");
                }
                if(redisUtil.hExists("imageIds",custId.toString())){
                    redisUtil.hDelete("imageIds",custId.toString());
                }
                return 0;
            }catch (Exception ignored){
                throw  new  Exception("执行失败!");
            }
        }else {
            return 2;
        }
    }




    /**
     *
     * @return Set关键字集合
     */
    @Override
    public Set<String> findSearchKey(String keyword){
        Set<String> result=new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()!=o2.length()){
                    return o1.length()>o2.length() ?1:-1;
                }else {
                    return o1.compareTo(o2);
                }
            }
        });
        List<Map<String,Object>> keyWordLikes= this.imageDao.selectKeyWordLike(keyword);
        List<String> keys1=new ArrayList<>();
        List<String> keys2=new ArrayList<>();
        for(Map<String,Object> map:keyWordLikes){
            keys1.add((String) map.get("image_keyword"));
            keys2.add((String) map.get("image_name"));
        }
        for(String key:keys1){
            String[] line=key.substring(1).split("#");
            for(String k:line){
                if(k.contains(keyword)){
                    result.add(k);
                }
            }
        }
        for(String key:keys2){
            if(key.contains(keyword)){
                result.add(key);
            }
        }
        return result;
    }

    /*个人中心的分页查询*/
    /**
     * 根据个人用户作品的分页查询
     * @param pageModel 分页类
     * @param custId 用户ID
     * @return
     */
    @Override
    public PageModel findWorksByPage(PageModel pageModel, Integer custId,Integer sessionCustId) {
        ImageExample example=new ImageExample();
        ImageExample.Criteria criteria=example.createCriteria();
        criteria.andCustIdEqualTo(custId);
        criteria.andImageStatusEqualTo(1);
        criteria.andCategoryIdNotEqualTo(15);
        //总记录数
        Long total=imageDao.countByExample(example);
        pageModel.setTotalRecord(total.intValue());
        pageModel.setPageSize(30);
        //总页数
        pageModel.setTotalPages((pageModel.getTotalRecord() % pageModel.getPageSize()==0? pageModel.getTotalRecord()/pageModel.getPageSize():pageModel.getTotalRecord()/pageModel.getPageSize()+1));
        //从第几条记录开始显示
        pageModel.setStartRecord((pageModel.getCurrentPageCode()-1) * pageModel.getPageSize());
        example.setOffset(pageModel.getStartRecord());
        //每页显示数量
        example.setLimit(pageModel.getPageSize());


        List<Image> images=imageDao.selectByExample(example);
        List<Map<String,Object>> imageInfo=new ArrayList<>();
        for (Image image:images){
            Map<String,Object> map=new HashMap<>();
            map.put("imageId",image.getImageId());
            map.put("imageCompressPath",image.getComprePath());
            if(sessionCustId!=null) {
                ImageFavoriteExample imageFavoriteExample = new ImageFavoriteExample();
                ImageFavoriteExample.Criteria criteria1=imageFavoriteExample.createCriteria();
                criteria1.andCustIdEqualTo(sessionCustId);
                criteria1.andImageIdEqualTo(image.getImageId());
                List<ImageFavorite> imageFavoriteList = imageFavoriteDao.selectByExample(imageFavoriteExample);
                if (imageFavoriteList != null && imageFavoriteList.size() > 0) {
                    map.put("isLike", 1);
                } else {
                    map.put("isLike", 0);
                }
            }else {
                map.put("isLike",2);
            }
            imageInfo.add(map);
        }

        //当前页显示记录对象集合
        pageModel.setModelList(imageInfo);
        return pageModel;
    }

    @Override
    public List<Image> findByCustId(Integer custId) {
        ImageExample imageExample=new ImageExample();
        imageExample.createCriteria().andCustIdEqualTo(custId);
        return imageDao.selectByExample(imageExample);
    }


    /**
     * 修改图片状态
     * @param imageId 图片Id
     * @return
     */
    @Override
    public Boolean modifyImageStatus(Integer imageId) {
        Image image=new Image();
        image.setImageId(imageId);
        image.setImageStatus(0);

        ImageFavoriteExample favoriteExample=new ImageFavoriteExample();
        ImageFavoriteExample.Criteria criteria=favoriteExample.createCriteria();
        criteria.andImageIdEqualTo(imageId);

        ImageFavorite imageFavorite=new ImageFavorite();
        imageFavorite.setFavoriteStatus(0);

        int imageDel=imageDao.updateByPrimaryKeySelective(image);
        int imageFavoriteDel=imageFavoriteDao.updateByExampleSelective(imageFavorite,favoriteExample);

        if(imageDel==1 || imageFavoriteDel==1){
            if(redisUtil.hasKey("page")){
                redisUtil.delete("page");
            }
            return true;
        }else {
            return false;
        }
    }


    /**
     * 查询作品欣赏的作品信息
     * @return
     */
    @Override
    public Map<String,Object> selectImages() {
        Map<String,Object> map = new HashMap<>();
        List<Image> imageList = imageDao.selectImages();
        List<Object> list = new ArrayList<>();
        for (Image image:imageList){
            Map<String,Object> map1 = new HashMap<>();
            Customer customer = customerDao.selectByPrimaryKey(image.getCustId());
            map1.put("imageName",image.getImageName());
            map1.put("custNick",customer.getCustNick());
            map1.put("custId",customer.getCustId());
            map1.put("imageId",image.getImageId());
            list.add(map1);
        }
        map.put("imageList",list);
        return map;
    }


}
