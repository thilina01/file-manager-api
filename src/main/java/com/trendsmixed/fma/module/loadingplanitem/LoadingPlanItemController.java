package com.trendsmixed.fma.module.loadingplanitem;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.customer.Customer;
import com.trendsmixed.fma.module.customer.CustomerService;
import com.trendsmixed.fma.module.dispatchnote.DispatchNote;
import com.trendsmixed.fma.module.dispatchschedule.DispatchSchedule;
import com.trendsmixed.fma.module.item.Item;
import com.trendsmixed.fma.module.item.ItemService;
import com.trendsmixed.fma.module.job.Job;
import com.trendsmixed.fma.module.job.JobService;
import com.trendsmixed.fma.utility.Format;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/loadingPlanItems")
public class LoadingPlanItemController {

    
    private final LoadingPlanItemService service;
    private final JobService jobService;
    private final ItemService itemService;
    private final CustomerService customerService;

    @JsonView(LoadingPlanItemView.All.class)
    @GetMapping
    public Iterable<LoadingPlanItem> findAll() {
        return service.findAll();
    }

    @JsonView(LoadingPlanItemView.AllAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPackagingSpecificationAndPalletSizeAndLoadingPlanAndCustomerAndDispatchNote.class)
    @GetMapping("/page")
    Page<LoadingPlanItem> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }
    
    @PostMapping("/many")
    public void saveMany(@RequestBody List<LoadingPlanItem> loadingPlanItemList) {

        
        try {

            service.save(loadingPlanItemList);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(LoadingPlanItemView.AllAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPackagingSpecificationAndPalletSizeAndLoadingPlanAndCustomerAndDispatchNote.class)
    @GetMapping("/dispatchNote/{id}")
    public Iterable<LoadingPlanItem> findByLoadingPlanDispatchNote(@PathVariable("id") int id) {
        return service.findByLoadingPlanDispatchNote(new DispatchNote(id));
    }

    @JsonView(LoadingPlanItemView.All.class)
    @GetMapping("/dispatchSchedule/{id}")
    public Iterable<LoadingPlanItem> findByDispatchSchedule(@PathVariable("id") int id) {
        return service.findByDispatchSchedule(new DispatchSchedule(id));
    }

    @JsonView(LoadingPlanItemView.AllAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPackagingSpecificationAndPalletSizeAndLoadingPlanAndCustomerAndDispatchNote.class)
    @PostMapping("/pageByCustomer")
    Page<LoadingPlanItem> pageByCustomer(Pageable pageable, @RequestBody Customer customer) {
        if (customer.getId() == null) {
            customer = customerService.findByCode(customer.getCode());
        }
        return new Page<>(service.findByLoadingPlanDispatchNoteCustomer(customer, pageable));
    }
    
    @JsonView(LoadingPlanItemView.AllAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPackagingSpecificationAndPalletSizeAndLoadingPlanAndCustomerAndDispatchNote.class)
    @PostMapping("/pageByItem")
    Page<LoadingPlanItem> pageByItem(Pageable pageable, @RequestBody Item item) {
        if (item.getId() == null) {
            item = itemService.findByCode(item.getCode());
        }
        return new Page<>(service.findByDispatchScheduleJobItem(item, pageable));
    }

    @JsonView(LoadingPlanItemView.AllAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPackagingSpecificationAndPalletSizeAndLoadingPlanAndCustomerAndDispatchNote.class)
    @GetMapping(value = "/dispatchReject")
    public Page<LoadingPlanItem> getDispatchRejectPage(
        @RequestParam(value = "customer", required = false, defaultValue = "0") String customer,
        @RequestParam(value = "item", required = false, defaultValue = "0") String item,
        @RequestParam(value = "dispatchNote", required = false, defaultValue = "0") String dispatchNote,
        @RequestParam(value = "startDate", required = false, defaultValue = "1970-01-01") String startDate,
        @RequestParam(value = "endDate", required = false, defaultValue = "2100-12-31") String endDate, 
        Pageable pageable) throws ParseException {
        Page<LoadingPlanItem> page;

        if(customer.equals("0")&&item.equals("0")&&dispatchNote.equals("0")){
            page = new Page(service.findByRejectedQuantityNotNullAndLoadingPlanDispatchNoteDispatchDateBetween(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate),pageable));    
        }
        else if(item.equals("0")&&dispatchNote.equals("0")){
            page = new Page(service.findByLoadingPlanDispatchNoteCustomerAndRejectedQuantityNotNullAndLoadingPlanDispatchNoteDispatchDateBetween(new Customer(Integer.valueOf(customer)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate),pageable));
        }
        else if(customer.equals("0")&& dispatchNote.equals("0")){
            page = new Page(service.findByDispatchScheduleJobItemAndRejectedQuantityNotNullAndLoadingPlanDispatchNoteDispatchDateBetween(new Item(Integer.valueOf(item)),Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate),pageable));
        }
        else if(customer.equals("0")&& item.equals("0")){
            page = new Page(service.findByLoadingPlanDispatchNoteAndRejectedQuantityNotNullAndLoadingPlanDispatchNoteDispatchDateBetween(new DispatchNote(Integer.valueOf(dispatchNote)),Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate),pageable));
        }
        else if(item.equals("0")){
            page = new Page(service.findByLoadingPlanDispatchNoteCustomerAndLoadingPlanDispatchNoteAndRejectedQuantityNotNullAndLoadingPlanDispatchNoteDispatchDateBetween(new Customer(Integer.valueOf(customer)),new DispatchNote(Integer.valueOf(dispatchNote)),Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate),pageable));
        }
        else if(customer.equals("0")){
            page = new Page(service.findByLoadingPlanDispatchNoteAndDispatchScheduleJobItemAndRejectedQuantityNotNullAndLoadingPlanDispatchNoteDispatchDateBetween(new DispatchNote(Integer.valueOf(dispatchNote)),new Item(Integer.valueOf(item)),Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate),pageable));
        }
        else if(dispatchNote.equals("0")){
            page = new Page(service.findByLoadingPlanDispatchNoteCustomerAndDispatchScheduleJobItemAndRejectedQuantityNotNullAndLoadingPlanDispatchNoteDispatchDateBetween(new Customer(Integer.valueOf(customer)), new Item(Integer.valueOf(item)),Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate),pageable));
        }
        else {
            page = new Page(service.findByLoadingPlanDispatchNoteCustomerAndDispatchScheduleJobItemAndLoadingPlanDispatchNoteAndRejectedQuantityNotNullAndLoadingPlanDispatchNoteDispatchDateBetween(new Customer(Integer.valueOf(customer)), new Item(Integer.valueOf(item)),new DispatchNote(Integer.valueOf(dispatchNote)),Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate),pageable));
        }
        
        return page;
    }

    @JsonView(LoadingPlanItemView.AllAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPackagingSpecificationAndPalletSizeAndLoadingPlanAndCustomerAndDispatchNote.class)
    @GetMapping(value = "/dispatchInformation")
    public Page<LoadingPlanItem> getDispatchInformationPage(
        @RequestParam(value = "customer", required = false, defaultValue = "0") String customer,
        @RequestParam(value = "item", required = false, defaultValue = "0") String item,
        @RequestParam(value = "startDate", required = false, defaultValue = "1970-01-01") String startDate,
        @RequestParam(value = "endDate", required = false, defaultValue = "2100-12-31") String endDate, 
        Pageable pageable) throws ParseException {
        Page<LoadingPlanItem> page ;

        if(customer.equals("0") && item.equals("0") ){
            page = new Page(service.findByLoadingPlanDispatchNoteDispatchDateBetween(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));    
        } 
        else if(item.equals("0")){
            page = new Page(service.findByLoadingPlanDispatchNoteCustomerAndLoadingPlanDispatchNoteDispatchDateBetween(new Customer(Integer.valueOf(customer)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
        }
        else if(customer.equals("0")){
            page = new Page(service.findByLoadingPlanDispatchNoteDispatchDateBetweenAndDispatchScheduleJobItem(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new Item(Integer.valueOf(item)), pageable));
        }
        else{
            page = new Page(service.findByLoadingPlanDispatchNoteCustomerAndLoadingPlanDispatchNoteDispatchDateBetweenAndDispatchScheduleJobItem(new Customer(Integer.valueOf(customer)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new Item(Integer.valueOf(item)), pageable));
        }
        return page;
    }

    @JsonView(LoadingPlanItemView.AllAndLoadingPlanAndDispatchNoteAndInvoiceAndCustomerAndInvoiceTypeAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItem.class)
    @GetMapping(value = "/invoiceInformation")
    public Page<LoadingPlanItem> getInvoiceInformationPage(
        @RequestParam(value = "invoice", required = false, defaultValue = "0") String invoice,
        @RequestParam(value = "invoiceNumber", required = false, defaultValue = "0") String invoiceNumber,
        @RequestParam(value = "customer", required = false, defaultValue = "0") String customer,
        @RequestParam(value = "job", required = false, defaultValue = "0") String job,
        @RequestParam(value = "startDate", required = false, defaultValue = "1970-01-01") String startDate,
        @RequestParam(value = "endDate", required = false, defaultValue = "2100-12-31") String endDate, 
        Pageable pageable) throws ParseException {
        Page<LoadingPlanItem> page ;

    if(!invoice.equals("0")) {
            page = new Page(service.findByLoadingPlanDispatchNoteInvoiceNotNull( pageable));
        }  
    else if(!invoiceNumber.equals("0")){
            page = new Page(service.findByLoadingPlanDispatchNoteInvoiceInvoiceNumber(invoiceNumber, pageable));
        }   
    else if(!job.equals("0")){
            page = new Page(service.findByDispatchScheduleJobAndLoadingPlanDispatchNoteInvoiceInvoiceDateBetween(new Job(Integer.valueOf(job)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));    
        }
    else if(!customer.equals("0")){
            page = new Page(service.findByLoadingPlanDispatchNoteInvoiceCustomerAndLoadingPlanDispatchNoteInvoiceInvoiceDateBetween(new Customer(Integer.valueOf(customer)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));    
        }
    else{
        page = new Page(service.findByLoadingPlanDispatchNoteInvoiceInvoiceDateBetween(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));    
        }
    
        return page;
    }

    @JsonView(LoadingPlanItemView.AllAndLoadingPlanAndDispatchNoteAndInvoiceAndCustomerAndInvoiceTypeAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPackagingSpecification.class)
    @GetMapping(value = "/byInvoiceId")
    public  Iterable<LoadingPlanItem> getByInvoiceId(
        @RequestParam(value = "invoiceId", required = true) int invoiceId){
        return service.findByLoadingPlanDispatchNoteInvoiceId(invoiceId);
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @PostMapping
    public LoadingPlanItem save(@RequestBody LoadingPlanItem loadingPlanItem) {
        
        try {
            loadingPlanItem = service.save(loadingPlanItem);
            return loadingPlanItem;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(LoadingPlanItemView.All.class)
    @GetMapping("/{id}")
    public LoadingPlanItem findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        
        service.delete(id);

    }

    @PutMapping("/{id}")
    public LoadingPlanItem updateCustomer(@PathVariable int id, @RequestBody LoadingPlanItem loadingPlanItem) {
        
        loadingPlanItem.setId(id);
        loadingPlanItem = service.save(loadingPlanItem);
        return loadingPlanItem;
    }
}
