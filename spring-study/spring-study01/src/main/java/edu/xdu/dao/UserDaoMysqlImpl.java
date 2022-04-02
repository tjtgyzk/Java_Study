package edu.xdu.dao;

import org.springframework.stereotype.Component;

@Component("mySql")
//<bean: id="UserDaoMysqlImpl" value="edu.xdu.dao.UserDaoMysqlImpl"/>
public class UserDaoMysqlImpl implements UserDao {
    @Override
    public void getUser() {
        System.out.println("Mysql读取用户数据");
    }
}
