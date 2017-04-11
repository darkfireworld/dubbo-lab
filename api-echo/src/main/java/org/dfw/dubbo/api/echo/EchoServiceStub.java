package org.dfw.dubbo.api.echo;

/**
 * EchoServiceStub
 */
public class EchoServiceStub implements EchoService {
    EchoService echoService;

    public EchoServiceStub(EchoService echoService) {
        this.echoService = echoService;
    }

    public String echo(String name) {
        try {
            return echoService.echo(name);
        } catch (Exception e) {
            return null;
        }
    }
}
