package com.trendsmixed.fma.module.rawmaterialitem;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/rawMaterialItems")
public class RawMaterialItemController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private RawMaterialItemService service;

    @JsonView(RawMaterialItemView.All.class)
    @GetMapping
    public Iterable<RawMaterialItem> findAll() {
        return service.findAll();
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(RawMaterialItemView.All.class)
    @GetMapping("/page")
    Page<RawMaterialItem> page(Pageable pageable) {
        return service.findAll(pageable);
    }

    @JsonView(RawMaterialItemView.All.class)
    @PostMapping
    public RawMaterialItem save(@RequestBody RawMaterialItem rawMaterialItem) {

        
        try {
            rawMaterialItem = service.save(rawMaterialItem);
            return rawMaterialItem;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<RawMaterialItem> onTimeDeliveries) {

        
        try {
            service.save(onTimeDeliveries);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    @JsonView(RawMaterialItemView.All.class)
    public RawMaterialItem findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        
        service.delete(id);

    }

    @PutMapping("/{id}")
    public RawMaterialItem updateCustomer(@PathVariable int id, @RequestBody RawMaterialItem rawMaterialItem) {
        
        rawMaterialItem.setId(id);
        rawMaterialItem = service.save(rawMaterialItem);
        return rawMaterialItem;
    }

}
