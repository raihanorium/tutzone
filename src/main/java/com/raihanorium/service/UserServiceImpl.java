package com.raihanorium.service;

import com.raihanorium.model.User;
import com.raihanorium.util.Page;

/**
 * Created by Raihan on 7/11/2016.
 */
public class UserServiceImpl extends BaseService implements UserService {

    @Override
    public Page getAll(Page page) {
        return getAll(User.class, page);
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

    @Override
    public User update(User user) {
        return (User) save(user);
    }
}
