package com.example.forum.services.roles;

import com.example.forum.models.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    Optional<Role> getUserById(Long id);
    List<Role> getAllUsers();

    Role saveUser(Role role);

    void deleteUserById(Long id);
    Role findRoleByName(String roleName);

}
