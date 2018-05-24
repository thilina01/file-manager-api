package com.trendsmixed.fma.module.loadingplanitem;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Pageable;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.module.customer.Customer;
import com.trendsmixed.fma.module.customer.CustomerService;
import com.trendsmixed.fma.module.item.Item;
import com.trendsmixed.fma.module.item.ItemService;
import com.trendsmixed.fma.module.job.JobService;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import java.text.ParseException;
import com.trendsmixed.fma.utility.Format;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/loadingPlanItems")
public class LoadingPlanItemController {

    private final AppSessionService appSessionService;
    private final LoadingPlanItemService service;
    private final JobService jobService;
    private final ItemService itemService;
    private final CustomerService customerService;

    @JsonView(LoadingPlanItemView.All.class)
    @GetMapping
    public Iterable<LoadingPlanItem> findAll() {
        return service.findAll();
    }

    @JsonView(LoadingPlanItemView.AllAndDispatchScheduleAndLoadingPlanAndDispatchNoteAndinvoiceAndSalesOrderItemAndCustomerItemAndSalesOrderAndCustomerAndItemAndPaint.class)
    @GetMapping("/page")
    Page<LoadingPlanItem> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
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
    @GetMapping(value = "/dispatchDurationPage", params = {"startDate", "endDate"})
    public Page<LoadingPlanItem> dispatchDurationPage(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, Pageable pageable) throws ParseException {
        return new Page(service.findByLoadingPlanDispatchNoteDispatchDateBetween(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));    
    }
    @JsonView(LoadingPlanItemView.AllAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPackagingSpecificationAndPalletSizeAndLoadingPlanAndCustomerAndDispatchNote.class)
    @GetMapping(value = "/dispatchDateAndItemPage", params = {"dispatchDate", "item"})
    public Page<LoadingPlanItem> dispatchDateAndItemPage(@RequestParam("dispatchDate") String dispatchDate, @RequestParam("item") String item, Pageable pageable) throws ParseException {
        return new Page(service.findByLoadingPlanDispatchNoteDispatchDateAndDispatchScheduleJobItem(Format.yyyy_MM_dd.parse(dispatchDate), new Item(Integer.valueOf(item)), pageable));
    }
    @JsonView(LoadingPlanItemView.AllAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPackagingSpecificationAndPalletSizeAndLoadingPlanAndCustomerAndDispatchNote.class)
    @GetMapping(value = "/dispatchDurationAndItemPage", params = {"startDate", "endDate", "item"})
    public Page<LoadingPlanItem> dispatchDurationAndItemPage(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, @RequestParam("item") String item, Pageable pageable) throws ParseException {
        return new Page(service.findByLoadingPlanDispatchNoteDispatchDateBetweenAndDispatchScheduleJobItem(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new Item(Integer.valueOf(item)), pageable));
    }
    @JsonView(LoadingPlanItemView.AllAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPackagingSpecificationAndPalletSizeAndLoadingPlanAndCustomerAndDispatchNote.class)
    @GetMapping(value = "/customerAndDispatchDurationPage", params = {"customer", "startDate", "endDate"})
    public Page<LoadingPlanItem> customerAndDispatchDurationPage(@RequestParam("customer") String customer, @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, Pageable pageable) throws ParseException {
        return new Page(service.findByLoadingPlanDispatchNoteCustomerAndLoadingPlanDispatchNoteDispatchDateBetween(new Customer(Integer.valueOf(customer)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
    }
    @JsonView(LoadingPlanItemView.AllAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPackagingSpecificationAndPalletSizeAndLoadingPlanAndCustomerAndDispatchNote.class)
    @GetMapping(value = "/customerAndDispatchDateAndItemPage", params = {"customer", "dispatchDate", "item"})
    public Page<LoadingPlanItem> customerAndDispatchDateAndItemPage(@RequestParam("customer") String customer, @RequestParam("dispatchDate") String dispatchDate, @RequestParam("item") String item, Pageable pageable) throws ParseException {
        return new Page(service.findByLoadingPlanDispatchNoteCustomerAndLoadingPlanDispatchNoteDispatchDateAndDispatchScheduleJobItem(new Customer(Integer.valueOf(customer)), Format.yyyy_MM_dd.parse(dispatchDate), new Item(Integer.valueOf(item)), pageable));
    }
    @JsonView(LoadingPlanItemView.AllAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPackagingSpecificationAndPalletSizeAndLoadingPlanAndCustomerAndDispatchNote.class)
    @GetMapping(value = "/customerAndDispatchDurationAndItemPage", params = {"customer", "startDate", "endDate", "item"})
    public Page<LoadingPlanItem> customerAndDispatchDurationAndItemPage(@RequestParam("customer") String customer, @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, @RequestParam("item") String item, Pageable pageable) throws ParseException {
        return new Page(service.findByLoadingPlanDispatchNoteCustomerAndLoadingPlanDispatchNoteDispatchDateBetweenAndDispatchScheduleJobItem(new Customer(Integer.valueOf(customer)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new Item(Integer.valueOf(item)), pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @PostMapping
    public LoadingPlanItem save(@RequestBody LoadingPlanItem loadingPlanItem, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
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
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @PutMapping("/{id}")
    public LoadingPlanItem updateCustomer(@PathVariable int id, @RequestBody LoadingPlanItem loadingPlanItem, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        loadingPlanItem.setId(id);
        loadingPlanItem = service.save(loadingPlanItem);
        return loadingPlanItem;
    }
}
