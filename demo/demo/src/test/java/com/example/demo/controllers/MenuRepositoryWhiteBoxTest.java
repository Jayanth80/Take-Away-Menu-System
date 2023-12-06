package com.example.repository;

import com.example.model.Menu;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class MenuRepositoryWhiteBoxTest {

    @Autowired
    private MenuRepository menuRepository;

    @Test
    public void testSaveMenu() {
        // Test data
        Menu menu = new Menu();
        menu.setItemName("Test Item");
        menu.setItemPrice("10.99");
        menu.setItemId("123");
        menu.setItemDescription("Test Description");
        menu.setVegNonVeg("Veg");
        menu.setItemCategory("Test Category");

        // Save to repository
        Menu savedMenu = menuRepository.save(menu);

        // Retrieve from repository
        Menu retrievedMenu = menuRepository.findById(savedMenu.getId()).orElse(null);

        // Assertions
        assertNotNull(retrievedMenu);
        assertEquals("Test Item", retrievedMenu.getItemName());
        assertEquals("10.99", retrievedMenu.getItemPrice());
        assertEquals("123", retrievedMenu.getItemId());
        assertEquals("Test Description", retrievedMenu.getItemDescription());
        assertEquals("Veg", retrievedMenu.getVegNonVeg());
        assertEquals("Test Category", retrievedMenu.getItemCategory());
    }
}
