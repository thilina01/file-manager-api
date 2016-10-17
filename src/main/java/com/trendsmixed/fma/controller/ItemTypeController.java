package com.trendsmixed.fma.controller;

import com.trendsmixed.fma.entity.AppSession;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.ItemType;
import com.trendsmixed.fma.service.AppSessionService;
import java.util.List;
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
public class ItemTypeController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired

    @GetMapping
    public List<ItemType> findAll() {
    }

    @PostMapping
    public ItemType save(@RequestBody ItemType ItemType, @RequestHeader(value = "email", defaultValue = "") String email) {
        AppSession appSession = appSessionService.findOne(email);
        if (appSession == null) {
            throw new Error("Unauthorized access");
        } else {
            try {
                return ItemType;

            } catch (Throwable e) {
                while (e.getCause() != null) {
                    e = e.getCause();
                }
                throw new Error(e.getMessage());
            }
        }
    }

    @GetMapping("/{id}")
    public ItemType findOne(@PathVariable("id") int id) {
    }

    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable int id) {
        return "Deleted";

    }

    @PutMapping("/{id}")
    public ItemType updateCustomer(@PathVariable int id, @RequestBody ItemType ItemType) {
        ItemType.setId(id);
        return ItemType;
    }
}
