package com.raihanorium.service;

import com.raihanorium.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raihan on 6/30/2016.
 */

public class UserServiceMockImpl implements UserService {
    List<User> users;

    public UserServiceMockImpl() {
        List<User> users = new ArrayList<>();

        users.add(new User(1, "Cheater 1"));
        users.add(new User(2, "Cheater 2"));
        users.add(new User(3, "Cheater 3"));

        this.users = users;
    }

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public boolean delete(long id) {
        for (User user : users) {
            if (user.getId() == id) {
                users.remove(user);
                return true;
            }
        }

        return false;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public User get(long id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }

        return null;
    }

    @Override
    public User create(String userName) {
        User user = new User((users.size() + 1), userName);
        users.add(user);
        return user;
    }
}
