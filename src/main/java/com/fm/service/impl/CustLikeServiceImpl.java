package com.fm.service.impl;

import com.fm.dao.CustLikeDao;
import com.fm.dao.ImageDao;
import com.fm.entity.CustLike;
import com.fm.entity.CustLikeExample;
import com.fm.entity.Image;
import com.fm.service.CustLikeService;
import com.fm.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created on 2018/10/16.
 *
 * @author guochangji
 */
@Service
public class CustLikeServiceImpl implements CustLikeService {
    @Autowired
    private CustLikeDao custLikeDao;
    @Autowired
    private ImageDao imageDao;

    @Override
    public Boolean isLiked(Integer custId, Integer imageId) {
        CustLikeExample custLikeExample=new CustLikeExample();
        custLikeExample.createCriteria().andImageIdEqualTo(imageId);
        List<CustLike> likes=this.custLikeDao.selectByExample(custLikeExample);
        for(CustLike cl:likes){
            if(cl.getCustId().equals(custId)){
                return true;
            }
        }
        return false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void doLike(Integer custId, Integer imageId) throws Exception {
        CustLike custLike=new CustLike();
        custLike.setCustId(custId);
        custLike.setImageId(imageId);
        Image image=imageDao.selectByPrimaryKey(imageId);
        image.setImageLikes(image.getImageLikes()+1);
        try {
            //向点赞表中插入数据记录
            this.custLikeDao.insert(custLike);
            //图片的点赞数量+1
            this.imageDao.updateByPrimaryKey(image);
        }catch (Exception ignored){
            throw new Exception();
        }

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void cancelLike(Integer custId, Integer imageId) throws Exception {
        CustLikeExample custLikeExample=new CustLikeExample();
        custLikeExample.createCriteria().andCustIdEqualTo(custId).andImageIdEqualTo(imageId);
        Image image=imageDao.selectByPrimaryKey(imageId);
        image.setImageLikes(image.getImageLikes()-1);
        try {
            this.custLikeDao.deleteByExample(custLikeExample);
            this.imageDao.updateByPrimaryKey(image);
        }catch (Exception ignored){
            throw new Exception();
        }

    }
}
