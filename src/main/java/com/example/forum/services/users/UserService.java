package com.example.forum.services.users;

import com.example.forum.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {
    Optional<User> getUserById(Long id);
    List<User> getAllUsers();

    User saveUser(User user);

    void deleteUserById(Long id);
    User registerDefaultUser(User user);
}
