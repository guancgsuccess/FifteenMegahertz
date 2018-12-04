package com.fm.service.impl;

import com.alibaba.fastjson.JSON;
import com.fm.cache.RedisUtil;
import com.fm.dao.CustomerDao;
import com.fm.dao.ImageCommentDao;
import com.fm.entity.Customer;
import com.fm.entity.CustomerExample;
import com.fm.entity.ImageComment;
import com.fm.entity.ImageCommentExample;
import com.fm.service.CustomerService;
import com.fm.service.ImageCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created on 2018/10/7.
 *
 * @author guochangji
 */
@Service
public class ImageCommentServiceImpl implements ImageCommentService {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private ImageCommentDao imageCommentDao;

    @Autowired
    private CustomerDao customerDao;
    @Override
    public Integer deleteById(Integer id) {
        return null;
    }

    @Override
    public Integer update(ImageComment entity) {
        return null;
    }

    @Override
    public Integer save(ImageComment entity) {
        return null;
    }

    @Override
    public List<ImageComment> findAll() {
        return null;
    }

    @Override
    public ImageComment findById(Integer id) {
        return null;
    }

    /**
     * 写入缓存
     * @param imageId 图片ID
     * @return
     */
    @Override
    @SuppressWarnings("all")
    public List<ImageComment> findByImageId(Integer imageId) {
        List<ImageComment> imageComments;

        if(redisUtil.hasKey("imageCommentList")){
            if(redisUtil.hExists("imageCommentList",imageId.toString())){
                imageComments= JSON.parseArray(redisUtil.hGet("imageCommentList",imageId.toString()).toString(),ImageComment.class);
            }else {
                ImageCommentExample imageCommentExample=new ImageCommentExample();
                imageCommentExample.createCriteria().andImageIdEqualTo(imageId);
                imageCommentExample.setOrderByClause("comment_create_time desc");
                imageComments=this.imageCommentDao.selectByExample(imageCommentExample);
                redisUtil.hPut("imageCommentList",imageId.toString(),JSON.toJSONString(imageComments));
            }
        }else {
            ImageCommentExample imageCommentExample=new ImageCommentExample();
            imageCommentExample.createCriteria().andImageIdEqualTo(imageId);
            imageCommentExample.setOrderByClause("comment_create_time desc");
            imageComments=this.imageCommentDao.selectByExample(imageCommentExample);
            redisUtil.hPut("imageCommentList",imageId.toString(),JSON.toJSONString(imageComments));
        }
        return imageComments;
    }

    /**
     * 使用缓存(30分钟)
     * @param imageId 图片ID
     * @return 图片的评论数
     */
    @Override
    public Integer findImageCommentCount(Integer imageId) {
        if(redisUtil.hExists("imageCommentCount",imageId.toString())){
            return Integer.parseInt(redisUtil.hGet("imageCommentCount",imageId.toString()).toString());
        }else {
            ImageCommentExample imageCommentExample=new ImageCommentExample();
            imageCommentExample.createCriteria().andImageIdEqualTo(imageId);
            Long count=this.imageCommentDao.countByExample(imageCommentExample);
            redisUtil.hPut("imageCommentCount",imageId.toString(),count.toString());
            redisUtil.expire("imageCommentCount",30, TimeUnit.MINUTES);
            return count.intValue();
        }

    }

    /**
     * 添加评论
     * @param comment 评论内容
     * @param custId 评论人ID
     * @param authorId 被评论人ID
     * @param imageId 图片ID
     * @return 返回操作结果
     */
    @Override
    public boolean addImageComment(String comment, Integer custId, Integer authorId, Integer imageId) {
        ImageComment imageComment=new ImageComment();
        imageComment.setCommentContent(comment);
        imageComment.setCommentCreateTime(new Timestamp(System.currentTimeMillis()));
        imageComment.setCustFromId(custId);
        imageComment.setCustToId(authorId);
        imageComment.setImageId(imageId);
        if(this.imageCommentDao.insert(imageComment)!=0){
            //删除Redis缓存
            redisUtil.hDelete("imageCommentList",imageId.toString());
            redisUtil.hDelete("imageCommentCount",imageId.toString());
            return true;
        }
        return false;
    }

    /**
     * 对查询的评论信息进行封装
     * @param imageId 图片ID
     * @return
     */
    @Override
    public List<Map<String, Object>> findCommentInfo(Integer imageId) {
        List<ImageComment> comments=findByImageId(imageId);
        List<Map<String,Object>> commentInfo=new ArrayList<>();
        for(ImageComment comment:comments){
            Map<String,Object> map=new HashMap<>(5);
            Customer from=this.customerDao.selectByPrimaryKey(comment.getCustFromId());
            Customer to=this.customerDao.selectByPrimaryKey(comment.getCustToId());
            map.put("fromId",from.getCustId());
            map.put("fromNick",from.getCustNick());
            map.put("fromProfile",from.getCustProfile());
            map.put("toNick",to.getCustNick());
            map.put("commentTime",comment.getCommentCreateTime());
            map.put("commentContent",comment.getCommentContent());
            commentInfo.add(map);
        }
        return commentInfo;
    }
}
