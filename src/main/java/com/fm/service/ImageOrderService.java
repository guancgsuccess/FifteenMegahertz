package com.fm.service;

import java.util.List;
import java.util.Map;

/**
 * Created on 2018/10/17.
 *
 * @author guochangji
 */
public interface ImageOrderService {
    /**
     * 添加购买记录
     * @param custId 用户的ID
     * @param imageId 下载图片的ID
     * @return 0:添加订单失败,1:添加订单成功,2:已存在该订单
     */
    public Integer saveOrder(Integer custId,Integer imageId) throws Exception;

    /**
     * 根据用户的ID查询所有的购买记录
     * @param custId 用户的ID
     * @return 返回封装完成的对象集合
     */
    public List<Map<String,Object>> getAllImageOrder(Integer custId);
}
