package com.fm.service;

import com.aliyuncs.exceptions.ClientException;
import com.fm.entity.Customer;
import com.fm.entity.common.ServerResponse;
import java.util.Map;

/**
 * Created on 2018/10/13.
 *
 * @author guochangji
 */
public interface CustomerService extends BaseService<Customer> {
    /*==*********************************葛晨晨代码开始************************************/
    ///////////////////注册模块///////////////////
    /**
     * 注册获取验证码
     * @param custPhone 用户输入手机号
     * @return 统一返回格式
     */
    ServerResponse setRegisterCode(String custPhone) throws ClientException;

    /**
     * 用户注册
     * @param custPhone 用户手机号
     * @param custPassword 用户密码
     * @param code 用户输入验证码
     * @param getCode session中的验证码
     * @param sessionCustPhone session中的手机号（用于判断是否与第一次获取验证码的手机号是否相同）
     * @param getMessageTime 获取验证码的时间
     * @return 统一返回格式
     */
    ServerResponse registerCustomer(String custPhone,String custPassword,String code,String getCode,String sessionCustPhone,Long getMessageTime);


    ///////////////////登陆模块///////////////////
    /**
     * 用户手机或者邮箱登录
     * @param custPhoneOrEmail 手机或者邮箱
     * @param custPassword 密码
     * @param getLoginIp 登录Ip
     * @return 统一返回格式
     */
    ServerResponse loginCustomer(String custPhoneOrEmail, String custPassword,String getLoginIp);

    /**
     * 登录获取验证码
     * @param custPhone 用户输入手机号
     * @return 统一返回格式
     */
    ServerResponse setLoginCode(String custPhone) throws ClientException;


    /**
     * 验证码登录
     * @param custPhone 用户手机号
     * @param sessionPhone session手机号（用于判断是否和第一次的手机号相同）
     * @param getCode 用户输入的验证码
     * @param sessionCode session里的验证码（用于和用户输入的验证码匹配）
     * @param getMessageTime 用户点击获取验证码的时间（用于判断验证码是否过期）
     * @param getLoginIp 登录Ip
     * @return 统一返回格式
     */
    ServerResponse codeLoginCustomer(String custPhone,String sessionPhone,String getCode,String sessionCode,Long getMessageTime,String getLoginIp);



    ///////////////////个人中心模块///////////////////
    /**
     * 个人中心的加载
     * @param custId 用户Id
     * @param sessionCustId session中的Id
     * @return 统一返回格式
     */
    ServerResponse personalCenter(Integer custId,Integer sessionCustId);

    /**
     * 用户修改用户名和个性签名
     * @param custId 用户Id
     * @param custNick 用户名
     * @param custIntro 个性签名
     * @return 统一返回格式
     */
    ServerResponse modifyNickAndIntro(Integer custId,String custNick,String custIntro);

    /**
     * 用户修改头像
     * @param custId yonghuId
     * @param portraitUrl 头像路径地址
     * @return 统一返回格式
     */
    ServerResponse modifyHeadPortrait(Integer custId,String portraitUrl);

    /**
     * 用户修改密码
     * @param oldPwd 旧密码
     * @param repeatNewPassword 新密码
     * @return 统一返回格式
     */
    ServerResponse modifyPassword(Integer custId,String oldPwd,String repeatNewPassword);













    /**
     * 追随者记录数
     * @param id 用户id
     * @return
     */
    public Long countByIdol(Integer id);

    /**
     * 追随者记录数
     * @param id 用户id
     * @return
     */
    public Long countByFollow(Integer id);

    /**
     *作品记录数
     * @param id 用户id
     * @return
     */
    public Long countByImage(Integer id);

    /**
     *收藏记录数
     * @param id 用户id
     * @return
     */
    public Long countByImageFavorite(Integer id);


    /*********************************葛晨晨代码结束*******************************************/
    /**
     * 修改用户的账户
     * @param money
     * @param custId
     * @return
     */
    public Boolean updateCredits(Integer money,Integer custId);

    /**
     * 查询等级
     * @param custId 用户ID
     * @return 返回用户的等级
     */
    ServerResponse findRangeLevelByPrimaryKey(Integer custId);


    /*============================================================================*/
    /**
     * 发送邮箱
     * @param mail 邮箱号码
     * @return 1:发送成功,0:发送失败,2:邮箱不存在
     */
    ServerResponse sendEmail(String mail,String sessionId);

    /**
     * 忘记密码找回
     * @param mail 邮箱
     * @param pwd 密码
     * @return 操作是否成功
     */
    Boolean updatePwdByEmail(String mail,String pwd);



    /*===================================================方鹏================================*/


    Map<String,Object> getPhotographer();
}
