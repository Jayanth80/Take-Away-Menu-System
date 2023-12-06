package com.example.controllers;

import com.example.model.Menu;
import com.example.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MenuController {


    @Autowired
    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/menuList") // Change the mapping to /view-menu
    public String getAllMenus(Model model) {
        List<Menu> menus = menuService.getAllMenus();
        model.addAttribute("menus", menus);
        return "menuList"; // Assuming you have a Thymeleaf template named "menuList.html"
    }

    @GetMapping("/display-menu")
    public String displayMenu(Model model) {
        List<Menu> menus = menuService.getAllMenus();
        model.addAttribute("menus", menus);
        return "display-menu";
    }







    // Example:
    // @PostMapping("/menus")
    // public String createMenu(Menu menu) {
    //     menuService.createMenu(menu);
    //     return "redirect:/view-menu"; // Change the redirect to /view-menu
    // }

    // Add similar methods for update and delete operations

}
