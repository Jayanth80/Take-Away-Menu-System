package com.example.demo.controllers;

import com.example.controllers.CreateItemController;
import com.example.repository.MenuRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

class CreateItemControllerTest {

    @Test
    void createItemSubmit_Success() {
        // Arrange
        MenuRepository menuRepository = Mockito.mock(MenuRepository.class);
        CreateItemController controller = new CreateItemController(menuRepository);

        RedirectAttributes redirectAttributes = Mockito.mock(RedirectAttributes.class);
        Model model = Mockito.mock(Model.class);

        // Act
        String result = controller.createItemSubmit(
                "ItemName", "10.00", "123", "Description", "Veg", "Category",
                redirectAttributes, model
        );

        // Assert
        assertEquals("redirect:/create-item/success", result);
        verify(menuRepository).save(any()); // Verify that the save method is called with any Menu object
    }
}
