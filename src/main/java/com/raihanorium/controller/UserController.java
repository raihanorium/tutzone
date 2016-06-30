package com.raihanorium.controller;

import com.raihanorium.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raihan on 6/30/2016.
 */

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getAll(){
        List<User> users = new ArrayList<>();

        users.add(new User(1, "Cheater 1"));
        users.add(new User(2, "Cheater 2"));
        users.add(new User(3, "Cheater 3"));

        return users;
    }
}
