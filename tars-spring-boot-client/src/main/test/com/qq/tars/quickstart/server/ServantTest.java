package com.qq.tars.quickstart.server;

import com.tencent.tars.App;
import com.tencent.tars.client.testapp.ClientServant;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class ServantTest {

  @Autowired
  private ClientServant clientServant;

  @Test
  public void test() {
    String hello = clientServant.rpcHello(1, "test");
    Assert.assertNotNull(hello);
  }
}