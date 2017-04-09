package org.dfw.dubbo.api.echo;


import com.alibaba.dubbo.config.*;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.config.spring.AnnotationBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Echo Service
 */
@Service
@Component
public class EchoServiceImpl implements EchoService {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    public String echo(String name) {
        //logger.info("RECV：{}", name);
        return "HELLO：" + name;
    }
}
