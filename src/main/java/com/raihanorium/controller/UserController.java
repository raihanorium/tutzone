package com.raihanorium.controller;

import com.raihanorium.model.User;
import com.raihanorium.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Raihan on 6/30/2016.
 */

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getAll() {
        return userService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User get(@PathVariable(value = "id") long id) {
        return userService.get(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public User create(@RequestBody String userName) {
        return userService.create(userName);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable(value = "id") long id) {
        return userService.delete(id);
    }
}
