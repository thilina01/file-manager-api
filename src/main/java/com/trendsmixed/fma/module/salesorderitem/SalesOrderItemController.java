package com.trendsmixed.fma.module.salesorderitem;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/salesOrderItems")
public class SalesOrderItemController {

    private final AppSessionService appSessionService;
    private final SalesOrderItemService salesOrderItemService;

    @GetMapping
    @JsonView(SalesOrderItemView.AllAndCustomerItemAllAndSalesOrderAllAndDispatchScheduleAll.class)
    public List<SalesOrderItem> findAll() {
        return salesOrderItemService.findAll();
    }

    @PostMapping
    public SalesOrderItem save(@RequestBody SalesOrderItem salesOrderItem, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            salesOrderItem = salesOrderItemService.save(salesOrderItem);
            return salesOrderItem;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(SalesOrderItemView.AllAndCustomerItemAllAndItemAllAndSalesOrderAllAndDispatchScheduleAll.class)
    @GetMapping("/{id}")
    public SalesOrderItem findOne(@PathVariable("id") int id) {
        return salesOrderItemService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        salesOrderItemService.delete(id);

    }

    @PutMapping("/{id}")
    public SalesOrderItem updateCustomer(@PathVariable int id, @RequestBody SalesOrderItem salesOrderItem, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        salesOrderItem.setId(id);
        salesOrderItem = salesOrderItemService.save(salesOrderItem);
        return salesOrderItem;
    }
}
