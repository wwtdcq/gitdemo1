package com.znlh.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.znlh.config.AlipayConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class AlipayController {
    @Autowired
    AlipayClient alipayClient;
    @Autowired
    AlipayConfig alipayConfig;
    @RequestMapping("alipay")
    public void alipay(HttpServletRequest httpRequest, HttpServletResponse httpResponse)throws ServletException, IOException{
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();// 创建API对应的request
        alipayRequest.setReturnUrl(alipayConfig.getReturn_url());
        alipayRequest.setNotifyUrl(alipayConfig.getNotify_url());// 在公共参数中设置回跳和通知地址
        alipayRequest.setBizContent("{" +
                "    \"out_trade_no\":\"20150320010101009\"," +
                "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," +
                "    \"total_amount\":88.88," +
                "    \"subject\":\"Iphone6 16G\"," +
                "    \"body\":\"Iphone6 16G\"," +
                "    \"passback_params\":\"merchantBizType%3d3C%26merchantBizNo%3d2016010101111\"," +
                "    \"extend_params\":{" +
                "    \"sys_service_provider_id\":\"2088511833207846\"" +
                "    }"+
                "  }");//填充业务参数
        AlipayTradePagePayResponse response=null;
        String form = "";
        try {
            response = alipayClient.pageExecute(alipayRequest); // 调用SDK生成表单
            System.out.println(response.toString());
            form = response.getBody();
            System.out.println(form);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        httpResponse.setContentType("text/html;charset=" + alipayConfig.getCharset());
        httpResponse.getWriter().write(form);// 直接将完整的表单html输出到页面
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
    }

    //所以应该是首先会发送一个异步的通知给到商户的服务端，商户的服务端收到这个通知后获取里面的返回参数，然后
    //根据参数来决定是否付款成功
    @RequestMapping("notifyUrl")
    public void alipayNotify(HttpServletRequest request, HttpServletResponse response){
        //Map<String, String> resultDataMap = alipayService.getPayResultMap(request);
        String code = request.getParameter("code");
        System.out.println("notify:"+code);
    }

    @RequestMapping("returnUrl")
    public void alipayReturnUrl(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Map<String, String> resultDataMap = alipayService.getPayResultMap(request);
        String code = request.getParameter("code");
        System.out.println("return:"+code);
        request.getRequestDispatcher("/success.jsp").forward(request,response);
    }
    
}
