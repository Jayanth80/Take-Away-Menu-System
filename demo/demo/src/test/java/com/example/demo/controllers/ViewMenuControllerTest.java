package com.example.demo.controllers;

import com.example.controllers.MenuController;
import com.example.model.Menu;
import com.example.repository.MenuRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class DisplayMenuControllerTest {

    @Test
    void displayMenuPage_Success() {
        // Arrange
        MenuRepository menuRepository = Mockito.mock(MenuRepository.class);
        MenuController controller = new MenuController(menuRepository);

        Model model = Mockito.mock(Model.class);

        List<Menu> menuItems = new ArrayList<>();
        // Populate menuItems with some sample data
        menuItems.add(new Menu(/* item details */));
        menuItems.add(new Menu(/* item details */));

        when(menuRepository.findAll()).thenReturn(menuItems);

        // Act
        String result = controller.getAllMenus(model);

        // Assert
        assertEquals("display-menu", result);
        // Add more assertions based on what you expect to be in the model or displayed in the view
    }
}
