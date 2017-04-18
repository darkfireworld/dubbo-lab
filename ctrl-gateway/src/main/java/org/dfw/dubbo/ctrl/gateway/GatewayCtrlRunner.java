package org.dfw.dubbo.ctrl.gateway;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.config.*;
import com.alibaba.dubbo.config.spring.AnnotationBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * GatewayCtrlRunner
 */
@Configuration
public class GatewayCtrlRunner {
    static public void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("org.dfw.dubbo");
        GatewayCtrl gatewayCtrl = applicationContext.getBean(GatewayCtrl.class);
        gatewayCtrl.callEchoService();
    }

    @Bean
    public ApplicationConfig applicationConfig() {
        return new ApplicationConfig("ctrl-gateway");
    }

    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("zookeeper://ubuntu-1:2181/dubbo?client=curator");
        return registryConfig;
    }

    @Bean
    public ProviderConfig providerConfig() {
        ProviderConfig providerConfig = new ProviderConfig();
        providerConfig.setVersion("1.0.0");
        providerConfig.setProtocol(new ProtocolConfig("dubbo", 20880));
        return providerConfig;
    }

    @Bean
    public ConsumerConfig consumerConfig() {
        ConsumerConfig consumerConfig = new ConsumerConfig();
        consumerConfig.setVersion("1.0.0");
        return consumerConfig;
    }

    @Bean
    public AnnotationBean annotationBean() {
        return new AnnotationBean();
    }

    @Bean
    public MonitorConfig monitorConfig() {
        MonitorConfig monitorConfig = new MonitorConfig();
        monitorConfig.setProtocol(Constants.REGISTRY_PROTOCOL);
        return monitorConfig;
    }
}
