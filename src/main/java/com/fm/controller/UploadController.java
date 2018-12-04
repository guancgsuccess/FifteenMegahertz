package com.fm.controller;

import com.fm.util.UploadImgUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2018/10/17.
 * 该类提供七牛云上传token
 * @author haonan.
 */
@Controller
@RequestMapping("/upload")
public class UploadController {

    @GetMapping("getToken")
    @ResponseBody
    public Map<String,String> generateUpToken(){
        Map<String,String> result=new HashMap<>(1);
        result.put("uptoken",UploadImgUtil.getUpToken());
        return result;
    }
}
