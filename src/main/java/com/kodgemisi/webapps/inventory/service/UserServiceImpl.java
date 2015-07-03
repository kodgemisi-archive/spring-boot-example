package com.kodgemisi.webapps.inventory.service;

import com.kodgemisi.webapps.inventory.domain.Item;
import com.kodgemisi.webapps.inventory.domain.User;
import com.kodgemisi.webapps.inventory.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by sedat on 26.06.2015.
 */

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(long id) {
        return userRepository.findOne(id);
    }

    public User getUserByUsername(String username) {
        Iterator iterator = userRepository.findAll().iterator();

        while (iterator.hasNext()) {
            User user = (User) iterator.next();
            if (user.getUsername().equalsIgnoreCase(username))
                return user;
        }

        return null;
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    public Map<String, List<Item>> numberOfItemsByType(long userId) {
        Map<String, List<Item>> map = new HashMap<String, List<Item>>();
        Set<Item> items = getUserById(userId).getItems();

        for (Item item: items) {
            List<Item> itemList = new ArrayList<Item>();
            String key = item.getType().toLowerCase();

            if (map.containsKey(key))
                itemList = map.get(key);

            itemList.add(item);
            map.put(key, itemList);
        }

        return map;
    }

    public List<String> getUsernames() {
        List<String> usernames = new ArrayList<String>();
        Iterator iterator = getUsers().iterator();

        while (iterator.hasNext()) {
            User user = (User) iterator.next();
            usernames.add(user.getUsername());
        }

        return usernames;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = getUserByUsername(username);
        List<SimpleGrantedAuthority> auth = (List<SimpleGrantedAuthority>) user.getAuthorities();

        if (null == user) {
            throw new UsernameNotFoundException("User with username: " + username + " not found.");
        } else {
            return user;
        }
    }
}
