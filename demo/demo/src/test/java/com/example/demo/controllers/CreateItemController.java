package com.example.controllers;

import com.example.model.Menu;
import com.example.repository.MenuRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestParam;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CreateItemControllerWhiteBoxTest {

    @Mock
    private MenuRepository menuRepository;

    @InjectMocks
    private CreateItemController createItemController;

    @Test
    public void testCreateItemSubmit() {
        // Mocking dependencies
        Model model = Mockito.mock(Model.class);
        BindingResult bindingResult = Mockito.mock(BindingResult.class);

        // Test data
        String itemName = "Test Item";
        String itemPrice = "10.99";
        String itemId = "123";
        String itemDescription = "Test Description";
        String vegNonVeg = "Veg";
        String itemCategory = "Test Category";

        // Call the method
        String result = createItemController.createItemSubmit(
                itemName, itemPrice, itemId, itemDescription, vegNonVeg, itemCategory, model, bindingResult);

        // Verify interactions
        Mockito.verify(menuRepository).save(Mockito.any(Menu.class));

        // Assert the result
        assertEquals("redirect:/create-item/success", result);
    }
}
