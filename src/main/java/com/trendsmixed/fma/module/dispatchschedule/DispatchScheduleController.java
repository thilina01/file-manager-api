package com.trendsmixed.fma.module.dispatchschedule;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.module.customer.Customer;
import com.trendsmixed.fma.module.customer.CustomerService;
import com.trendsmixed.fma.module.job.Job;
import com.trendsmixed.fma.module.job.JobService;
import com.trendsmixed.fma.module.jobtype.JobTypeService;
import com.trendsmixed.fma.module.salesorder.SalesOrder;
import java.text.ParseException;
import com.trendsmixed.fma.utility.Format;
import com.trendsmixed.fma.utility.Page;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/dispatchSchedules")
public class DispatchScheduleController {

    private final AppSessionService appSessionService;
    private final DispatchScheduleService service;
    private final JobTypeService jobTypeService;
    private final JobService jobService;
    private final CustomerService customerService;

    @JsonView(DispatchScheduleView.AllAndSalesOrderItemAllAndSalesOrderAllCustomerItemAllAndJobAllAndItemAll.class)
    @GetMapping
    public Iterable<DispatchSchedule> findAll() {
        return service.findAll();
    }

    @JsonView(DispatchScheduleView.AllAndSalesOrderItemAllAndSalesOrderAllCustomerAllCustomerItemAllAndJobAllAndItemAll.class)
    @GetMapping("/page")
    Page<DispatchSchedule> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @GetMapping("/comboByCustomer/{id}")
    List<Combo> combo(@PathVariable("id") int id) {
        return service.getComboByCustomer(new Customer(id));
    }
    
