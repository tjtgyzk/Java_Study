package edu.xdu.service;

import edu.xdu.dao.UserDao;
import edu.xdu.dao.UserDaoImpl;
import edu.xdu.dao.UserDaoMysqlImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl() throws ClassNotFoundException {
    }

    @Qualifier("mySql")
    @Autowired()
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void getUser() {
        userDao.getUser();
    }


}
