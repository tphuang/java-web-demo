package com.thoughtworks.bookshelf.service.impl;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.thoughtworks.bookshelf.dao.UserDao;
import com.thoughtworks.bookshelf.entity.User;
import com.thoughtworks.bookshelf.service.UserService;
import com.thoughtworks.bookshelf.util.UserInfoEmptyException;

@Component
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public void saveUser(User user) throws UserInfoEmptyException, SQLException, ClassNotFoundException {
        if (user.getUserName().trim().isEmpty() || user.getPassWord().trim().isEmpty()) {
            throw new UserInfoEmptyException("userName or passWord should not be empty!");
        }
        userDao.createUsers(user);
    }

    public List<User> findAllUsers() throws SQLException, ClassNotFoundException {
        List<User> users = new ArrayList<User>();
        users = userDao.findAllUsers();
        return users;
    }

}
