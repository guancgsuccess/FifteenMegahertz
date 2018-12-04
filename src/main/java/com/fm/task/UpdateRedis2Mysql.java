package com.fm.task;

import com.fm.cache.RedisUtil;
import com.fm.dao.ImageDao;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Set;

/**
 * Created on 2018/10/24.
 * 更新redis到mysql
 * @author guochangji
 */
public class UpdateRedis2Mysql {
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private ImageDao imageDao;

    //定时将redis中的图片点击量写回数据库(设置30分钟)

    public void executeLook(){

        if(redisUtil.hasKey("imageIdIncrementClicks")){
            Set<Object> set= redisUtil.hKeys("imageIdIncrementClicks");
            for (Object aSet : set) {
                String imageId = (String) aSet;
                this.imageDao.updateClicksIncrementByPrimaryKey(Integer.parseInt(redisUtil.hGet("imageIdIncrementClicks", imageId).toString()), Integer.valueOf(imageId));
            }
            redisUtil.delete("imageIdIncrementClicks");
        }


    }



}
