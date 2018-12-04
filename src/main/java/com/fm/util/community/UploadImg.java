package com.fm.util.community;

import com.qiniu.util.Auth;

/**
 * 获取七牛云上传token
 * YftPaper
 */
@SuppressWarnings("all")
public class UploadImg {

    public static String getQiniuToken(String key) {
        String accessKey = "uFy_2nTo_c-fCDvigBum8ZnwvFZPwRceTAbw7zVS";
        String secretKey = "6rGh9INqH0vQWj4BXc0yEfPsz1dLyvUk0H8JtNPe";
        String bucket = "studyapp";

        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket, key);
        return upToken;
    }

    public static String get15MQiniuToken(String key) {
        String accessKey = "JcizXMVETronZfp-PGoIjB8U6Ms7HCthUKV1JX1I";
        String secretKey = "v1WsaLefVlyewHwMHNKtfT-_qNic_oLpYSXBvjM0";
        String bucket = "15m-images-space";

        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket, key);
        return upToken;
    }

}
