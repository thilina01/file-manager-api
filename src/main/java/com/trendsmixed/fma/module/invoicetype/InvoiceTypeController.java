package com.trendsmixed.fma.module.invoicetype;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.utility.Page;

@RestController
@CrossOrigin
@RequestMapping("/invoiceTypes")
public class InvoiceTypeController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private InvoiceTypeService service;

    @JsonView(InvoiceTypeView.All.class)
    @GetMapping
    public Iterable<InvoiceType> findAll() {
        return service.findAll();
    }

    @JsonView(InvoiceTypeView.All.class)
    @GetMapping("/page")
    Page<InvoiceType> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(InvoiceTypeView.All.class)
    @PostMapping
    public InvoiceType save(@RequestBody InvoiceType invoiceType,
            @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            invoiceType = service.save(invoiceType);
            return invoiceType;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<InvoiceType> invoiceTypes,
            @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {

            service.save(invoiceTypes);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(InvoiceTypeView.All.class)
    @GetMapping("/{id}")
    public InvoiceType findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email,
            HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);
    }

    @JsonView(InvoiceTypeView.All.class)
    @PutMapping("/{id}")
    public InvoiceType updateCustomer(@PathVariable int id, @RequestBody InvoiceType invoiceType,
            @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        invoiceType.setId(id);
        invoiceType = service.save(invoiceType);
        return invoiceType;
    }
}
