package com.kodgemisi.webapps.inventory.service;

import com.kodgemisi.webapps.inventory.domain.ItemAddForm;
import com.kodgemisi.webapps.inventory.domain.Item;
import com.kodgemisi.webapps.inventory.domain.User;

import java.util.List;

/**
 * Created by sedat on 26.06.2015.
 */

public interface ItemService {
    Item getItemById(long id);

    void addItem(ItemAddForm form);

    Iterable<Item> getItems();

    Item assignItem(User user, long itemId);

    void deleteItemById(long id);
}
