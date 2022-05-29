package com.example.forum;

import com.example.forum.models.Role;
import com.example.forum.models.User;
import com.example.forum.repositories.UserRepository;
import com.example.forum.services.roles.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ForumApplication {
    @Autowired
    UserRepository repository;
    @Autowired
    RoleService roleService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    public static void main(String[] args) {
        SpringApplication.run(ForumApplication.class, args);
    }
    @Bean
    public CommandLineRunner loadData() {
        return (args) -> {
            // create admin user
            User u = repository.getUserByUsername("admin");
            if (u == null) {
                User admin = new User();
                admin.setEmail("admin");
                admin.setFirstName("adminowski");
                admin.setLastName("adminowski");
                admin.setPassword(passwordEncoder.encode("admin"));
                Set<Role> roles = new HashSet<>();
                roles.add(new Role("ROLE_ADMIN"));
                roles.add(new Role("ROLE_USER"));
                admin.setRoles(roles);
                repository.save(admin);
                System.out.println("UTWORZONO ADMINA");
            }
            System.out.println("ADMIN: GIT");
        };
    }
}
