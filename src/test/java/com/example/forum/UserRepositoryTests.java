package com.example.forum;

import com.example.forum.models.Role;
import com.example.forum.models.User;
import com.example.forum.repositories.RoleRepository;
import com.example.forum.services.users.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepo;

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setEmail("test@gmail.com");
        user.setPassword("test123123");
        user.setFirstName("TestImie");
        user.setLastName("TestNaziwsko");

        User savedUser = userService.saveUser(user);

        User existUser = entityManager.find(User.class, savedUser.getId());

        assertEquals(user.getEmail(), existUser.getEmail());
    }

    @Test
    public void testAddRoleToNewUser() {
        Role roleAdmin = roleRepo.findByName("Admin");

        User user = new User();
        user.setEmail("mikes.gates@gmail.com");
        user.setPassword("mike2020");
        user.setFirstName("Mike");
        user.setLastName("Gates");
        user.addRole(roleAdmin);

        User savedUser = userService.saveUser(user);

        assertEquals(savedUser.getRoles().size(), 1);
    }

    @Test
    public void testAddRoleToExistingUser() {
        User user = userService.getUserById(1L).get();
        Role roleUser = roleRepo.findByName("User");
        Role roleCustomer = new Role(3L);

        user.addRole(roleUser);
        user.addRole(roleCustomer);

        User savedUser = userService.saveUser(user);
        assertEquals(savedUser.getRoles().size(), 2);
    }
}
