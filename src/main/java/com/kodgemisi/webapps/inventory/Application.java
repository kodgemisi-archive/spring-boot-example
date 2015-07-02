package com.kodgemisi.webapps.inventory;

/**
 * Created by sedat on 26.06.2015.
 */

import com.kodgemisi.webapps.inventory.domain.Item;
import com.kodgemisi.webapps.inventory.domain.User;
import com.kodgemisi.webapps.inventory.repository.ItemRepository;
import com.kodgemisi.webapps.inventory.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class Application implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;

    @Autowired
    ItemRepository itemRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    public void run(String... strings) throws Exception {
        Item item1 = new Item("123S", "Bilgisayar");
        Item item2 = new Item("358G", "Bilgisayar");
        Item item3 =  new Item("158A", "Bilgisayar");
        Item item4 = new Item("935C", "Telefon");

        Set set1 = new HashSet<Item>();
        set1.add(item1);
        set1.add(item3);
        set1.add(item4);

        Set set2 = new HashSet<Item>();
        set2.add(item2);

        User user1 = new User("sedo", "123456");
        user1.setName("Sedat");
        user1.setLastName("Gökcen");
        user1.setItems(set1);

        User user2 = new User("hool", "hoo123");
        user2.setName("Hool");
        user2.setLastName("Gökcen");
        user2.setItems(set2);

        item1.setUser(user1);
        item3.setUser(user1);
        item4.setUser(user1);

        item2.setUser(user2);

        userRepository.save(user1);
        userRepository.save(user2);

        itemRepository.save(item1);
        itemRepository.save(item2);
        itemRepository.save(item3);
        itemRepository.save(item4);
    }
}
