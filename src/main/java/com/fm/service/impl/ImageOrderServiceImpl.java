package com.fm.service.impl;

import com.fm.dao.CustOrderDao;
import com.fm.dao.CustomerDao;
import com.fm.dao.ImageDao;
import com.fm.entity.CustOrder;
import com.fm.entity.CustOrderExample;
import com.fm.entity.Customer;
import com.fm.entity.Image;
import com.fm.service.ImageOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on 2018/10/17.
 *
 * @author guochangji
 */
@Service
public class ImageOrderServiceImpl implements ImageOrderService {
    @Autowired
    private CustOrderDao custOrderDao;
    @Autowired
    private ImageDao imageDao;
    @Autowired
    private CustomerDao customerDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer saveOrder(Integer custId, Integer imageId) throws Exception {
        Integer result=0;
        //0:添加订单失败,1:添加订单成功,2:已存在该订单
        Image image=this.imageDao.selectByPrimaryKey(imageId);
        image.setImageDownloads(image.getImageDownloads()+1);
        //若已购买
        CustOrderExample custOrderExample=new CustOrderExample();
        custOrderExample.createCriteria().andCustIdEqualTo(custId);
        List<CustOrder> orders=this.custOrderDao.selectByExample(custOrderExample);
        for(CustOrder order:orders){
            if(order.getImageId().equals(imageId)){
                result=2;
                return  result;
            }
        }
        //若从未购买
        CustOrder custOrder=new CustOrder();
        custOrder.setCustId(custId);
        custOrder.setImageId(imageId);
        custOrder.setImageName(image.getImageName());
        custOrder.setOrderCreateTime(new Timestamp(System.currentTimeMillis()));
        custOrder.setOrderPrice(image.getImagePrice());
        custOrder.setBlank1(String.valueOf(System.currentTimeMillis()));
        Customer customer=this.customerDao.selectByPrimaryKey(custId);
        customer.setCustCredits(customer.getCustCredits()-image.getImagePrice());
        Customer author=this.customerDao.selectByPrimaryKey(image.getCustId());
        author.setCustCredits(author.getCustCredits()+(int)(image.getImagePrice()*0.5));
        try{
            this.custOrderDao.insert(custOrder);
            this.imageDao.updateByPrimaryKey(image);
            this.customerDao.updateByPrimaryKey(customer);
            this.customerDao.updateByPrimaryKey(author);
            result=1;
        }catch (Exception ignored){
            throw new Exception();
        }
        return result;
    }

    /**
     * 返回用户所有的订单信息
     * @param custId 用户的ID
     * @return 返回 List<Map<String, Object>>
     */
    @Override
    public List<Map<String, Object>> getAllImageOrder(Integer custId) {
        List<Map<String, Object>> orderList=new ArrayList<>();
        CustOrderExample custOrderExample=new CustOrderExample();
        custOrderExample.createCriteria().andCustIdEqualTo(custId);
        List<CustOrder> custOrders=this.custOrderDao.selectByExample(custOrderExample);
        for(CustOrder c:custOrders){
            Map<String,Object> map=new HashMap<>(5);
            map.put("orderNumber",c.getBlank1());
            map.put("imageId",c.getImageId());
            map.put("imageName",c.getImageName());
            map.put("orderCreateTime",c.getOrderCreateTime());
            map.put("orderPrice",c.getOrderPrice());
            map.put("imageLink",this.imageDao.selectByPrimaryKey(c.getImageId()).getNocomprePath()+"?attname="+c.getImageName()+".jpg");
            orderList.add(map);
        }
        return orderList;
    }
}
