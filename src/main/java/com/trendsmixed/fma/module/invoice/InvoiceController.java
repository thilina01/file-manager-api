package com.trendsmixed.fma.module.invoice;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.log.LogExecution;
import com.trendsmixed.fma.module.customer.Customer;
import com.trendsmixed.fma.module.dispatchnote.DispatchNote;
import com.trendsmixed.fma.module.dispatchnote.DispatchNoteService;
import com.trendsmixed.fma.utility.Format;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/invoices")
public class InvoiceController {

    
    private final InvoiceService service;
    private final DispatchNoteService dispatchNoteService;


    @LogExecution
    @JsonView(InvoiceView.All.class)
    @GetMapping
    public Iterable<Invoice> findAll() {
        return service.findAll();
    }

    @LogExecution
    @JsonView(InvoiceView.AllAndDispatchNoteAndLoadingPlanAndLoadingPlanItemAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPackagingSpecificationAndPortOfLoadingAndContainerSizeAndAddressAndCustomerAndIncotermAndInvoiceType.class)
    @GetMapping("/page")
    Page<Invoice> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @LogExecution
    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @LogExecution
    @JsonView(InvoiceView.AllAndCustomerAndInvoiceTypeAndExchangeRateAndCurrency.class)
    @GetMapping(value = "/invoiceDurationPage", params = {"startDate", "endDate"})
    public Page<Invoice> invoiceDurationPage(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, Pageable pageable) throws ParseException {
        return new Page(service.findByInvoiceDateBetween(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
    }

    @LogExecution
    @JsonView(InvoiceView.AllAndCustomerAndInvoiceTypeAndExchangeRateAndCurrency.class)
    @GetMapping(value = "/customerAndInvoiceDurationPage", params = {"customer", "startDate", "endDate"})
    public Page<Invoice> customerAndInvoiceDurationPage(@RequestParam("customer") String customer, @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, Pageable pageable) throws ParseException {
        return new Page(service.findByCustomerAndInvoiceDateBetween(new Customer(Integer.valueOf(customer)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
    }

    @LogExecution
    @JsonView(InvoiceView.AllAndCustomerAndInvoiceTypeAndExchangeRateAndCurrency.class)
    @GetMapping(value = "/customerPage", params = {"customer"})
    public Page<Invoice> customerPage( @RequestParam("customer") String customer, Pageable pageable) throws ParseException {
        return new Page(service.findByCustomer(new Customer(Integer.valueOf(customer)), pageable));
    }

    @LogExecution
    @JsonView(InvoiceView.AllAndDispatchNoteAndLoadingPlanAndLoadingPlanItemAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPackagingSpecificationAndPortOfLoadingAndContainerSizeAndAddressAndCustomerAndIncotermAndInvoiceType.class)
    @GetMapping(value = "/customerAndInvoiceDateBetween")
    public Page<Invoice> getCustomerAndInvoiceDateBetweenPage(
        @RequestParam(value = "customer", required = false, defaultValue = "0") String customer,
        @RequestParam(value = "invoiceNumber",required = false, defaultValue = "0") String invoiceNumber,
        @RequestParam(value = "startDate", required = false, defaultValue = "1970-01-01") String startDate,
        @RequestParam(value = "endDate", required = false, defaultValue = "2100-12-31") String endDate, 
        Pageable pageable) throws ParseException {
        Page<Invoice> page ;

        if(!invoiceNumber.equals("0")){
            page = new Page(service.findByInvoiceNumber(invoiceNumber, pageable));
        }
        else if(customer.equals("0")){
            page = new Page(service.findByInvoiceDateBetween(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));    
        } 
        else{
            page = new Page(service.findByCustomerAndInvoiceDateBetween(new Customer(Integer.valueOf(customer)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
        }
        return page;
    }

    @LogExecution
    @JsonView(InvoiceView.All.class)
    @PostMapping
    public Invoice save(@RequestBody Invoice invoice) {
        
        try {
            // List<InvoiceDispatchNote> invoiceDispatchNoteList = invoice.getInvoiceDispatchNoteList();
            // for (InvoiceDispatchNote invoiceDispatchNote : invoiceDispatchNoteList) {
            //     invoiceDispatchNote.setInvoice(invoice);
            // }

            List<DispatchNote> dispatchNotesToUpdate = new ArrayList(); 
            List<DispatchNote> dispatchNotes = invoice.getDispatchNoteList();
                      
                      if (dispatchNotes != null) {
                          for (DispatchNote dispatchNote : dispatchNotes) {
                            DispatchNote dispatchNoteToUpdate = dispatchNoteService.findById(dispatchNote.getId());
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

    @LogExecution
     @JsonView(InvoiceView.AllAndDispatchNoteAndLoadingPlanAndLoadingPlanItemAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPackagingSpecificationAndPortOfLoadingAndContainerSizeAndAddressAndCustomerAndIncotermAndInvoiceType.class)
    @GetMapping("/{id}")
    public Invoice findOne(@PathVariable("id") int id) {
        return service.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        
        service.deleteById(id);

    }

    @LogExecution
    @PostMapping("/many")
    public void saveMany(@RequestBody List<Invoice> invoices) {
        
        try {

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @LogExecution
    @JsonView(InvoiceView.All.class)
    @PutMapping("/{id}")
    public Invoice updateCustomer(@PathVariable int id, @RequestBody Invoice invoice) {
        
        invoice.setId(id);
        invoice = service.save(invoice);
        return invoice;
    }

}
