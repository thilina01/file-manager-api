package com.trendsmixed.fma.module.invoice;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.module.customer.Customer;
import com.trendsmixed.fma.module.loadingplan.LoadingPlan;
import com.trendsmixed.fma.module.loadingplan.LoadingPlanService;
import com.trendsmixed.fma.module.dispatchnote.DispatchNote;
import com.trendsmixed.fma.module.dispatchnote.DispatchNoteService;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import java.text.ParseException;
import com.trendsmixed.fma.utility.Format;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/invoices")
public class InvoiceController {

    private final AppSessionService appSessionService;
    private final InvoiceService service;
    private final DispatchNoteService dispatchNoteService;
    @JsonView(InvoiceView.All.class)
    @GetMapping
    public Iterable<Invoice> findAll() {
        return service.findAll();
    }

    @JsonView(InvoiceView.AllAndCustomerAndInvoiceType.class)
    @GetMapping("/page")
    Page<Invoice> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(InvoiceView.AllAndCustomerAndInvoiceType.class)
    @GetMapping(value = "/invoiceDurationPage", params = {"startDate", "endDate"})
    public Page<Invoice> invoiceDurationPage(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, Pageable pageable) throws ParseException {
        return new Page(service.findByInvoiceDateBetween(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
    }

    @JsonView(InvoiceView.AllAndCustomerAndInvoiceType.class)
    @GetMapping(value = "/customerAndInvoiceDurationPage", params = {"customer", "startDate", "endDate"})
    public Page<Invoice> customerAndInvoiceDurationPage(@RequestParam("customer") String customer, @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, Pageable pageable) throws ParseException {
        return new Page(service.findByCustomerAndInvoiceDateBetween(new Customer(Integer.valueOf(customer)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
    }

    @JsonView(InvoiceView.AllAndCustomerAndInvoiceType.class)
    @GetMapping(value = "/customerPage", params = {"customer"})
    public Page<Invoice> customerPage( @RequestParam("customer") String customer, Pageable pageable) throws ParseException {
        return new Page(service.findByCustomer(new Customer(Integer.valueOf(customer)), pageable));
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

            List<DispatchNote> dispatchNotesToUpdate = new ArrayList(); 
            List<DispatchNote> dispatchNotes = invoice.getDispatchNoteList();
                      
                      if (dispatchNotes != null) {
                          for (DispatchNote dispatchNote : dispatchNotes) {
                            DispatchNote dispatchNoteToUpdate = dispatchNoteService.findOne(dispatchNote.getId());
                            dispatchNoteToUpdate.setInvoice(invoice);
                            dispatchNotesToUpdate.add(dispatchNoteToUpdate);
                          }
                          invoice.setDispatchNoteList(dispatchNotesToUpdate);
                     }
                     return service.save(invoice);

        } catch (Throwable e) {
            e.printStackTrace();
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

     @JsonView(InvoiceView.AllAndDispatchNoteAndLoadingPlanAndLoadingPlanItemAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPackagingSpecificationAndPortOfLoadingAndContainerSizeAndAddressAndCustomerAndIncotermAndInvoiceType.class)
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
