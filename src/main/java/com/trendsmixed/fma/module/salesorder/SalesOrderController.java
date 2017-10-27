package com.trendsmixed.fma.module.salesorder;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.jobtype.JobType;
import com.trendsmixed.fma.module.salesorderitem.SalesOrderItem;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.module.jobtype.JobTypeService;
import com.trendsmixed.fma.module.salesorderitem.SalesOrderItemService;
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
@RequestMapping("/salesOrders")
public class SalesOrderController {

    private final AppSessionService appSessionService;
    private final SalesOrderService service;
    private final SalesOrderItemService salesOrderItemService;
    private final JobTypeService jobTypeService;

    @JsonView(SalesOrderView.AllAndCustomerAllAndSalesOrderTypeAll.class)
    @GetMapping
    public Iterable<SalesOrder> findAll() {
        return service.findAll();
    }

    @JsonView(SalesOrderView.AllAndCustomerAllAndSalesOrderTypeAll.class)
    @GetMapping("/page")
    Page<SalesOrder> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(SalesOrderView.AllAndCustomerAllAndSalesOrderTypeAll.class)
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
                if (salesOrderItem.getId() != null) {
                    SalesOrderItem existingSalesOrderItem = salesOrderItemService.findOne(salesOrderItem.getId());
                    salesOrderItem.setDispatchScheduleList(existingSalesOrderItem != null ? existingSalesOrderItem.getDispatchScheduleList() : new ArrayList<>());
                }
                salesOrderItem.setSalesOrder(salesOrder);

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

    @JsonView(SalesOrderView.AllAndCustomerAllAndSalesOrderTypeAllAndSalesOrderItemAllAndCustomerItemAllAndItemAllAndDispatchScheduleAll.class)
    @GetMapping("/{id}")
    public SalesOrder findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @JsonView(SalesOrderView.AllAndCustomerAllAndSalesOrderTypeAll.class)
    @PutMapping("/{id}")
    public SalesOrder updateCustomer(@PathVariable int id, @RequestBody SalesOrder salesOrder, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        salesOrder.setId(id);
        salesOrder = service.save(salesOrder);
        return salesOrder;
    }
}
