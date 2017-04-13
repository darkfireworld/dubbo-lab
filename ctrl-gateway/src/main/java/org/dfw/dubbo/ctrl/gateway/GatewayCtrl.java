package org.dfw.dubbo.ctrl.gateway;

import com.alibaba.dubbo.config.annotation.Reference;
import org.dfw.dubbo.api.echo.EchoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * GatewayCtrl
 */
@Component
public class GatewayCtrl {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Reference
    EchoService echoService;

    public void callEchoService() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000 * 10; ++i) {
            echoService.echo(String.valueOf(i));
        }
        long endTime = System.currentTimeMillis();
        logger.info("COST TIME：{}", endTime - startTime);
    }

}
