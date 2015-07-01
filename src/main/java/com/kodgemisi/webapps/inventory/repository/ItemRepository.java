package com.kodgemisi.webapps.inventory.repository;

import com.kodgemisi.webapps.inventory.domain.Item;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by sedat on 26.06.2015.
 */

@RepositoryRestResource(collectionResourceRel = "items", path = "items")
public interface ItemRepository extends PagingAndSortingRepository<Item, Long> {

}
