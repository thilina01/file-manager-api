package com.trendsmixed.fma.module.invoice;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.module.dispatchnote.DispatchNote;
import com.trendsmixed.fma.module.dispatchnote.DispatchNoteService;
import com.trendsmixed.fma.utility.Page;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/invoices")
public class InvoiceController {

    private final AppSessionService appSessionService;
    private final InvoiceService service;
    private final DispatchNoteService dispatchNoteService;

    @JsonView(InvoiceView.AllAndInvoiceTypeAllAndCustomerAllAndDispatchNoteAndDispatchListAndDispatchAllAndDispatchScheduleAllAndSalesOrderItemAllAndSalesOrderAllCustomerItemAllAndJobAllAndItemAll.class)
    @GetMapping
    public Iterable<Invoice> findAll() {
        return service.findAll();
    }

    @JsonView(InvoiceView.AllAndInvoiceTypeAllAndCustomerAllAndDispatchNoteAndDispatchListAndDispatchAllAndDispatchScheduleAllAndSalesOrderItemAllAndSalesOrderAllCustomerItemAllAndJobAllAndItemAll.class)
    @GetMapping("/page")
    Page<Invoice> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(InvoiceView.AllAndInvoiceTypeAllAndCustomerAllAndDispatchNoteAndDispatchListAndDispatchAllAndDispatchScheduleAllAndSalesOrderItemAllAndSalesOrderAllCustomerItemAllAndJobAllAndItemAll.class)
    @PostMapping
    public Invoice save(@RequestBody Invoice invoice, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {

            List<DispatchNote> dispatchNotes = invoice.getDispatchNoteList();
            for (DispatchNote dispatchNote : dispatchNotes) {
                if (dispatchNote.getId() != null) {
                    DispatchNote existingDispatchNote = dispatchNoteService.findOne(dispatchNote.getId());
                    dispatchNote.setDispatchList(existingDispatchNote != null ? existingDispatchNote.getDispatchList() : new ArrayList<>());

                    // List<DispatchNote> dispatchNotes = invoice.getDispatchNoteList();
                    //if (dispatchNotes != null) {
                    //List<DispatchNote> dispatchNotesToUpdate = new ArrayList<>();
                    //for (DispatchNote dispatchNote : dispatchNotes) {
                    //DispatchNote dispatchNoteToUpdate = new DispatchNote(dispatchNote.getId());
                    //dispatchNotesToUpdate.add(dispatchNoteToUpdate);
                    dispatchNote.setInvoice(invoice);
                }
                // invoice.setDispatchNoteList(dispatchNotesToUpdate);

            }
            invoice = service.save(invoice);
            return invoice;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(InvoiceView.AllAndInvoiceTypeAllAndCustomerAllAndDispatchNoteAndDispatchListAndDispatchAllAndDispatchScheduleAllAndSalesOrderItemAllAndSalesOrderAllCustomerItemAllAndJobAllAndItemAll.class)
    @GetMapping("/{id}")
    public Invoice findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @JsonView(InvoiceView.AllAndInvoiceTypeAllAndCustomerAllAndDispatchNoteAndDispatchListAndDispatchAllAndDispatchScheduleAllAndSalesOrderItemAllAndSalesOrderAllCustomerItemAllAndJobAllAndItemAll.class)
    @PutMapping("/{id}")
    public Invoice updateCustomer(@PathVariable int id, @RequestBody Invoice invoice, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        invoice.setId(id);
        invoice = service.save(invoice);
        return invoice;
    }

}
