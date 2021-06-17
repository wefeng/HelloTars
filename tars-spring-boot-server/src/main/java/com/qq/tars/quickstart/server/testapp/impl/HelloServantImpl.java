/**
 * Tencent is pleased to support the open source community by making Tars available.
 *
 * Copyright (C) 2016 THL A29 Limited, a Tencent company. All rights reserved.
 *
 * Licensed under the BSD 3-Clause License (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 *
 * https://opensource.org/licenses/BSD-3-Clause
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 * m1
 */

package com.qq.tars.quickstart.server.testapp.impl;

import com.qq.tars.common.support.Holder;
import com.qq.tars.quickstart.server.testapp.BankAccount;
import com.qq.tars.quickstart.server.testapp.HelloServant;
import com.qq.tars.quickstart.server.testapp.User;
import com.qq.tars.spring.annotation.TarsServant;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@TarsServant("HelloObj")
public class HelloServantImpl implements HelloServant {

  private static final Logger LOGGER = LoggerFactory.getLogger(HelloServantImpl.class);

  @Override
  public String hello(int no, String name) {
    return String
        .format("Hello %s! Your emp number is %s at time=%s", name, no, System.currentTimeMillis());
  }

  @Override
  public int getAllUserInfo(Holder<List<User>> resp) {
    List<User> users = returnUser();
    resp.setValue(users);
    return 0;
  }

  @Override
  public List<User> getAllUserInfoAsReturn() {
    return returnUser();
  }

  private List<User> returnUser() {
    BankAccount icbcAccount = new BankAccount("6226", 100);
    BankAccount ccbAccount = new BankAccount("6227", 1000);
    List<BankAccount> bankAccounts = new ArrayList<>();
    bankAccounts.add(icbcAccount);
    bankAccounts.add(ccbAccount);
    User wefeng = new User("wefeng", 36, "ShenZhen", bankAccounts);
    List<User> users = new ArrayList<>();
    users.add(wefeng);
    return users;
  }
}
