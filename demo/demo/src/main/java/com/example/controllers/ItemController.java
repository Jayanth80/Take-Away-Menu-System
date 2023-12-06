// ItemController.java
package com.example.controller;

import com.example.model.Menu;
import com.example.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ItemController {

    private final MenuService menuService;

    @Autowired
    public ItemController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/display-menu")
    public String displayMenu(Model model) {
        List<Menu> menus = menuService.getAllMenus();
        model.addAttribute("menus", menus);
        return "display-menu";
    }
}
