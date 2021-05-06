package com.trendsmixed.fma.module.invoicetype;

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
@RequestMapping("/invoiceTypes")
public class InvoiceTypeController {

    
    private final InvoiceTypeService service;

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
            @RequestHeader(value = "email", defaultValue = "") String email) {
        
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
            @RequestHeader(value = "email", defaultValue = "") String email) {
        
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
        return service.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email,
            HttpServletRequest request) {
        
        service.deleteById(id);
    }

    @JsonView(InvoiceTypeView.All.class)
    @PutMapping("/{id}")
    public InvoiceType updateCustomer(@PathVariable int id, @RequestBody InvoiceType invoiceType,
            @RequestHeader(value = "email", defaultValue = "") String email) {
        
        invoiceType.setId(id);
        invoiceType = service.save(invoiceType);
        return invoiceType;
    }
}
