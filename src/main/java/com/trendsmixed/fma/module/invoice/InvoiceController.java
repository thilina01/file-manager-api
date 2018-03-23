package com.trendsmixed.fma.module.invoice;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/invoices")
public class InvoiceController {

    private final AppSessionService appSessionService;
    private final InvoiceService service;

    @JsonView(InvoiceView.All.class)
    @GetMapping
    public Iterable<Invoice> findAll() {
        return service.findAll();
    }

    @JsonView(InvoiceView.AllAndCustomerAllAndInvoiceTypeAll.class)
    @GetMapping("/page")
    Page<Invoice> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(InvoiceView.All.class)
    @PostMapping
    public Invoice save(@RequestBody Invoice invoice, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            // List<InvoiceDispatchNote> invoiceDispatchNoteList = invoice.getInvoiceDispatchNoteList();
            // for (InvoiceDispatchNote invoiceDispatchNote : invoiceDispatchNoteList) {
            //     invoiceDispatchNote.setInvoice(invoice);
            // }
            return service.save(invoice);
        } catch (Throwable e) {
            e.printStackTrace();
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(InvoiceView.All.class)
    @GetMapping("/{id}")
    public Invoice findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<Invoice> invoices, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(InvoiceView.All.class)
    @PutMapping("/{id}")
    public Invoice updateCustomer(@PathVariable int id, @RequestBody Invoice invoice, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        invoice.setId(id);
        invoice = service.save(invoice);
        return invoice;
    }

}
