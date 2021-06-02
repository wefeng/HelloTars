package com.tencent.tars.client.testapp.controller;

import com.qq.tars.spring.annotation.TarsClient;
import com.qq.tars.spring.annotation.TarsHttpService;
import com.tencent.tars.client.testapp.HelloPrx;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@TarsHttpService("HttpObj")
@RestController
public class TestController {

  @TarsClient("hello.helloServer.HelloObj")
  HelloPrx helloPrx;

  @RequestMapping("/hello")
  public String testHello(@RequestParam Integer no) {
    String ret = helloPrx.hello(no, "Hello World");
    return ret;
  }
}
