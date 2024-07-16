package com.neu.api.properties;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "neu.alipay")
@Component
@Data
public class AliPayProperties {
    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public String appId;

    // 应用私钥，就是工具生成的应用私钥
    public String merchantPrivateKey;

    // 支付宝公钥,对应APPID下的支付宝公钥。
    public String alipayPublicKey;

    // 支付宝会悄悄的给我们发送一个请求，告诉我们支付成功的信息
    public String notifyUrl;

    //同步通知，支付成功，一般跳转到成功页
    public String returnUrl;

    // 签名方式
    public String signType;

    // 字符编码格式
    public String charset;

    //支付超时时间
    public String timeout;

    public String gatewayUrl;
}
