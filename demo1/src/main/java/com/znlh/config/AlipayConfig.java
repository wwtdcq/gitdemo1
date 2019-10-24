package com.znlh.config;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
public class AlipayConfig {

    //↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
    //网关
    private String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    private String app_id = "2016101100664123";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCJ+92rUOQJqv8ylNixYCQfeWpqd5UEgeaKjBqTXFJt+Yox6rzroTuSHyrOd5sQMS14hTMEXrymEqdC5+QGMNufNZNxHY0bl2j86KDO5N+NdFo+WPTEQElQGDfmTc1JdD5RgmAJbdt2l7ZTDk4ry9wLCS9t5St4llihM1m4HCA34L+upnve91Ie67Pd7IkBTXfq7/LkCQk5ebZFRj/Xy0vV/AfYtYe4JdwWkmFe3tkMgrtJGkR1RtOqKYbMHxOzyB2wSR8lP4apcaGQ5LkT5ADkwmllHGMiduZntIFgmK9KjqYDao49pVbXxU/yyWn+R1Yot9eTNyl9LJq/Eq0wRSOrAgMBAAECggEAHhp/ABNDzQArcQOcSwZomx1IJDY2oqccfvmWCrRHn4qjpcRKtzWT44s9MZJSmDPCcdrNiJSKn8jOCQDCdL9QCuoLYtBJqs1bsGGoQ7sXMqtBzPxnWjGUTQ8bkvlCYlYkCnBhN21qRfNPactjLpbpSNcWK+mllEdoyrKDTnGEbewefR4tv6Ofdrv3M0EHHc2ZwC4OEeOp5a5e+QkRAHZYJkZrXGsi2IzmOL8vm4R6stticvl5i1DCNDn3dLaiiSh8JR3yM07vl5h6f8WS0ub3d3m+gmTiX0lyci+7MT/OwJY4xkjPHtuMhL2EECw0XbS1p7pM+TFsrtR4th230rsIcQKBgQDHphLYQqsaKHltTsT9LmIPJfvrnrf8rseejqv4I6Hv3f8fiuLOsFTR6i7zgkmePoUdlh1EuRQ1e4d5KizzNzl4lZS746hF6JVhgLMhJg+uVS5cpyUlewtgCzcHKiAjD5fdSYzVTyTTUkJ0ttlRslNNw/tDFImz25XeNo3yEgof3wKBgQCw7hoNJL329mu5RSH9N36qKS/KHBG00iqB3MZJ99pIFWCJAC4MppA2FPGoLqf0PJFpu8x33GKA32Jat7dXdRcyqkxES2sDMBUdErwg7TBGIIxQtJg5rRTDkNcMHiN3D13j5WrklssUZn/xAv8W3a1tsJ38h5ZB4eGoU4yJ1irFtQKBgQDDK6uydAIWUUjbPay/IM/FpUlPvlp4j1gfvbOJoTPWbLvR1xEAI0rX5so9TLmxE8dH9A7qts91tSvrm/pTTUJGilvbDaPbq5IUvh7fIfkkYKsw8kkTCeVF39DMlTbTb5PzRMqDYJpMZ1cGCBYMknpzREpl+jbfd6NblxNOeKojGwKBgFAvuTLXwhiZWf0freXbLtbjz7rjucqfrZAphNylLhKZTaUJpdUp8BXyrAszCf+RK74l1OdFxIbvtt2yga9ra9YUhHg3Tgql0gvZH9Y0aTp/Kdix4IPTQ6PWkv/08NHW7xCIO0faZ7OZOMb8OqwcT6t07kUzFhBJ1UG6i+k0XTI5AoGBAL10DThEBZlMxDGqB+iVCKX6rawaGHPkSXuKryvu9hJ+ceM0vfEBMiifUzy9pGn2yTjhLaCVkFpZXmbPgZddGptjwRNuS5YdDuuBEwbOzOgKMDLKM088/WepZRGra60HLdmpcEMuvRQ8Ot5t6xqOoNfcgt3VMRU8gonV1t/Dv23V";

    //格式
    private String formate = "JSON";

    // 字符编码格式
    public String charset = "utf-8";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public  String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEApPnCxzapzqc/hmhMNt4KYSXWv9dcdfnKrMLTUOV0qluNGqaaEN3PNrhzO56122N0KURDmLt60Wm4BQGTLe7i20hMaGsqjl/OwUTIBBgR/FjZ3UBSEhWX+PkP+lfCQqVbtC7qI46ijEEl6fzxOtr9fDBnTnnqdYFla5wUGvLNe8g+9BkW8vf3kcoKoDqa8iu+KbP+9TmutiwuCKDZyx/87jYgtihH+Dpj/fd0FsN+sZovsnA3aAe6WuZQeN22wupYiA4PGCx6cTWmyzP9GqzMmnngtu1/bxQFUbcFl/t6DgM6mYUPMCpHiGIlduO0AZdGSZewsR0ASC4YDUeNkZYWiwIDAQAB";

    // 签名方式
    public String sign_type = "RSA2";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public  String notify_url = "http://c3cnr3.natappfree.cc/notifyUrl";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public String return_url = "http://c3cnr3.natappfree.cc/returnUrl";

    // 支付宝网关
    public String log_path = "C:\\";
    
    //时间戳
    public String time_stamp="2014-07-24 03:07:50";
    
    //接口版本
    public String version = "1.0";

    public String getTime_stamp() {
        return time_stamp;
    }

    public void setTime_stamp(String time_stamp) {
        this.time_stamp = time_stamp;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getGatewayUrl() {
        return gatewayUrl;
    }

    public void setGatewayUrl(String gatewayUrl) {
        this.gatewayUrl = gatewayUrl;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getMerchant_private_key() {
        return merchant_private_key;
    }

    public void setMerchant_private_key(String merchant_private_key) {
        this.merchant_private_key = merchant_private_key;
    }

    public String getFormate() {
        return formate;
    }

    public void setFormate(String formate) {
        this.formate = formate;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getAlipay_public_key() {
        return alipay_public_key;
    }

    public void setAlipay_public_key(String alipay_public_key) {
        this.alipay_public_key = alipay_public_key;
    }

    public String getSign_type() {
        return sign_type;
    }

    public void setSign_type(String sign_type) {
        this.sign_type = sign_type;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }

    public String getReturn_url() {
        return return_url;
    }

    public void setReturn_url(String return_url) {
        this.return_url = return_url;
    }

    public String getLog_path() {
        return log_path;
    }

    public void setLog_path(String log_path) {
        this.log_path = log_path;
    }

    @Bean
    public AlipayClient alipayClient(){
        return new DefaultAlipayClient(this.getGatewayUrl(),
                this.getApp_id(),
                this.getMerchant_private_key(),
                this.getFormate(),
                this.getCharset(),
                this.getAlipay_public_key(),
                this.getSign_type());
    }
}
