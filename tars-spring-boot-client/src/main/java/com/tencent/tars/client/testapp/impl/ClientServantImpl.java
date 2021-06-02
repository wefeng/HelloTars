package com.tencent.tars.client.testapp.impl;

import com.qq.tars.common.support.Holder;
import com.qq.tars.spring.annotation.TarsClient;
import com.qq.tars.spring.annotation.TarsServant;
import com.tencent.tars.client.testapp.ClientServant;
import com.tencent.tars.client.testapp.HelloPrx;
import com.tencent.tars.client.testapp.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;


@TarsServant("ClientObj")
public class ClientServantImpl implements ClientServant {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientServantImpl.class);
    @TarsClient("hello.helloServer.HelloObj")
    HelloPrx helloPrx;

    @Override
    public String rpcHello(int no, String name) {
        String syncResult = helloPrx.hello(1000, name);
        //promise调用
        helloPrx.promise_hello(1000, name).thenCompose(x -> {
            String res = "promise_result: " + x;
            LOGGER.info("promise result :{}", res);
            return CompletableFuture.completedFuture(0);
        });
        return syncResult;
    }

    @Override
    public String helloWithArguments(int no, String name) {
        Holder<List<User>> resp = new Holder<>();
        int ret = helloPrx.getAllUserInfo(resp);
        LOGGER.info("get result" + ret);
        if (ret >= 0) {
            return resp.getValue().toString();
        }
        return null;
    }
}
