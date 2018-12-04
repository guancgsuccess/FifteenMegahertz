package com.fm.service.impl;

import com.aliyuncs.exceptions.ClientException;
import com.fm.dao.*;
import com.fm.entity.*;
import com.fm.entity.common.ServerResponse;
import com.fm.rabbitmq.EmailService;
import com.fm.service.CustomerService;
import com.fm.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created on 2018/10/13.
 *
 * @author guochangji
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private CustLoginDao custLoginDao;
    @Autowired
    private CustFollowDao custFollowDao;
    @Autowired
    private ImageDao imageDao;
    @Autowired
    private ImageFavoriteDao imageFavoriteDao;

    @Autowired
    private EmailService emailService;

    @Autowired
    public CustomerServiceImpl(CustomerDao customerDao,CustLoginDao custLoginDao,CustFollowDao custFollowDao,ImageDao imageDao,ImageFavoriteDao imageFavoriteDao){
        this.customerDao=customerDao;
        this.custLoginDao=custLoginDao;
        this.custFollowDao=custFollowDao;
        this.imageDao=imageDao;
        this.imageFavoriteDao=imageFavoriteDao;
    }

    /**
     * 注册获取验证码
     * @param custPhone 用户输入手机号
     * @return 统一返回格式
     */
    @Override
    public ServerResponse setRegisterCode(String custPhone) throws ClientException {
        Map<String,Object> data=new HashMap<>();
        CustomerExample customerExample=new CustomerExample();
        customerExample.createCriteria().andCustPhoneEqualTo(custPhone);
        List<Customer> customerList=customerDao.selectByExample(customerExample);
        if(customerList==null || customerList.size()==0){
            String randCode=GenerateCode.getCode();
            SmsApi.sendSms(custPhone,randCode);
            data.put("message",randCode);
            data.put("phone",custPhone);
            data.put("getMessageTime",System.currentTimeMillis());
            data.put("registerCodeMsg",1);
        }else{
            //手机号已经注册
            data.put("registerCodeMsg",0);
        }
        return  ServerResponse.createBySuccess("",data);
    }

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
    @Override
    public ServerResponse registerCustomer(String custPhone,String custPassword,String code,String getCode,String sessionCustPhone,Long getMessageTime) {
        Map<String,Object> data=new HashMap<>();
        if(!custPhone.equals(sessionCustPhone)){
            //获取验证码的手机不一致
            data.put("registerMsg",0);
        }
        Long nowTime=System.currentTimeMillis();
        //短信有效期五分钟
        int smsTime=300000;
        CustomerExample customerExample=new CustomerExample();
        customerExample.createCriteria().andCustPhoneEqualTo(custPhone);
        List<Customer> customerList=customerDao.selectByExample(customerExample);
        if(customerList==null || customerList.size()==0){
            if(nowTime-getMessageTime<smsTime){
                if(getCode.equals(code)){
                    String custNick= RandomUserNick.GetGUID();
                    Customer customer=new Customer(custNick,custPhone, md5.md5Encrypt(md5.md5Encrypt(custPassword)),"http://img.gcc666.top/Default.jpg",new Date());
                    int rows=customerDao.insertSelective(customer);
                    if(rows==0){
                        //注册失败
                        data.put("registerMsg",1);
                    }else{
                        //注册成功
                        data.put("registerMsg",2);
                    }
                }else{
                    //验证码错误
                    data.put("registerMsg",3);
                }
            }else{
                //验证码五分钟超时
                data.put("registerMsg",4);
            }
        }else {
            //手机号已经注册
            data.put("registerMsg",5);
        }
        return ServerResponse.createBySuccess("",data);
    }


    /**
     * 用户登录
     * @param custPhoneOrEmail 手机号或者邮箱
     * @param custPassword 密码
     * @param getLoginIp 登陆ip
     * @return 统一返回格式
     */
    @Override
    public ServerResponse loginCustomer(String custPhoneOrEmail, String custPassword, String getLoginIp) {
        Map<String,Object> data=new HashMap<>();
        CustomerExample customerExample=new CustomerExample();
        List<Customer> customerList=null;
        String custMd5Pwd= md5.md5Encrypt(md5.md5Encrypt(custPassword));
        /*邮箱登录*/
        String alt="@";
        if(custPhoneOrEmail.contains(alt)){
            customerExample.createCriteria().andCustEmailEqualTo(custPhoneOrEmail).andCustPasswordEqualTo(custMd5Pwd);
            customerList=customerDao.selectByExample(customerExample);
        }else{
            customerExample.createCriteria().andCustPhoneEqualTo(custPhoneOrEmail).andCustPasswordEqualTo(custMd5Pwd);
            customerList=customerDao.selectByExample(customerExample);
        }
        //用户不存在或者密码错误
        if(customerList==null || customerList.size()==0){
            data.put("loginMsg",0);
        }else{
            //登录成功，向登录加数据
            Integer custId=customerList.get(0).getCustId();
            Integer loginType=0;
            Date loginTime=new Date();
            CustLogin custLogin=new CustLogin(custId,loginType,loginTime,getLoginIp);
            custLoginDao.insertSelective(custLogin);
            data.put("loginMsg",1);
            data.put("custId",customerList.get(0).getCustId());
            data.put("custProfile",customerList.get(0).getCustProfile());
            data.put("custNick",customerList.get(0).getCustNick());
        }
        return ServerResponse.createBySuccess("",data);
    }


    /**
     * 登录获取验证码
     * @param custPhone 用户输入手机号
     * @return 统一返回格式
     */
    @Override
    public ServerResponse setLoginCode(String custPhone) throws ClientException {
        Map<String,Object> data=new HashMap<>();
        CustomerExample customerExample=new CustomerExample();
        customerExample.createCriteria().andCustPhoneEqualTo(custPhone);
        List<Customer> customerList=customerDao.selectByExample(customerExample);
        if(customerList==null || customerList.size()==0){
            //手机号未注册
            data.put("loginCodeMsg",0);
        }else{
            //发送成功
            String randCode=GenerateCode.getCode();
            SmsApi.sendSms(custPhone,randCode);
            data.put("message",randCode);
            data.put("phone",custPhone);
            data.put("getMessageTime",System.currentTimeMillis());
            data.put("loginCodeMsg",1);
        }
        return  ServerResponse.createBySuccess("",data);
    }


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
    @Override
    public ServerResponse codeLoginCustomer(String custPhone, String sessionPhone, String getCode, String sessionCode,Long getMessageTime, String getLoginIp) {
        Map<String,Object> data=new HashMap<>();
        if(!custPhone.equals(sessionPhone)){
            //两次手机号不一致
            data.put("codeLoginMsg",0);
        }
        Long nowTime=System.currentTimeMillis();
        //验证码有效期五分钟
        int smsTime=300000;
        //判断验证码是否有效
        if(nowTime-getMessageTime<smsTime){
            //判断验证码是否输入正确
            if(getCode.equals(sessionCode)){
                CustomerExample customerExample=new CustomerExample();
                customerExample.createCriteria().andCustPhoneEqualTo(custPhone);
                List<Customer> customerList=customerDao.selectByExample(customerExample);
                if(customerList==null || customerList.size()==0) {
                    //用户不存在，登录失败
                    data.put("codeLoginMsg", 1);
                }else{
                    Integer custId=customerList.get(0).getCustId();
                    //向登录表插入数据
                    CustLogin custLogin=new CustLogin(custId,1,new Date(),getLoginIp);
                    custLoginDao.insertSelective(custLogin);
                    //登陆成功
                    data.put("codeLoginMsg",2);
                    data.put("custId",custId);
                    data.put("custProfile",customerList.get(0).getCustProfile());
                    data.put("custNick",customerList.get(0).getCustNick());
                }
            }else{
                //验证码错误
                data.put("codeLoginMsg",3);
            }
        }else{
            //验证码超过五分钟
            data.put("codeLoginMsg",4);
        }
        return ServerResponse.createBySuccess("",data);
    }


    ///////////////////个人中心模块///////////////////
    /**
     * 个人中心的加载
     * @param custId 用户Id
     * @param sessionCustId session中的Id
     * @return 统一返回格式
     */
    @Override
    public ServerResponse personalCenter(Integer custId, Integer sessionCustId) {
        Map<String,Object> data=new HashMap<>();
        if(custId.equals(sessionCustId)){
            data.put("personalMsg",2);
            data.put("customer",customerDao.selectByPrimaryKey(sessionCustId));
            //关注数量
            data.put("idols",countByIdol(sessionCustId));
            //追随者数量
            data.put("follows",countByFollow(sessionCustId));
            //作品数量
            data.put("works",countByImage(sessionCustId));
            //收藏数量
            data.put("ollections",countByImageFavorite(sessionCustId));
        }else if(sessionCustId==null){
            data.put("personalMsg",1);
            data.put("otherCustomer",customerDao.selectByPrimaryKey(custId));
            //关注数量
            data.put("otherIdols",countByIdol(custId));
            //追随者数量
            data.put("otherFollows",countByFollow(custId));
            //作品数量
            data.put("otherWorks",countByImage(custId));
            //收藏数量
            data.put("otherOllections",countByImageFavorite(custId));
        } else{
            data.put("personalMsg",0);
            data.put("customer",customerDao.selectByPrimaryKey(sessionCustId));
            data.put("otherCustomer",customerDao.selectByPrimaryKey(custId));
            //关注数量
            data.put("otherIdols",countByIdol(custId));
            //追随者数量
            data.put("otherFollows",countByFollow(custId));
            //作品数量
            data.put("otherWorks",countByImage(custId));
            //收藏数量
            data.put("otherOllections",countByImageFavorite(custId));
        }
        return ServerResponse.createBySuccess("",data);
    }


    /**
     * 用户修改用户名和个性签名
     * @param custId 用户Id
     * @param custNick 用户名
     * @param custIntro 个性签名
     * @return
     */
    @Override
    public ServerResponse modifyNickAndIntro(Integer custId, String custNick, String custIntro) {
        Map<String,Object> data=new HashMap<>();
        Customer customerById=customerDao.selectByPrimaryKey(custId);
        Customer customer=null;
        if(custNick==null || "".equals(custNick)){
            customer=new Customer(custId,customerById.getCustNick(),custIntro);
        }else if(custIntro==null || "".equals(custIntro)){
            customer=new Customer(custId,custNick,customerById.getCustIntro());
        }else{
            customer=new Customer(custId,custNick,custIntro);
        }
        Integer rows=customerDao.updateByPrimaryKeySelective(customer);
        if(rows!=0){
            //修改成功
            data.put("modifyNickAndIntroMsg",1);

            data.put("sessionCustId",custId);
        }else{
            //修改失败
            data.put("modifyNickAndIntroMsg",0);
        }
        return ServerResponse.createBySuccess("",data);
    }


    /**
     * 用户修改头像
     * @param custId yonghuId
     * @param portraitUrl 头像路径地址
     * @return 统一返回格式
     */
    @Override
    public ServerResponse modifyHeadPortrait( Integer custId, String portraitUrl) {
        Map<String,Object> data=new HashMap<>();
        Customer customer=new Customer(custId,portraitUrl);
        Integer rows=customerDao.updateByPrimaryKeySelective(customer);
        data.put("sessionCustId",custId);
        if(rows!=0){
            data.put("modifyHeadPortraitMsg",1);
        }else{
            data.put("modifyHeadPortraitMsg",0);
        }
        return ServerResponse.createBySuccess("",data);
    }

    /**
     * 用户修改密码
     * @param oldPwd 旧密码
     * @param repeatNewPassword 新密码
     * @return 统一返回格式
     */
    @Override
    public ServerResponse modifyPassword(Integer custId,String oldPwd, String repeatNewPassword) {
        Map<String,Object> data=new HashMap<>();
        Customer customerById= customerDao.selectByPrimaryKey(custId);
        if(md5.md5Encrypt(md5.md5Encrypt(oldPwd)).equals(customerById.getCustPassword())){
            Customer customer=new Customer();
            customer.setCustId(custId);
            customer.setCustPassword((md5.md5Encrypt(md5.md5Encrypt(repeatNewPassword))));
            int rows=customerDao.updateByPrimaryKeySelective(customer);
            if(rows!=0){
                //修改成功
                data.put("modifyPasswordMsg",1);
            }else{
                //修改失败
                data.put("modifyPasswordMsg",2);
            }
        }else{
            //原密码错误
            data.put("modifyPasswordMsg",0);
        }
        return ServerResponse.createBySuccess("",data);
    }


    /**
     * 偶像记录数
     * @param id 用户ID
     * @return 返回关注数
     */
    @Override
    public Long countByIdol(Integer id) {
        CustFollowExample example=new CustFollowExample();
        CustFollowExample.Criteria criteria=example.createCriteria();
        criteria.andFollowerIdEqualTo(id);
        Long count=custFollowDao.countByExample(example);
        return count;
    }


    /**
     * 追随者记录数
     * @param id 用户ID
     * @return 返回粉丝数
     */
    @Override
    public Long countByFollow(Integer id) {
        CustFollowExample example=new CustFollowExample();
        CustFollowExample.Criteria criteria=example.createCriteria();
        criteria.andCustIdEqualTo(id);
        Long count=custFollowDao.countByExample(example);
        return count;
    }



    /**
     * 作品记录数
     * @param id 用户ID
     * @return 返回作品数
     */
    @Override
    public Long countByImage(Integer id) {
        ImageExample example=new ImageExample();
        ImageExample.Criteria criteria=example.createCriteria();
        criteria.andCustIdEqualTo(id).andCategoryIdNotEqualTo(15);
        return imageDao.countByExample(example);

    }

    /**
     * 收藏记录数
     * @param id 用户ID
     * @return 返回收藏的数量
     */
    @Override
    public Long countByImageFavorite(Integer id) {
        ImageFavoriteExample example=new ImageFavoriteExample();
        ImageFavoriteExample.Criteria criteria=example.createCriteria();
        criteria.andCustIdEqualTo(id);
        return imageFavoriteDao.countByExample(example);
    }


    /*=*************************************************************************************************************************/










    /**
     * 修改用户的积分
     * @param money 充值的积分
     * @param custId 用户ID
     * @return 返回 操作结果是否成功
     */
    @Override
    public Boolean updateCredits(Integer money, Integer custId) {
        return this.customerDao.updateCreditsByPrimaryKey(money, custId) != 0;
    }





    /**
     * 根据用户id查询用户等级
     * @param custId 用户id
     * @return 用户等级
     */
    @Override
    public ServerResponse findRangeLevelByPrimaryKey(Integer custId) {
        Customer customer = customerDao.selectByPrimaryKey(custId);
        Integer rangeLevel = customer.getRangeLevel();
        Map<String,Object> map = new HashMap<>();
        map.put("rangeLevel", rangeLevel);
        return  ServerResponse.createBySuccess("",map);
    }









    /**
     *
     * @param mail 邮箱号码
     * @return 1:发送成功,2:邮箱不存在
     */
    @Override
    public ServerResponse sendEmail(String mail,String sessionId) {
        ServerResponse sr;
        Map<String,Object> data=new HashMap<>(1);
        CustomerExample customerExample=new CustomerExample();
        customerExample.createCriteria().andCustEmailEqualTo(mail);
        if(this.customerDao.selectByExample(customerExample).size() != 0){
            String code=GenerateCode.getCode();
            String key=code+"&token="+ md5.md5Encrypt(sessionId);
            data.put("code",code);
            emailService.sendEmailToUserQueue(mail,key);
            sr=ServerResponse.createBySuccess("发送成功!",data);
        }else{
            sr=ServerResponse.createByFailure("账户不存在!");
        }
        return sr;
    }

    /**
     * 邮箱找回密码
     * @param mail 邮箱
     * @param pwd 密码
     * @return
     */
    @Override
    public Boolean updatePwdByEmail(String mail, String pwd) {
        String md5pwd= md5.md5Encrypt(md5.md5Encrypt(pwd));
        return this.customerDao.updatePwdByEmail(mail, md5pwd) != 0;
    }

    /*=================================方鹏======================================*/

    /**
     * 获得点击量最高作品的相关信息
     * @return
     */
    @Override
    public Map<String,Object> getPhotographer() {
        Map<String,Object> map = new HashMap<>();
        List<Object> list = new ArrayList<>();
        List<Image> imageList = imageDao.getImages();
        for (Image image:imageList){
            Customer customer = customerDao.selectByPrimaryKey(image.getCustId());
            Map<String,Object> map1 = new HashMap<>();
            map1.put("noComprePath",image.getNocomprePath());
            map1.put("custNick",customer.getCustNick());
            map1.put("custId",customer.getCustId());
            list.add(map1);
        }
        map.put("customerList",list);
        return map;
    }


    @Override
    public Integer deleteById(Integer id) {
        return customerDao.deleteByPrimaryKey(id);
    }

    @Override
    public Integer update(Customer entity) {
        return null;
    }


    @Override
    public Integer save(Customer entity) {
        return null;
    }

    @Override
    public List<Customer> findAll() {  return customerDao.selectByExample(null); }

    @Override
    public Customer findById(Integer id) {
        return customerDao.selectByPrimaryKey(id);
    }










}
