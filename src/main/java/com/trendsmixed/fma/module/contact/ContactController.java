package com.trendsmixed.fma.module.contact;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.utility.Page;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/Contacts")
public class ContactController {

    private final AppSessionService appSessionService;

    private final ContactService service;

    @JsonView(ContactView.All.class)
    @GetMapping
    public Iterable<Contact> findAll() {
        return service.findAll();
    }

    @JsonView(ContactView.All.class)
    @GetMapping("/page")
    Page<Contact> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(ContactView.All.class)
    @PostMapping
    public Contact save(@RequestBody Contact contact, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
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

    @JsonView(ContactView.All.class)
    @GetMapping("/{id}")
    public Contact findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @JsonView(ContactView.All.class)
    @PutMapping("/{id}")
    public Contact updateCustomer(@PathVariable int id, @RequestBody Contact contact, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        contact.setId(id);
        contact = service.save(contact);
        return contact;
    }
}
