package com.trendsmixed.fma.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.ItemType;
import com.trendsmixed.fma.jsonView.ItemTypeView;
import com.trendsmixed.fma.service.AppSessionService;
import com.trendsmixed.fma.service.ItemTypeService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@RestController
@CrossOrigin
@RequestMapping("/itemTypes")
public class ItemTypeController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private ItemTypeService itemTypeService;

    @JsonView(ItemTypeView.AlL.class)
    @GetMapping
    public List<ItemType> findAll() {
        return itemTypeService.findAll();
    }

    @PostMapping
    public ItemType save(@RequestBody ItemType itemType, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            itemType = itemTypeService.save(itemType);
            return itemType;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<ItemType> itemTypes, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {

            itemTypeService.save(itemTypes);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ItemType findOne(@PathVariable("id") int id) {
        return itemTypeService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        itemTypeService.delete(id);

    }

    @PutMapping("/{id}")
    public ItemType updateCustomer(@PathVariable int id, @RequestBody ItemType itemType, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        itemType.setId(id);
        itemType = itemTypeService.save(itemType);
        return itemType;
    }
}
