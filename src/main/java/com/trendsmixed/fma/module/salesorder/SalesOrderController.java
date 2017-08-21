package com.trendsmixed.fma.module.salesorder;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.jobtype.JobType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.module.salesorderitem.SalesOrderItem;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.module.jobtype.JobTypeService;
import com.trendsmixed.fma.utility.Page;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@RestController
@CrossOrigin
@RequestMapping("/salesOrders")
public class SalesOrderController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private SalesOrderService service;
    @Autowired
    private JobTypeService jobTypeService;

    @JsonView(SalesOrderView.AllAndCustomerAllAndSalesOrderTypeAll.class)
    @GetMapping
    public Iterable<SalesOrder> findAll() {
        return service.findAll();
    }

    /**
     * ***************************************************************
     */
    @JsonView(SalesOrderView.All.class)
    @GetMapping("/page")
    Page<SalesOrder> page(Pageable pageable) {
        return new Page<SalesOrder>(service.findAll(pageable));
    }
    
    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }
    /**
     * ***************************************************************
     */
    @JsonView(SalesOrderView.AllAndSalesOrderItemAll.class)
    @PostMapping
    public SalesOrder save(@RequestBody SalesOrder salesOrder, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        JobType jobType = jobTypeService.findByCode("SOJ");
        if (jobType == null) {
            jobType = new JobType();
            jobType.setCode("SOJ");
            jobType.setName("Sales order job");
            jobType = jobTypeService.save(jobType);
        }
        try {
            List<SalesOrderItem> salesOrderItems = salesOrder.getSalesOrderItemList();
            for (SalesOrderItem salesOrderItem : salesOrderItems) {
                salesOrderItem.setSalesOrder(salesOrder);
//                Job job = salesOrderItem.getJob();
//                job = job == null ? new Job() : job;
//                job.setItem(salesOrderItem.getItem());
//                job.setJobDate(salesOrder.getOrderReceivedDate());
//                job.setJobType(jobType);
//                job.setSalesOrderItem(salesOrderItem);
//                job.setQuantity(salesOrderItem.getQuantity());
//                salesOrderItem.setJob(job);
            }
            salesOrder = service.save(salesOrder);
            return salesOrder;

        } catch (Throwable e) {
            e.printStackTrace();
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public SalesOrder findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @PutMapping("/{id}")
    public SalesOrder updateCustomer(@PathVariable int id, @RequestBody SalesOrder salesOrder, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        salesOrder.setId(id);
        salesOrder = service.save(salesOrder);
        return salesOrder;
    }
}
