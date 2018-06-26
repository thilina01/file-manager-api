package com.trendsmixed.fma.module.loadingplan;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.customer.Customer;
import com.trendsmixed.fma.module.loadingplanitem.LoadingPlanItem;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import com.trendsmixed.fma.utility.Format;
import java.text.ParseException;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/loadingPlans")
public class LoadingPlanController {

    
    private final LoadingPlanService service;

    @JsonView(LoadingPlanView.AllAndLoadingPlanItemAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPackagingSpecificationAndPortOfLoadingAndContainerSizeAndAddressAndCustomer.class)
    @GetMapping
    public Iterable<LoadingPlan> findAll() {
        return service.findAll();
    }

    @JsonView(LoadingPlanView.AllAndLoadingPlanItemAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPackagingSpecificationAndPortOfLoadingAndContainerSizeAndAddressAndCustomer.class)
    @GetMapping("/page")
    Page<LoadingPlan> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(LoadingPlanView.AllAndLoadingPlanItemAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPackagingSpecificationAndPortOfLoadingAndContainerSizeAndAddressAndCustomer.class)
    @GetMapping("/comboByCustomer/{id}")
    public Iterable<LoadingPlan> findByCustomer(@PathVariable("id") int id) {
        return service.findByCustomer(new Customer(id));
    }
    
    @JsonView(LoadingPlanView.AllAndLoadingPlanItemAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPackagingSpecificationAndPortOfLoadingAndContainerSizeAndAddressAndCustomer.class)
    @GetMapping(value = "/customerAndLoadingPlanDateBetween")
    public Page<LoadingPlan> getCustomerAndLoadingPlanDateBetweenPage(
        @RequestParam(value = "customer", required = false, defaultValue = "0") String customer,
        @RequestParam(value = "startDate", required = false, defaultValue = "1970-01-01") String startDate,
        @RequestParam(value = "endDate", required = false, defaultValue = "2100-12-31") String endDate, 
        Pageable pageable) throws ParseException {
        Page<LoadingPlan> page ;

        if(customer.equals("0") ){
            page = new Page(service.findByLoadingPlanDateBetween(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));    
        } 

        else{
            page = new Page(service.findByCustomerAndLoadingPlanDateBetween(new Customer(Integer.valueOf(customer)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
        }
        return page;
    }

    @JsonView(LoadingPlanView.AllAndLoadingPlanItemAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPortOfLoadingAndContainerSizeAndAddressAndCustomer.class)
    @PostMapping
    public LoadingPlan save(@RequestBody LoadingPlan loadingPlan) {
        
        try {

            List<LoadingPlanItem> loadingPlanItems = loadingPlan.getLoadingPlanItemList();
            if (loadingPlanItems != null) {
                for (LoadingPlanItem loadingPlanItem : loadingPlanItems) {
                    loadingPlanItem.setLoadingPlan(loadingPlan);
                }
            }

            loadingPlan = service.save(loadingPlan);
            return loadingPlan;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(LoadingPlanView.AllAndLoadingPlanItemAndDispatchNoteAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPackagingSpecificationAndPortOfLoadingAndContainerSizeAndAddressAndCountryAndPortAndCustomer.class)
    @GetMapping("/{id}")
    public LoadingPlan findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        
        service.delete(id);

    }

    @PutMapping("/{id}")
    public LoadingPlan updateCustomer(@PathVariable int id, @RequestBody LoadingPlan loadingPlan) {
        
        loadingPlan.setId(id);
        loadingPlan = service.save(loadingPlan);
        return loadingPlan;
    }
}
