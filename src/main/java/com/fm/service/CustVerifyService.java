package com.fm.service;

import com.fm.entity.CustVerify;
import com.fm.entity.common.ServerResponse;

public interface CustVerifyService extends BaseService<CustVerify> {

    Integer updateByPrimaryKeySelective(CustVerify custVerify);

    Boolean saveSelective(CustVerify custVerify);

    ServerResponse findByExample(Integer custId);

}
