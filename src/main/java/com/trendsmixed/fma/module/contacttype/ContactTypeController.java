package com.trendsmixed.fma.module.contacttype;

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
@RequestMapping("/contactTypes")
public class ContactTypeController {


    private final ContactTypeService service;

    @JsonView(ContactTypeView.All.class)
    @GetMapping
    public Iterable<ContactType> findAll() {
        return service.findAll();
    }

    @JsonView(ContactTypeView.All.class)
    @GetMapping("/page")
    Page<ContactType> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(ContactTypeView.All.class)
    @PostMapping
    public ContactType save(@RequestBody ContactType addressType) {

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
    public void saveMany(@RequestBody List<ContactType> addressTypes) {


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
    public ContactType findOne(@PathVariable("id") int id) {
        return service.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {

        service.deleteById(id);

    }

    @PutMapping("/{id}")
    public ContactType updateCustomer(@PathVariable int id, @RequestBody ContactType addressType) {

        addressType.setId(id);
        addressType = service.save(addressType);
        return addressType;
    }
}
