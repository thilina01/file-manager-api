package com.trendsmixed.fma.module.itemtype;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/itemTypes")
public class ItemTypeController {

    
    private final ItemTypeService service;

    @JsonView(ItemTypeView.All.class)
    @GetMapping
    public Iterable<ItemType> findAll() {
        return service.findAll();
    }

    @JsonView(ItemTypeView.All.class)
    @GetMapping("/page")
    Page<ItemType> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(ItemTypeView.All.class)
    @PostMapping
    public ItemType save(@RequestBody ItemType itemType,
            @RequestHeader(value = "email", defaultValue = "") String email) {
        
        try {
            itemType = service.save(itemType);
            return itemType;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<ItemType> itemTypes,
            @RequestHeader(value = "email", defaultValue = "") String email) {
        
        try {

            service.save(itemTypes);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(ItemTypeView.All.class)
    @GetMapping("/{id}")
    public ItemType findOne(@PathVariable("id") int id) {
        return service.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email,
            HttpServletRequest request) {
        
        service.deleteById(id);
    }

    @JsonView(ItemTypeView.All.class)
    @PutMapping("/{id}")
    public ItemType updateCustomer(@PathVariable int id, @RequestBody ItemType itemType,
            @RequestHeader(value = "email", defaultValue = "") String email) {
        
        itemType.setId(id);
        itemType = service.save(itemType);
        return itemType;
    }
}
