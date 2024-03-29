package com;

import com.bean.TUser;
import com.bean.TUserExample;
import com.mapper.TUserMapper;
import com.service.UserService;
import java.util.List;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableDubbo
public class UserApplication {

  @Autowired
  TUserMapper tUserMapper;

  @Reference
  UserService UserService;

  public static void main(String[] args) {
    SpringApplication.run(UserApplication.class, args);
  }

  @RequestMapping({"/", "/home"})
  String home() {

    TUser TUser = new TUser();
    TUser.setId(1L);
    TUser.setNickname("李四");
    TUser.setUsername("admin");
    TUser.setPassword("123456");
    tUserMapper.updateByPrimaryKey(TUser);

    TUserExample example = new TUserExample();
    example.createCriteria().andUsernameEqualTo("admin");

    List<com.bean.TUser> tUsers = tUserMapper.selectByExample(example);

    String nickName = UserService.getNickName(1L);

    return nickName;
  }
}
