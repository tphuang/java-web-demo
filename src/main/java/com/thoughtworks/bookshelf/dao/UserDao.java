package com.thoughtworks.bookshelf.dao;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.thoughtworks.bookshelf.entity.User;

@Component
@Transactional
public class UserDao {
    @Autowired
    private SessionFactory sessionFactory;
    private Session session;

    public List<User> findAllUsers() {
        session = sessionFactory.getCurrentSession();
        List<User> users = new ArrayList<User>();
        users = session.createCriteria(User.class).list();
        return users;
    }

    public void createUsers(User user) {
        session = sessionFactory.getCurrentSession();
        session.save(user);
    }
}
