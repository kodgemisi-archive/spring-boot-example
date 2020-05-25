package com.kodgemisi.webapps.inventory.service;

import com.kodgemisi.webapps.inventory.domain.Item;
import com.kodgemisi.webapps.inventory.domain.ItemAddForm;
import com.kodgemisi.webapps.inventory.domain.User;
import com.kodgemisi.webapps.inventory.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final UserService userService;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository, UserService userService) {
        this.itemRepository = itemRepository;
        this.userService = userService;
    }


    @Override
    public void addItem(ItemAddForm form) {

        for (int i = 0; i < form.getAmount(); i++) {
            String inventoryCode = Long.toHexString(Double.doubleToLongBits(Math.random())).substring(0, 5);
            Item item = new Item(inventoryCode, form.getItemType());
            itemRepository.save(item);
        }
    }

    @Override
    public Iterable<Item> getItems() {
        return itemRepository.findAll();
    }

    @Override
    public void deleteItemById(long id) {
        itemRepository.deleteById(id);
    }

    @Override
    public Item getItemById(long id) {
        return itemRepository.findById(id).get();
    }

    @Override
    public Item assingItem(String username, long itemId) {
        User user = userService.getUserByUsername(username);
        Item item = getItemById(itemId);

        Set<Item> itemList = user.getItems();
        itemList.add(item);
        user.setItems(itemList);

        item.setUser(user);
        System.out.println(item.getType() + " assigned to " + user.getUsername() + " " + user.getId());
        return itemRepository.save(item);

    }
}
