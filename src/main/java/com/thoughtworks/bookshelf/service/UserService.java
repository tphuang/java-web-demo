package com.thoughtworks.bookshelf.service;

import com.thoughtworks.bookshelf.entity.User;
import com.thoughtworks.bookshelf.util.UserInfoEmptyException;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    void saveUser(User user) throws UserInfoEmptyException, SQLException, ClassNotFoundException;
    List<User> findAllUsers() throws SQLException, ClassNotFoundException;
}
