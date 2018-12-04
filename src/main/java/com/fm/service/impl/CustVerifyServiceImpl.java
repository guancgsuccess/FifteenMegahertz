package com.fm.service.impl;

import com.fm.dao.CustVerifyDao;
import com.fm.entity.CustVerify;
import com.fm.entity.CustVerifyExample;
import com.fm.entity.common.ServerResponse;
import com.fm.service.CustVerifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustVerifyServiceImpl implements CustVerifyService {
    private ServerResponse result = null;

    @Autowired
    private CustVerifyDao dao;

    @Override
    public Integer deleteById(Integer id) {
        return null;
    }

    @Override
    public Integer update(CustVerify entity) {
        return null;
    }

    @Override
    public Integer save(CustVerify entity) {
        return null;
    }

    @Override
    public List<CustVerify> findAll() {
        return null;
    }

    @Override
    public CustVerify findById(Integer id) {
        return null;
    }


    @Override
    public Integer updateByPrimaryKeySelective(CustVerify custVerify) {
        Integer rows = dao.updateByPrimaryKeySelective(custVerify);
        return rows;
    }

    @Override
    public Boolean saveSelective(CustVerify custVerify) {
        custVerify.setVerifyStatus(2);
        Integer rows = dao.insertSelective(custVerify);
        if (rows != 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public ServerResponse findByExample(Integer custId) {
        CustVerifyExample custVerifyExample = new CustVerifyExample();
        custVerifyExample.createCriteria().andCustIdEqualTo(custId);
        List<CustVerify> custVerifyList = dao.selectByExample(custVerifyExample);
        if(custVerifyList.size()==0){
            Map<String,Object> map = new HashMap<>();
            map.put("verifyStatus", null);
            result = ServerResponse.createBySuccess("",map);
        }else {
            for (CustVerify custVerify : custVerifyList) {
                Integer verifyStatus = custVerify.getVerifyStatus();
                Map<String, Object> map = new HashMap<>();
                map.put("verifyStatus", verifyStatus);
                result = ServerResponse.createBySuccess("",map);
            }
        }
        return result;
    }
}
