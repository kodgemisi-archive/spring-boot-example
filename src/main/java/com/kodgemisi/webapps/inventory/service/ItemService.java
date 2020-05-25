package com.kodgemisi.webapps.inventory.service;


import com.kodgemisi.webapps.inventory.domain.Item;
import com.kodgemisi.webapps.inventory.domain.ItemAddForm;

public interface ItemService {

    void addItem(ItemAddForm form);

    Iterable<Item> getItems();

    void deleteItemById(long id);

    Item getItemById(long id);

    Item assingItem(String username, long itemId);

}
