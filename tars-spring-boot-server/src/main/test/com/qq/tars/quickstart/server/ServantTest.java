package com.qq.tars.quickstart.server;

import com.qq.tars.quickstart.server.testapp.HelloServant;
import com.qq.tars.quickstart.server.testapp.User;
import com.qq.tars.spring.annotation.TarsClient;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServantTest {

  @TarsClient("hello.helloServer.HelloObj")
  private HelloServant helloServant;

  @Test
  public void test() {
    List<User> users = helloServant.getAllUserInfoAsReturn();
    Assert.assertNotNull(users);
    Assert.assertTrue(users.size() > 0);
  }
}
