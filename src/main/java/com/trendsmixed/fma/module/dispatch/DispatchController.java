package com.trendsmixed.fma.module.dispatch;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.job.Job;
import com.trendsmixed.fma.module.customer.CustomerService;
import com.trendsmixed.fma.module.customer.Customer;
import com.trendsmixed.fma.module.item.ItemService;
import com.trendsmixed.fma.module.item.Item;
import com.trendsmixed.fma.utility.Format;
import com.trendsmixed.fma.module.jobdispatch.JobDispatch;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.module.job.JobService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import java.text.ParseException;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/dispatches")
public class DispatchController {

    private final AppSessionService appSessionService;
    private final DispatchService service;
    private final JobService jobService;
    private final ItemService itemService;
    private final CustomerService customerService;

    @JsonView(DispatchView.All.class)
    @GetMapping
    public Iterable<Dispatch> findAll() {
        return service.findAll();
    }

    @JsonView(DispatchView.AllAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAllDispatchNoteAllCustomerAll.class)
    @GetMapping("/page")
    Page<Dispatch> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }
    @JsonView(DispatchView.AllAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAllDispatchNoteAllCustomerAll.class)
    @PostMapping("/pageByCustomer")
    Page<Dispatch> pageByCustomer(Pageable pageable, @RequestBody Customer customer) {
        if (customer.getId() == null) {
            customer = customerService.findByCode(customer.getCode());
        }
        return new Page<>(service.findByDispatchNoteCustomer(customer, pageable));
    }
    @JsonView(DispatchView.AllAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAllDispatchNoteAllCustomerAll.class)
    @PostMapping("/pageByItem")
    Page<Dispatch> pageByItem(Pageable pageable, @RequestBody Item item) {
        if (item.getId() == null) {
            item = itemService.findByCode(item.getCode());
        }
        return new Page<>(service.findByDispatchScheduleJobItem(item, pageable));
    }
    @JsonView(DispatchView.AllAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAllDispatchNoteAllCustomerAll.class)
    @GetMapping(value = "/dispatchDurationPage", params = {"startDate", "endDate"})
    public Page<Dispatch> dispatchDurationPage(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, Pageable pageable) throws ParseException {
        return new Page(service.findByDispatchNoteDispatchDateBetween(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));    
    }
    @JsonView(DispatchView.AllAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAllDispatchNoteAllCustomerAll.class)
    @GetMapping(value = "/dispatchDateAndItemPage", params = {"dispatchDate", "item"})
    public Page<Dispatch> dispatchDateAndItemPage(@RequestParam("dispatchDate") String dispatchDate, @RequestParam("item") String item, Pageable pageable) throws ParseException {
        return new Page(service.findByDispatchNoteDispatchDateAndDispatchScheduleJobItem(Format.yyyy_MM_dd.parse(dispatchDate), new Item(Integer.valueOf(item)), pageable));
    }
    @JsonView(DispatchView.AllAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAllDispatchNoteAllCustomerAll.class)
    @GetMapping(value = "/dispatchScheduleDurationAndItemPage", params = {"startDate", "endDate", "item"})
    public Page<Dispatch> dispatchScheduleDurationAndItemPage(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, @RequestParam("item") String item, Pageable pageable) throws ParseException {
        return new Page(service.findByDispatchNoteDispatchDateBetweenAndDispatchScheduleJobItem(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new Item(Integer.valueOf(item)), pageable));
    }
    @JsonView(DispatchView.AllAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAllDispatchNoteAllCustomerAll.class)
    @GetMapping(value = "/customerAndDispatchDurationPage", params = {"customer", "startDate", "endDate"})
    public Page<Dispatch> customerAndDispatchDurationPage(@RequestParam("customer") String customer, @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, Pageable pageable) throws ParseException {
        return new Page(service.findByDispatchNoteCustomerAndDispatchNoteDispatchDateBetween(new Customer(Integer.valueOf(customer)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
    }
    @JsonView(DispatchView.AllAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAllDispatchNoteAllCustomerAll.class)
    @GetMapping(value = "/customerAndDispatchDateAndItemPage", params = {"customer", "dispatchDate", "item"})
    public Page<Dispatch> customerAndDispatchDateAndItemPage(@RequestParam("customer") String customer, @RequestParam("dispatchDate") String dispatchDate, @RequestParam("item") String item, Pageable pageable) throws ParseException {
        return new Page(service.findByDispatchNoteCustomerAndDispatchNoteDispatchDateAndDispatchScheduleJobItem(new Customer(Integer.valueOf(customer)), Format.yyyy_MM_dd.parse(dispatchDate), new Item(Integer.valueOf(item)), pageable));
    }
    @JsonView(DispatchView.AllAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAllDispatchNoteAllCustomerAll.class)
    @GetMapping(value = "/customerAndDispatchDurationAndItemPage", params = {"customer", "startDate", "endDate", "item"})
    public Page<Dispatch> customerAndDispatchDurationAndItemPage(@RequestParam("customer") String customer, @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, @RequestParam("item") String item, Pageable pageable) throws ParseException {
        return new Page(service.findByDispatchNoteCustomerAndDispatchNoteDispatchDateBetweenAndDispatchScheduleJobItem(new Customer(Integer.valueOf(customer)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new Item(Integer.valueOf(item)), pageable));
    }
    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }
    @JsonView(DispatchView.All.class)
    @PostMapping
    public Dispatch save(@RequestBody Dispatch dispatch, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            List<JobDispatch> jobDispatchs = dispatch.getJobDispatchList();
            for (JobDispatch jobDispatch : jobDispatchs) {
                jobDispatch.setDispatch(dispatch);
                Job job = jobService.findOne(jobDispatch.getJob().getId());

                double dispatchQuantity = jobDispatch.getQuantity();
                jobService.save(job);
            }

            dispatch = service.save(dispatch);
            return dispatch;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(DispatchView.AllAndCustomerAllAndJobDispatchAll.class)
    @GetMapping("/{id}")
    public Dispatch findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @PutMapping("/{id}")
    public Dispatch updateCustomer(@PathVariable int id, @RequestBody Dispatch dispatch, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        dispatch.setId(id);
        dispatch = service.save(dispatch);
        return dispatch;
    }
}
