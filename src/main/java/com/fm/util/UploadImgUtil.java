package com.fm.util;
import com.qiniu.util.Auth;
/**
 * Created on 2018/10/3.
 *
 * @author guochangji
 */
public class UploadImgUtil {
    private static final String ACCESS_KEY="JcizXMVETronZfp-PGoIjB8U6Ms7HCthUKV1JX1I";
    private static final String SECRET_KEY="v1WsaLefVlyewHwMHNKtfT-_qNic_oLpYSXBvjM0";
    private static final String BUCKET_NAME="15m-images-space";

    /**
     * 生成uptoken
     * @return 返回uptoken
     */
    public static String getUpToken(){
        Long deadLine =System.currentTimeMillis()/1000L+3600;
        Auth auth=Auth.create(ACCESS_KEY,SECRET_KEY);
        return  auth.uploadTokenWithDeadline(BUCKET_NAME,null, deadLine,null,true);
    }

}
