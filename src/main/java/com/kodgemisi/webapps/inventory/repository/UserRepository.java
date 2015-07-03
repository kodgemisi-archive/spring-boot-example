package com.kodgemisi.webapps.inventory.repository;

import com.kodgemisi.webapps.inventory.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by sedat on 26.06.2015.
 */

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
