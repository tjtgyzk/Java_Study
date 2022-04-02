package edu.xdu.dao;

import org.springframework.stereotype.Component;

@Component("default")
public class UserDaoImpl implements UserDao {
    @Override
    public void getUser() {
        System.out.println("默认获取用户数据");
    }


}
