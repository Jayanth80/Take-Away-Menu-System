package com.example.controllers;

import com.example.model.Menu;
import com.example.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/create-item")
public class CreateItemController {

    private final MenuRepository menuRepository;

    @Autowired
    public CreateItemController(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @GetMapping
    public String createItemForm() {
        return "create-item";
    }

    @PostMapping
    public String createItemSubmit(
            @RequestParam String item_name,
            @RequestParam String item_price,
            @RequestParam String item_id,
            @RequestParam String item_description,
            @RequestParam String veg_non_veg,
            @RequestParam String item_category) {

        // Create a Menu object
        Menu menu = new Menu();
        menu.setItemName(item_name);
        menu.setItemPrice(item_price);
        menu.setItemId(item_id);
        menu.setItemDescription(item_description);
        menu.setVegNonVeg(veg_non_veg);
        menu.setItemCategory(item_category);

        // Save the Menu object to the database using Spring Data JPA
        menuRepository.save(menu);

        // Print to the console
        System.out.println("Item saved to the database: " + menu);
        System.out.println("Submitted");

        // Redirect to a confirmation page or wherever needed
        return "redirect:/create-item/success";
    }
}
