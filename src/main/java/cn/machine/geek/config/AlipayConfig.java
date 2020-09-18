package cn.machine.geek.config;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "alipay")
public class AlipayConfig {
    private String appId;
    private String gateway;
    private String applicationPrivateKey;
    private String applicationPublicKey;
    private String alipayPublicKey;

    @Bean
    public AlipayClient alipayClient(){
        return new DefaultAlipayClient(gateway,appId,applicationPrivateKey,"json","UTF-8",alipayPublicKey,"RSA2");
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getGateway() {
        return gateway;
    }

    public void setGateway(String gateway) {
        this.gateway = gateway;
    }

    public String getApplicationPrivateKey() {
        return applicationPrivateKey;
    }

    public void setApplicationPrivateKey(String applicationPrivateKey) {
        this.applicationPrivateKey = applicationPrivateKey;
    }

    public String getApplicationPublicKey() {
        return applicationPublicKey;
    }

    public void setApplicationPublicKey(String applicationPublicKey) {
        this.applicationPublicKey = applicationPublicKey;
    }

    public String getAlipayPublicKey() {
        return alipayPublicKey;
    }

    public void setAlipayPublicKey(String alipayPublicKey) {
        this.alipayPublicKey = alipayPublicKey;
    }
}
