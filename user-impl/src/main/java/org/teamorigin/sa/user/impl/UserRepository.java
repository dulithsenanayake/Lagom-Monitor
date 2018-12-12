package org.teamorigin.sa.user.impl;

import com.google.inject.ImplementedBy;
import org.teamorigin.sa.user.api.User;

@ImplementedBy(InMemoryUserRepository.class)
public interface UserRepository {

    User getUserById(String id);
    void addUser(User user);

}

