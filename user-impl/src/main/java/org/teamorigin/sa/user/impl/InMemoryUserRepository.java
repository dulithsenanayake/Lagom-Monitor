package org.teamorigin.sa.user.impl;

import org.teamorigin.sa.user.api.User;

import java.util.HashMap;
import java.util.Map;

public class InMemoryUserRepository implements UserRepository {

    Map<String,User> userMap = new HashMap<>();

    public InMemoryUserRepository() {

        User user1 = new User(
                "Dulith",
                "951450847v",
                "0774040365");

        userMap.put(user1.getId(),user1);

    }

    @Override
    public User getUserById(String id) {
        if( userMap.containsKey(id)){
            return userMap.get(id);
        }
        return null;
    }

    @Override
    public void addUser(User user) {
        userMap.put(user.getId(),user);
    }
}


