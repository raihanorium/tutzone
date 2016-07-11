package com.raihanorium.service;

import com.raihanorium.model.User;
import com.raihanorium.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Raihan on 7/11/2016.
 */
public class UserServiceImpl extends BaseService implements UserService {

    @Override
    public List<User> getAll() {
        return getAll(User.class);
    }

    @Override
    public User get(long id) {
        return (User) get(id, User.class);
    }

    @Override
    public User create(String userName) {
        User user = new User();
        user.setName(userName);
        return (User) create(user);
    }

    @Override
    public boolean delete(long id) {
        return delete(id, User.class);
    }
}
