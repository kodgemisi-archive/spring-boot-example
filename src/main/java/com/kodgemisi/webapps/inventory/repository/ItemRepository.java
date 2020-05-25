package com.kodgemisi.webapps.inventory.repository;

import com.kodgemisi.webapps.inventory.domain.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {
    Item findByInventoryCode(String inventoryCode);
}
