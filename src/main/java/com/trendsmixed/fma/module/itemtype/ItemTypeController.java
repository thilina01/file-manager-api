package com.trendsmixed.fma.module.itemtype;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/itemTypes")
public class ItemTypeController {

    private final AppSessionService appSessionService;
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
            @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
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
            @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
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
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email,
            HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);
    }

    @JsonView(ItemTypeView.All.class)
    @PutMapping("/{id}")
    public ItemType updateCustomer(@PathVariable int id, @RequestBody ItemType itemType,
            @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        itemType.setId(id);
        itemType = service.save(itemType);
        return itemType;
    }
}
