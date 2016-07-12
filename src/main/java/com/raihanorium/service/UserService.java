package com.raihanorium.service;

import com.raihanorium.model.User;
import com.raihanorium.util.Page;

/**
 * Created by Raihan on 7/10/2016.
 */
public interface UserService {
    Page getAll(Page page);

    User get(long id);

    User create(String userName);

    boolean delete(long id);

    User update(User user);
}
