package com.kodgemisi.webapps.inventory.controller;

import com.kodgemisi.webapps.inventory.domain.Item;
import com.kodgemisi.webapps.inventory.domain.ItemAddForm;
import com.kodgemisi.webapps.inventory.domain.ItemAssignForm;
import com.kodgemisi.webapps.inventory.domain.User;
import com.kodgemisi.webapps.inventory.service.ItemService;
import com.kodgemisi.webapps.inventory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by sedat on 29.06.2015.
 */

@Controller
public class ItemController {
    private ItemService itemService;
    private UserService userService;

    @Autowired
    public ItemController(ItemService itemService, UserService userService) {
        this.itemService = itemService;
        this.userService = userService;
    }

    @RequestMapping("/items")
    public ModelAndView getItemsPage() {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("items", itemService.getItems());
        model.put("users", userService.getUsers());
        return new ModelAndView("items", model);
    }

    @RequestMapping(value = "/items/{id}", method = RequestMethod.PUT)
    public String handleItemAssign(@ModelAttribute("item") Item item, @PathVariable("id") long id) {
        itemService.assignItem(item.getUser(), id);
        return "redirect:/items";
    }

    @RequestMapping("/items/add")
    public ModelAndView itemAddPage() {
        return new ModelAndView("addItem", "itemForm", new ItemAddForm());
    }

    @RequestMapping(value = "/items", method = RequestMethod.POST)
    public String handleItemAdd(@Valid @ModelAttribute("itemForm") ItemAddForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "addItem";

        itemService.addItem(form);
        return "redirect:/items";
    }

    @RequestMapping(params="delete", value = "/items/{id}", method = RequestMethod.DELETE)
    public String handleItemDelete(@PathVariable Long id) {
        itemService.deleteItemById(id);
        return "redirect:/items";
    }
}
