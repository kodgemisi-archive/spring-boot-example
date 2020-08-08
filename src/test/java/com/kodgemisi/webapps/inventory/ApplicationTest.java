package com.kodgemisi.webapps.inventory;

import static org.assertj.core.api.Assertions.*;
import com.kodgemisi.webapps.inventory.controller.HomeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTest {
    @Autowired
    private HomeController homeController;

    @Test
    public void contextLoads() throws Exception{
        assertThat(homeController).isNotNull();
    }
}