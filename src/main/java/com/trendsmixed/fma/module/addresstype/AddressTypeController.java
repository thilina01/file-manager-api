package com.trendsmixed.fma.module.addresstype;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/addressTypes")
public class AddressTypeController {

    
    private final AddressTypeService service;

    @JsonView(AddressTypeView.All.class)
    @GetMapping
    public Iterable<AddressType> findAll() {
        return service.findAll();
    }

    @JsonView(AddressTypeView.All.class)
    @GetMapping("/page")
    Page<AddressType> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(AddressTypeView.All.class)
    @PostMapping
    public AddressType save(@RequestBody AddressType addressType) {
        
        try {
            addressType = service.save(addressType);
            return addressType;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<AddressType> addressTypes) {

        
        try {
            service.save(addressTypes);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public AddressType findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        
        service.delete(id);

    }

    @PutMapping("/{id}")
    public AddressType updateCustomer(@PathVariable int id, @RequestBody AddressType addressType) {
        
        addressType.setId(id);
        addressType = service.save(addressType);
        return addressType;
    }
}