    @JsonView(DispatchScheduleView.AllAndSalesOrderItemAllAndSalesOrderAllCustomerAllCustomerItemAllAndJobAllAndItemAll.class)
    @GetMapping(value = "/dispatchScheduleDurationPage", params = {"startDate", "endDate"})
    public Page<DispatchSchedule> dispatchScheduleDurationPage(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, Pageable pageable) throws ParseException {
        return new Page(service.findBySalesOrderItemSalesOrderOrderDateBetween(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
    }
    @JsonView(DispatchScheduleView.AllAndSalesOrderItemAllAndSalesOrderAllCustomerAllCustomerItemAllAndJobAllAndItemAll.class)
    @GetMapping(value = "/orderDateAndJobPage", params = {"orderDate", "job"})
    public Page<DispatchSchedule> orderDateAndJobPage(@RequestParam("orderDate") String orderDate, @RequestParam("job") String job, Pageable pageable) throws ParseException {
        return new Page(service.findBySalesOrderItemSalesOrderOrderDateAndJob(Format.yyyy_MM_dd.parse(orderDate), new Job(Integer.valueOf(job)), pageable));
    }
    @JsonView(DispatchScheduleView.AllAndSalesOrderItemAllAndSalesOrderAllCustomerAllCustomerItemAllAndJobAllAndItemAll.class)
    @GetMapping(value = "/dispatchScheduleDurationAndJobPage", params = {"startDate", "endDate", "job"})
    public Page<DispatchSchedule> dispatchScheduleDurationAndJobPage(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, @RequestParam("job") String job, Pageable pageable) throws ParseException {
        return new Page(service.findBySalesOrderItemSalesOrderOrderDateBetweenAndJob(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new Job(Integer.valueOf(job)), pageable));
    }
    @JsonView(DispatchScheduleView.AllAndSalesOrderItemAllAndSalesOrderAllCustomerAllCustomerItemAllAndJobAllAndItemAll.class)
    @GetMapping(value = "/customerAndDispatchScheduleDurationPage", params = {"customer", "startDate", "endDate"})
    public Page<DispatchSchedule> customerAndDispatchScheduleDurationPage(@RequestParam("customer") String customer, @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, Pageable pageable) throws ParseException {
        return new Page(service.findBySalesOrderItemSalesOrderCustomerAndSalesOrderItemSalesOrderOrderDateBetween(new Customer(Integer.valueOf(customer)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
    }
    @JsonView(DispatchScheduleView.AllAndSalesOrderItemAllAndSalesOrderAllCustomerAllCustomerItemAllAndJobAllAndItemAll.class)
    @GetMapping(value = "/customerAndOrderDateAndJobPage", params = {"customer", "orderDate", "job"})
    public Page<DispatchSchedule> customerAndOrderDateAndJobPage(@RequestParam("customer") String customer, @RequestParam("orderDate") String orderDate, @RequestParam("job") String job, Pageable pageable) throws ParseException {
        return new Page(service.findBySalesOrderItemSalesOrderCustomerAndSalesOrderItemSalesOrderOrderDateAndJob(new Customer(Integer.valueOf(customer)), Format.yyyy_MM_dd.parse(orderDate), new Job(Integer.valueOf(job)), pageable));
    }
    @JsonView(DispatchScheduleView.AllAndSalesOrderItemAllAndSalesOrderAllCustomerAllCustomerItemAllAndJobAllAndItemAll.class)
    @GetMapping(value = "/customerAndDispatchScheduleDurationAndJobPage", params = {"customer", "startDate", "endDate", "job"})
    public Page<DispatchSchedule> customerAndDispatchScheduleDurationAndJobPage(@RequestParam("customer") String customer, @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, @RequestParam("job") String job, Pageable pageable) throws ParseException {
        return new Page(service.findBySalesOrderItemSalesOrderCustomerAndSalesOrderItemSalesOrderOrderDateBetweenAndJob(new Customer(Integer.valueOf(customer)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new Job(Integer.valueOf(job)), pageable));
    }

    @JsonView(DispatchScheduleView.AllAndSalesOrderItemAllAndSalesOrderAllCustomerAllCustomerItemAllAndJobAllAndItemAll.class)
    @PostMapping("/pageByCustomer")
    Page<DispatchSchedule> pageByCustomer(Pageable pageable, @RequestBody Customer customer) {
        if (customer.getId() == null) {
            customer = customerService.findByCode(customer.getCode());
        }
        return new Page<>(service.findBySalesOrderItemSalesOrderCustomer(customer, pageable));
    }
    
    @JsonView(DispatchScheduleView.AllAndSalesOrderItemAllAndSalesOrderAllCustomerAllCustomerItemAllAndJobAllAndItemAll.class)
    @PostMapping("/pageByJob")
    Page<DispatchSchedule> pageByJob(Pageable pageable, @RequestBody Job job) {
        if (job.getId() == null) {
            job = jobService.findByJobNo(job.getJobNo());
        }
        return new Page<>(service.findByJob(job, pageable));
    }

    @JsonView(DispatchScheduleView.AllAndSalesOrderItemAllAndSalesOrderAllCustomerItemAllAndJobAllAndItemAll.class)
    @PostMapping
    public DispatchSchedule save(@RequestBody DispatchSchedule dispatchSchedule, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {

            Job job = dispatchSchedule.getJob();
            if (job != null) {
                if (job.getId() == null|| job.getId() == 0) {
                    Job existingJob = jobService.findByJobNo(job.getJobNo());
                    if (existingJob != null) {
                        throw new Error("Job Number Already Used!");
                    }
                    job.setJobDate(new Date());
                    job.setJobType(jobTypeService.findByCode("Order"));
                    job.setDispatchScheduleList(new ArrayList<>());
                } else {
                    job = jobService.findOne(job.getId());
                }
            }

            dispatchSchedule.setJob(job);
            job.getDispatchScheduleList().add(dispatchSchedule);
            return service.save(dispatchSchedule);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(DispatchScheduleView.AllAndSalesOrderItemAllAndSalesOrderAllCustomerItemAllAndJobAllAndItemAll.class)
    @GetMapping("/{id}")
    public DispatchSchedule findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);
    }

    @PutMapping("/{id}")
    public DispatchSchedule update(@PathVariable int id, @RequestBody DispatchSchedule dispatchSchedule, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        dispatchSchedule.setId(id);
        dispatchSchedule = service.save(dispatchSchedule);
        return dispatchSchedule;
    }

    @JsonView(DispatchScheduleView.AllAndSalesOrderItemAllAndSalesOrderAllCustomerItemAllAndJobAllAndItemAllAndPaintAll.class)
    @GetMapping("/salesOrder/{id}")
    public Iterable<DispatchSchedule> findBySalesOrder(@PathVariable("id") int id) {
        return service.findBySalesOrderItemSalesOrder(new SalesOrder(id));
    }

    @JsonView(DispatchScheduleView.AllAndJobAndItem.class)
    @GetMapping("/customer/{id}")
    public Iterable<DispatchSchedule> findByCustomer(@PathVariable("id") int id) {
        return service.findBySalesOrderItemSalesOrderCustomer(new Customer(id));
    }
}
