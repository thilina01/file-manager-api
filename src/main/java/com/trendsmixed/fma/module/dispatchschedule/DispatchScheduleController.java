package com.trendsmixed.fma.module.dispatchschedule;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.customer.Customer;
import com.trendsmixed.fma.module.customer.CustomerService;
import com.trendsmixed.fma.module.item.Item;
import com.trendsmixed.fma.module.job.Job;
import com.trendsmixed.fma.module.job.JobService;
import com.trendsmixed.fma.module.jobtype.JobTypeService;
import com.trendsmixed.fma.module.salesorder.SalesOrder;
import com.trendsmixed.fma.module.salesordertype.SalesOrderType;
import com.trendsmixed.fma.utility.Format;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/dispatchSchedules")
public class DispatchScheduleController {

    
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
    @GetMapping(value = "/dispatchSchedule")
    public Page<DispatchSchedule> getDispatchSchedule(
        @RequestParam(value = "customer", required = false, defaultValue = "0") String customer,
        @RequestParam(value = "customerPoNumber", required = false, defaultValue = "0") String customerPoNumber,   
        @RequestParam(value = "job", required = false, defaultValue = "0") String job,   
        @RequestParam(value = "startDate", required = false, defaultValue = "1970-01-01") String startDate,
        @RequestParam(value = "endDate", required = false, defaultValue = "2100-12-31") String endDate, 
        Pageable pageable) throws ParseException {
        Page<DispatchSchedule> page ;

        if(!customerPoNumber.equals("0")){
            page = new Page(service.findBySalesOrderItemSalesOrderCustomerPoNumber(customerPoNumber, pageable));
        }
        else if(startDate.equals("1970-01-01")&& endDate.equals("2100-12-31") && customer.equals("0")&& job.equals("0") ){
            page = new Page(service.findByConfirmDateNotNull(pageable));
        }
        else if(customer.equals("0")&& job.equals("0") ){
            page = new Page(service.findByDispatchScheduleDateBetween(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
        } 
        else if(customer.equals("0") ){
            page = new Page(service.findByDispatchScheduleDateBetweenAndJob(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new Job(Integer.valueOf(job)), pageable));
        }
        else if(job.equals("0") ){
            page = new Page(service.findBySalesOrderItemSalesOrderCustomerAndDispatchScheduleDateBetween(new Customer(Integer.valueOf(customer)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
        }
        else {
            page = new Page(service.findBySalesOrderItemSalesOrderCustomerAndDispatchScheduleDateBetweenAndJob(new Customer(Integer.valueOf(customer)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new Job(Integer.valueOf(job)), pageable));
        }
        return page;
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

    @JsonView(DispatchScheduleView.AllAndSalesOrderItemAllAndSalesOrderAllAndSalesOrderTypeAllAndCustomerAllCustomerItemAllAndJobAllAndPaintAllAndItemAllAndLoadingPlanItemAllAndLoadingPlanAll.class)
    @GetMapping(value = "/orderInformation")
    public Page<DispatchSchedule> getOrderInformation(
        @RequestParam(value = "customer", required = false, defaultValue = "0") String customer, 
        @RequestParam(value = "job", required = false, defaultValue = "0") String job, 
        @RequestParam(value = "item", required = false, defaultValue = "0") String item, 
        @RequestParam(value = "salesOrderType", required = false, defaultValue = "0") String salesOrderType, 
        @RequestParam(value = "startDate", required = false, defaultValue = "1970-01-01") String startDate, 
        @RequestParam(value = "endDate", required = false, defaultValue = "2100-12-31") String endDate, 
        Pageable pageable) throws ParseException {
        Page<DispatchSchedule> page ;

        if(customer.equals("0") && job.equals("0") && item.equals("0") && salesOrderType.equals("0")){
            page = new Page(service.findBySalesOrderItemSalesOrderOrderDateBetween( Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
        } 
        else if(job.equals("0") && item.equals("0") && salesOrderType.equals("0")){
            page = new Page(service.findBySalesOrderItemSalesOrderCustomerAndSalesOrderItemSalesOrderOrderDateBetween(new Customer(Integer.valueOf(customer)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
        }
        else if(customer.equals("0") && item.equals("0") && salesOrderType.equals("0")){
            page = new Page(service.findBySalesOrderItemSalesOrderOrderDateBetweenAndJob(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new Job(Integer.valueOf(job)), pageable));
        }
        else if(customer.equals("0") && job.equals("0") && salesOrderType.equals("0")){
            page = new Page(service.findByJobItemAndSalesOrderItemSalesOrderOrderDateBetween(new Item(Integer.valueOf(item)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
        }
        else if(customer.equals("0") && job.equals("0") && item.equals("0")){
            page = new Page(service.findBySalesOrderItemSalesOrderSalesOrderTypeAndSalesOrderItemSalesOrderOrderDateBetween(new SalesOrderType(Integer.valueOf(salesOrderType)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
        }
        else if(customer.equals("0") && salesOrderType.equals("0")){
            page = new Page(service.findByJobItemAndSalesOrderItemSalesOrderOrderDateBetweenAndJob(new Item(Integer.valueOf(item)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new Job(Integer.valueOf(job)), pageable));
        }
        else if(customer.equals("0") && job.equals("0")){
            page = new Page(service.findByJobItemAndSalesOrderItemSalesOrderOrderDateBetweenAndSalesOrderItemSalesOrderSalesOrderType(new Item(Integer.valueOf(item)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new SalesOrderType(Integer.valueOf(salesOrderType)), pageable));
        }
        else if(job.equals("0")  && salesOrderType.equals("0")){
            page = new Page(service.findByJobItemAndSalesOrderItemSalesOrderOrderDateBetweenAndSalesOrderItemSalesOrderCustomer(new Item(Integer.valueOf(item)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new Customer(Integer.valueOf(customer)), pageable));
        }
        else if(item.equals("0") && salesOrderType.equals("0")){
            page = new Page(service.findBySalesOrderItemSalesOrderCustomerAndSalesOrderItemSalesOrderOrderDateBetweenAndJob(new Customer(Integer.valueOf(customer)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new Job(Integer.valueOf(job)), pageable));
        }
        else if(customer.equals("0") && item.equals("0") ){
            page = new Page(service.findBySalesOrderItemSalesOrderSalesOrderTypeAndSalesOrderItemSalesOrderOrderDateBetweenAndJob(new SalesOrderType(Integer.valueOf(salesOrderType)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new Job(Integer.valueOf(job)), pageable));
        }
        else{
            page = new Page(service.findBySalesOrderItemSalesOrderSalesOrderTypeAndSalesOrderItemSalesOrderOrderDateBetweenAndSalesOrderItemSalesOrderCustomer(new SalesOrderType(Integer.valueOf(salesOrderType)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new Customer(Integer.valueOf(customer)), pageable));
        }
        return page;
    }

    @JsonView(DispatchScheduleView.AllAndSalesOrderItemAllAndSalesOrderAllCustomerItemAllAndJobAllAndItemAll.class)
    @PostMapping
    public DispatchSchedule save(@RequestBody DispatchSchedule dispatchSchedule) {
        
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
                    job = jobService.findById(job.getId());
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
        return service.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        
        service.deleteById(id);
    }

    @PutMapping("/{id}")
    public DispatchSchedule update(@PathVariable int id, @RequestBody DispatchSchedule dispatchSchedule) {
        
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
