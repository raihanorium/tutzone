package com.raihanorium.service;

import com.raihanorium.model.User;

import java.util.List;

/**
 * Created by Raihan on 7/10/2016.
 */
public interface UserService {
    List<User> getAll();

    User get(long id);

    User create(String userName);

    boolean delete(long id);
}
