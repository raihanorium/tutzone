package com.raihanorium.service;

import com.raihanorium.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raihan on 6/30/2016.
 */

@Service
public class UserService {
    List<User> users;

    public UserService() {
        List<User> users = new ArrayList<>();

        users.add(new User(1, "Cheater 1"));
        users.add(new User(2, "Cheater 2"));
        users.add(new User(3, "Cheater 3"));

        this.users = users;
    }

    public List<User> getAll(){
        return users;
    }

    public boolean delete(long id){
        for (User user : users){
            if(user.getId() == id){
                users.remove(user);
                return true;
            }
        }

        return false;
    }

    public User get(long id){
        for (User user : users){
            if(user.getId() == id){
                return user;
            }
        }

        return null;
    }
}
