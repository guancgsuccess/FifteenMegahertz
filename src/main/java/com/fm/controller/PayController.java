package com.fm.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.fm.constant.AliPayConfig;
import com.fm.entity.Customer;
import com.fm.entity.common.ServerResponse;
import com.fm.service.CustomerService;
import com.fm.service.ShootOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 * Created on 2018/10/24.
 *
 * @author guochangji
 */
@SuppressWarnings("all")
@Controller
@RequestMapping("/pay")
public class PayController {
    private String outTradeNo;
    private boolean isPaying=false;
    private Integer totalAmount;
    private boolean shootPay = false;
    private Integer orderId;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ShootOrderService shootOrderService;

    private AlipayClient alipayClient = new DefaultAlipayClient(AliPayConfig.ALIPAY_GATEWAY, AliPayConfig.APP_ID, AliPayConfig.PRIVATE_KEY,AliPayConfig.FORMAT, AliPayConfig.CHARSET, AliPayConfig.ALIPAY_KEY, AliPayConfig.SIGN_TYPE);

    @RequestMapping("go2Pay/{totalAmount}")
    @ResponseBody
    public void getQRCode(@PathVariable  Integer totalAmount, HttpServletResponse httpResponse) throws IOException, AlipayApiException {
        //配置alipay实例
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        outTradeNo="tradeprecreate" + System.currentTimeMillis()+ (long) (Math.random() * 10000000L);
        this.totalAmount=totalAmount;
        alipayRequest.setBizContent("{" +
                "    \"out_trade_no\":\""+outTradeNo+"\"," +
                "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," +
                "    \"total_amount\":"+totalAmount+"," +
                "    \"subject\":\"15M摄影充值\"," +
                "    \"body\":\"15M摄影会员积分充值\"," +
                "    \"passback_params\":\"merchantBizType%3d3C%26merchantBizNo%3d2016010101111\"," +
                "    \"extend_params\":{" +
                "    \"sys_service_provider_id\":\"2088511833207846\"" +
                "    }"+
                "  }");
        alipayRequest.setReturnUrl("http://www.gcc666.top:8080/view/personal");
        String form="";
        try {
            form = alipayClient.pageExecute(alipayRequest).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        //直接将完整的表单html输出到页面
        httpResponse.setContentType("text/html;charset=" + AliPayConfig.CHARSET);
        httpResponse.getWriter().write(form);
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
        this.isPaying=true;
    }

    /**
     * 支付宝异步通知
     * @param request
     * @param response
     * @throws IOException
     */
    @PostMapping("callback")
    @ResponseBody
    public void getPayResult(HttpServletRequest request,HttpServletResponse response) throws IOException {
        //将异步通知中收到的所有参数都存放到map中
        Map<String, String> paramsMap = new HashMap<>();
        Map requestParams = request.getParameterMap();
        for (Iterator it = requestParams.keySet().iterator(); it.hasNext();) {
            String name = (String) it.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }

            // 乱码解决，这段代码在出现乱码时使用.valueStr = new String(valueStr.getBytes("ISO-8859-1"),"utf-8");
            paramsMap.put(name, valueStr);
        }
        //调用SDK验证签名
        boolean signVerified = false;
        try {
            signVerified = AlipaySignature.rsaCheckV1(paramsMap, AliPayConfig.ALIPAY_KEY, AliPayConfig.CHARSET, AliPayConfig.SIGN_TYPE);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        if(signVerified){
            // TODO 验签成功后，按照支付结果异步通知中的描述，对支付结果中的业务内容进行二次校验，校验成功后在response中返回success并继续商户自身业务处理，校验失败返回failure
            if("TRADE_SUCCESS".equals(paramsMap.get("trade_status"))){
                if(this.customerService.updateCredits(totalAmount, (Integer) request.getSession().getAttribute("custId"))){
                    System.out.println("zhifuchenggong");
                }
            }
            response.getWriter().write("success");
        }else{
            // TODO 验签失败则记录异常日志，并在response中返回failure.
            response.getWriter().write("failure");
        }
    }


    /**
     * 主动查询
     * @return
     */
    @PostMapping("callback2")
    @ResponseBody
    public ServerResponse queryResult(Integer custId,HttpSession session){
        ServerResponse sr;
        if(!custId.equals(session.getAttribute("custId"))){
            return null;
        }
        if(isPaying){
            //创建查询请求的对应request
            AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
            request.setBizContent("{" +
                    "    \"out_trade_no\":\""+outTradeNo+"\"" +
                    "     }");
            AlipayTradeQueryResponse response = null;
            try {
                response = alipayClient.execute(request);
            } catch (AlipayApiException e) {
                sr =ServerResponse.createByFailure("查询交易详情失败!");
            }
            if (response.isSuccess()) {
                if("TRADE_SUCCESS".equals(response.getTradeStatus())){
                    if(this.customerService.updateCredits(totalAmount,custId)){
                        sr =ServerResponse.createBySuccess("充值的"+totalAmount+"积分已到账!",null);
                        isPaying=false;
                        totalAmount=0;
                    }else{
                        isPaying=false;
                        sr =ServerResponse.createByFailure("充值失败!,请重新刷新页面试试");
                    }
                }else {
                    isPaying=false;
                    sr =ServerResponse.createByFailure("支付异常!");
                }
            } else {
                isPaying=false;
                sr =ServerResponse.createByError("订单已取消,充值失败!");
            }
        }else {
            return null;
        }
        return sr;
    }


    @RequestMapping("go2shootPay/{totalAmount}/{orderId}")
    @ResponseBody
    public void getQRCode1(@PathVariable  Integer totalAmount, @PathVariable Integer orderId, HttpServletResponse httpResponse) throws IOException, AlipayApiException {
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        outTradeNo="tradeprecreate" + System.currentTimeMillis()+ (long) (Math.random() * 10000000L);
        this.totalAmount=totalAmount;
        this.orderId = orderId;
        alipayRequest.setBizContent("{" +
                "    \"out_trade_no\":\""+outTradeNo+"\"," +
                "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," +
                "    \"total_amount\":"+totalAmount+"," +
                "    \"subject\":\"15M摄影支付\"," +
                "    \"body\":\"15M摄影定制订单支付\"," +
                "    \"passback_params\":\"merchantBizType%3d3C%26merchantBizNo%3d2016010101111\"," +
                "    \"extend_params\":{" +
                "    \"sys_service_provider_id\":\"2088511833207846\"" +
                "    }"+
                "  }");
        alipayRequest.setReturnUrl("http://www.gcc666.top:8080/view/personal");
        String form="";
        try {
            //调用SDK生成html表单
            form = alipayClient.pageExecute(alipayRequest).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        httpResponse.setContentType("text/html;charset=" + AliPayConfig.CHARSET);
        httpResponse.getWriter().write(form);
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
        this.shootPay = true;
    }

    /**
     * 主动查询
     * @return
     */
    @PostMapping("callback3")
    @ResponseBody
    public ServerResponse queryResult1(Integer custId,HttpSession session){
        ServerResponse sr;
        if(!custId.equals(session.getAttribute("custId"))){
            return null;
        }
        if(shootPay){
            //创建查询请求的对应request
            AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
            request.setBizContent("{" +
                    "    \"out_trade_no\":\""+outTradeNo+"\"" +
                    "     }");
            AlipayTradeQueryResponse response = null;
            try {
                response = alipayClient.execute(request);
            } catch (AlipayApiException e) {
                sr =ServerResponse.createByFailure("查询交易详情失败!");
            }
            if (response.isSuccess()) {
                if("TRADE_SUCCESS".equals(response.getTradeStatus())){
                    if(shootOrderService.updateOrderStatus(orderId,1)!=0){
                        sr = ServerResponse.createBySuccess("订单支付成功",null);
                        this.shootPay=false;
                        totalAmount=0;
                    }else {
                        sr = ServerResponse.createByFailure("支付失败");
                        this.shootPay=false;
                    }
                }else {
                    sr =ServerResponse.createByFailure("支付异常!");
                    this.shootPay=false;
                }
            } else {
                shootPay=false;
                sr =ServerResponse.createByError("订单已取消,支付失败!");
            }
        }else {
            return null;
        }
        return sr;
    }

}
