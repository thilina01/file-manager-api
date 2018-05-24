package com.trendsmixed.fma.module.salesorder;
import com.trendsmixed.fma.module.customer.Customer;
import com.trendsmixed.fma.module.customer.CustomerService;
import com.trendsmixed.fma.module.salesordertype.SalesOrderType;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.jobtype.JobType;
import com.trendsmixed.fma.module.salesorderitem.SalesOrderItem;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.module.jobtype.JobTypeService;
import com.trendsmixed.fma.utility.Format;
import java.text.ParseException;
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
    private final CustomerService customerService;

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
    @JsonView(SalesOrderView.AllAndCustomerAllAndSalesOrderTypeAll.class)
    @GetMapping(value = "/salesOrderDurationPage", params = {"startDate", "endDate"})
    public Page<SalesOrder> salesOrderDurationPage(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, Pageable pageable) throws ParseException {
        return new Page(service.findByOrderDateBetween(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
    }
    @JsonView(SalesOrderView.AllAndCustomerAllAndSalesOrderTypeAll.class)
    @GetMapping(value = "/orderDateAndSalesOrderTypePage", params = {"orderDate", "salesOrderType"})
    public Page<SalesOrder> orderDateAndSalesOrderTypePage(@RequestParam("orderDate") String orderDate, @RequestParam("salesOrderType") String salesOrderType, Pageable pageable) throws ParseException {
        return new Page(service.findByOrderDateAndSalesOrderType(Format.yyyy_MM_dd.parse(orderDate), new SalesOrderType(Integer.valueOf(salesOrderType)), pageable));
    }
    @JsonView(SalesOrderView.AllAndCustomerAllAndSalesOrderTypeAll.class)
    @GetMapping(value = "/salesOrderDurationAndSalesOrderTypePage", params = {"startDate", "endDate", "salesOrderType"})
    public Page<SalesOrder> salesOrderDurationAndSalesOrderTypePage(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, @RequestParam("salesOrderType") String salesOrderType, Pageable pageable) throws ParseException {
        return new Page(service.findByOrderDateBetweenAndSalesOrderType(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new SalesOrderType(Integer.valueOf(salesOrderType)), pageable));
    }
    @JsonView(SalesOrderView.AllAndCustomerAllAndSalesOrderTypeAll.class)
    @GetMapping(value = "/customerAndSalesOrderDurationPage", params = {"customer", "startDate", "endDate"})
    public Page<SalesOrder> customerAndSalesOrderDurationPage(@RequestParam("customer") String customer, @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, Pageable pageable) throws ParseException {
        return new Page(service.findByCustomerAndOrderDateBetween(new Customer(Integer.valueOf(customer)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
    }
    @JsonView(SalesOrderView.AllAndCustomerAllAndSalesOrderTypeAll.class)
    @GetMapping(value = "/customerAndOrderDateAndSalesOrderTypePage", params = {"customer", "orderDate", "salesOrderType"})
    public Page<SalesOrder> customerAndOrderDateAndSalesOrderTypePage(@RequestParam("customer") String customer, @RequestParam("orderDate") String orderDate, @RequestParam("salesOrderType") String salesOrderType, Pageable pageable) throws ParseException {
        return new Page(service.findByCustomerAndOrderDateAndSalesOrderType(new Customer(Integer.valueOf(customer)), Format.yyyy_MM_dd.parse(orderDate), new SalesOrderType(Integer.valueOf(salesOrderType)), pageable));
    }
    @JsonView(SalesOrderView.AllAndCustomerAllAndSalesOrderTypeAll.class)
    @GetMapping(value = "/customerAndSalesOrderDurationAndSalesOrderTypePage", params = {"customer", "startDate", "endDate", "salesOrderType"})
    public Page<SalesOrder> customerAndSalesOrderDurationAndSalesOrderTypePage(@RequestParam("customer") String customer, @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, @RequestParam("salesOrderType") String salesOrderType, Pageable pageable) throws ParseException {
        return new Page(service.findByCustomerAndOrderDateBetweenAndSalesOrderType(new Customer(Integer.valueOf(customer)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new SalesOrderType(Integer.valueOf(salesOrderType)), pageable));
    }
    @JsonView(SalesOrderView.AllAndCustomerAllAndSalesOrderTypeAll.class)
    @PostMapping("/pageByCustomer")
    Page<SalesOrder> pageByCustomer(Pageable pageable, @RequestBody Customer customer) {
        if (customer.getId() == null) {
            customer = customerService.findByCode(customer.getCode());
        }
        return new Page<>(service.findByCustomer(customer, pageable));
    }
    
    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @GetMapping("/comboByCustomer/{id}")
    List<Combo> combo(@PathVariable("id") int id) {
        return service.getComboByCustomer(new Customer(id));
    }
    
    @JsonView(SalesOrderView.AllAndCustomerAllAndSalesOrderTypeAll.class)
    @PostMapping
    public SalesOrder save(@RequestBody SalesOrder salesOrder, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
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
