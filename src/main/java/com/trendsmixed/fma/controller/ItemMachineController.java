package com.trendsmixed.fma.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.entity.AppSession;
import com.trendsmixed.fma.entity.ItemMachine;
import com.trendsmixed.fma.jsonView.ItemMachineView;
import com.trendsmixed.fma.service.AppSessionService;
import com.trendsmixed.fma.service.ItemMachineService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/itemMachines")
public class ItemMachineController {

    @Autowired
    private ItemMachineService itemMachineService;
    @Autowired
    private AppSessionService appSessionService;

    @PostMapping
    public ItemMachine save(@RequestBody ItemMachine itemMachine, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            itemMachine = itemMachineService.save(itemMachine);
            return itemMachine;
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping
    @JsonView(ItemMachineView.All.class)
    public List<ItemMachine> findAll() {
        return itemMachineService.findAll();
    }

    @GetMapping("/{id}")
    public ItemMachine findOne(@PathVariable("id") int id) {
        return itemMachineService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        itemMachineService.delete(id);

    }

    @PutMapping("/{id}")
    public ItemMachine updateCustomer(@PathVariable int id, @RequestBody ItemMachine itemMachine, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        itemMachine.setId(id);
        itemMachine = itemMachineService.save(itemMachine);
        return itemMachine;
    }
}
