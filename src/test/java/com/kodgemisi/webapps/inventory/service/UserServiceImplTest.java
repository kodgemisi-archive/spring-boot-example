package com.kodgemisi.webapps.inventory.service;

import com.kodgemisi.webapps.inventory.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @MockBean
    RestTemplate template;

    @Test
    void setUp(){
        User user = new User("yigit123","abc123456");
        user.setName("Yigit");
        user.setLastName("Yasin");
        userService.addUser(user);
    }

    @Test
    void addUser() {
        User user = new User("yyigit","abc123456");
        user.setName("Yasin");
        user.setLastName("Yigit");
        userService.addUser(user);
        User found = userService.getUserByUsername(user.getUsername());
        assertThat(found.getUsername()).isEqualTo("yyigit");
    }

    @Test
    void getUsers() {
        Iterable<User> users = userService.getUsers();
        List<User> userList = new ArrayList<User>();
        users.forEach(userList::add);

        assertThat(userList.size()).isEqualTo(2);
    }

    @Test
    void getUsernames() {
        Iterable<User> users = userService.getUsers();
        List<String> usernameList = new ArrayList<String>();
        users.forEach(user -> usernameList.add(user.getUsername()));

        assertThat(usernameList).contains("yigit123", "yyigit");
    }

    @Test
    void getUserByUsername() {

    }

    @Test
    void getUserById() {
    }

    @Test
    void numberOfItemsByType() {
    }

    @Test
    void loadUserByUsername() {
    }
}