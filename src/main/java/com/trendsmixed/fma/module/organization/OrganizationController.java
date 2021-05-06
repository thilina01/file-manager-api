package com.trendsmixed.fma.module.organization;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/organizations")
public class OrganizationController {

    private AppSessionService appSessionService;
    private OrganizationService service;

    @JsonView(OrganizationView.All.class)
    @GetMapping
    public Iterable<Organization> findAll() {
        return service.findAll();
    }

    @JsonView(OrganizationView.All.class)
    @GetMapping("/page")
    Page<Organization> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(OrganizationView.All.class)
    @PostMapping
    public Organization save(@RequestBody Organization organization) {
        
        try {
            organization = service.save(organization);
            return organization;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(OrganizationView.All.class)
    @GetMapping("/{id}")
    public Organization findOne(@PathVariable("id") int id) {
        return service.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        
        service.deleteById(id);

    }

    @JsonView(OrganizationView.All.class)
    @PutMapping("/{id}")
    public Organization updateCustomer(@PathVariable int id, @RequestBody Organization organization) {
        
        organization.setId(id);
        organization = service.save(organization);
        return organization;
    }
}
