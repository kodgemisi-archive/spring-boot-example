package com.kodgemisi.webapps.inventory.service;

import com.kodgemisi.webapps.inventory.domain.Item;
import com.kodgemisi.webapps.inventory.domain.ItemAddForm;
import com.kodgemisi.webapps.inventory.domain.User;
import com.kodgemisi.webapps.inventory.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by sedat on 26.06.2015.
 */

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final UserService userService;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository, UserService userService) {
        this.itemRepository = itemRepository;
        this.userService = userService;
    }

    public Item getItemByCode(String code) {
        Iterator iterator = itemRepository.findAll().iterator();

        while (iterator.hasNext()) {
            Item item = (Item) iterator.next();
            if (item.getInventoryCode().equals(code))
                return item;
        }

        return null;
    }

    public Item getItemById(long id) {
        return itemRepository.findOne(id);
    }

    public void addItem(ItemAddForm form) {
        for (int i = 0; i < form.getAmount(); i++) {
            String inventoryCode = Long.toHexString(Double.doubleToLongBits(Math.random())).substring(10);
            Item item = new Item(inventoryCode, form.getItemType());
            itemRepository.save(item);
        }
    }

    public Iterable<Item> getItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item assignItem(String username, long itemId) {
        User user = userService.getUserByUsername(username);
        Item item = getItemById(itemId);
        Set<Item> itemList = user.getItems();
        item.setUser(user);
        itemList.add(item);
        user.setItems(itemList);

        return itemRepository.save(item);
    }

    public void deleteItemById(long id) {
        itemRepository.delete(id);
    }
}
