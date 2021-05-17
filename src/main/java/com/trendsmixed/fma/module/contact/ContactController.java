package com.trendsmixed.fma.module.contact;

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
@RequestMapping("/Contacts")
public class ContactController {

    

    private final ContactService service;

    @JsonView(ContactView.AllAndContactTypeAll.class)
    @GetMapping
    public Iterable<Contact> findAll() {
        return service.findAll();
    }

    @JsonView(ContactView.AllAndContactTypeAll.class)
    @GetMapping("/page")
    Page<Contact> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(ContactView.AllAndContactTypeAll.class)
    @PostMapping
    public Contact save(@RequestBody Contact contact) {
        
        try {
            contact = service.save(contact);
            return contact;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(ContactView.AllAndContactTypeAll.class)
    @GetMapping("/{id}")
    public Contact findOne(@PathVariable("id") int id) {
        return service.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        
        service.deleteById(id);

    }

    @JsonView(ContactView.AllAndContactTypeAll.class)
    @PutMapping("/{id}")
    public Contact updateCustomer(@PathVariable int id, @RequestBody Contact contact) {
        
        contact.setId(id);
        contact = service.save(contact);
        return contact;
    }
}
