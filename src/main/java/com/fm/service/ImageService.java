package com.fm.service;

import com.fm.entity.Image;
import com.fm.entity.ImageExample;
import com.fm.entity.common.ServerResponse;
import com.fm.util.PageModel;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created on 2018/9/29.
 * @author guochangji
 */
public interface ImageService extends BaseService<Image>{

    /**
     * 查询全部图片总数
     * @return 返回全部图片总数  status=1
     */
    public Long findSumCount();

    /**
     * 分页条件查询
     * @param currentPage 当前页数
     * @param categoryId 类别ID
     * @param priceType 是否收费
     * @param sortType  排序方式
     * @param keyword 关键字
     * @return 返回带有查询结果的PageModel
     */
    public PageModel findByPageWithCondition(Integer currentPage, Integer categoryId, Integer priceType, Integer sortType,String keyword);

    /**
     * 手写redis缓存记录浏览数,定时写回数据库
     * @param imageId 图片ID
     *
     */
    public void updateClicks(Integer imageId);

    /**
     * 根据图片ID查询作者的ID
     * @param imageId 图片的ID
     * @return 返回用户ID
     */
    public Integer findAuthorIdByImageId(Integer imageId);

    /**
     * 查询用户的所有作品
     * @param imageId 当前图片ID
     * @return 返回List<Image>且当前图片ID排在首位
     */
    public List<Integer> findImageIdsByAuthorId(Integer imageId);

    /**
     * 上传图片
     * @param custId 作者ID
     * @param image 图片参数对象
     * @return 返回执行结果
     */
    public Integer addImage(Integer custId,Image image) throws Exception;


    /**
     * 返回搜索提示
     * @return 返回关键字的Set集合
     */
    Set<String> findSearchKey(String keyword);
    /**
     * 根据个人用户作品的分页查询
     * @param pageModel 分页类
     * @param custId 用户ID
     * @return
     */
    PageModel findWorksByPage(PageModel pageModel,Integer custId,Integer sessionCustId);

    /**
     * 查询用户的所有作品
     * @param custId
     * @return
     */
    List<Image> findByCustId(Integer custId);

    /**
     * 修改图片状态
     * @param imageId 图片Id
     * @return
     */
    Boolean modifyImageStatus(Integer imageId);

    /**
     * 查询点击量最高的作品
     * @return
     */
    Map<String,Object> selectImages();
}
