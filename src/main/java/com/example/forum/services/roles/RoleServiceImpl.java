package com.example.forum.services.roles;


import com.example.forum.models.Role;
import com.example.forum.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Optional<Role> getUserById(Long id) {
        return roleRepository.findById(id);
    }

    @Override
    public List<Role> getAllUsers() {
        return roleRepository.findAll();
    }

    @Override
    public Role saveUser(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void deleteUserById(Long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public Role findRoleByName(String roleName) {
        Role role= roleRepository.findByName(roleName);
        if (role == null){
            if(roleName == "USER"){
                role = roleRepository.save(new Role("USER"));
            }
        }
        return role;
    }

}
