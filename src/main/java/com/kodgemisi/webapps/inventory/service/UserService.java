package com.kodgemisi.webapps.inventory.service;

import com.kodgemisi.webapps.inventory.domain.Item;
import com.kodgemisi.webapps.inventory.domain.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    void addUser(User user);

    Iterable<User> getUsers();

    List<String> getUsernames();

    User getUserByUsername(String username);

    User getUserById(long id);

    Map<String, List<Item>> numberOfItemsByType(long userId);
}
