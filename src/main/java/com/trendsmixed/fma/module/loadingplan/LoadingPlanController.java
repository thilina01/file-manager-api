package com.trendsmixed.fma.module.loadingplan;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Pageable;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.module.loadingplanitem.LoadingPlanItem;
import com.trendsmixed.fma.module.customer.Customer;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/loadingPlans")
public class LoadingPlanController {

    private final AppSessionService appSessionService;
    private final LoadingPlanService service;

    @JsonView(LoadingPlanView.AllAndLoadingPlanItemAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPackagingSpecificationAndPortOfLoadingAndContainerSizeAndAddressAndCustomer.class)
    @GetMapping
    public Iterable<LoadingPlan> findAll() {
        return service.findAll();
    }

    @JsonView(LoadingPlanView.AllAndLoadingPlanItemAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPackagingSpecificationAndPortOfLoadingAndContainerSizeAndAddressAndCustomer.class)
    @GetMapping("/page")
    Page<LoadingPlan> page(Pageable pageable) {
        return service.findAll(pageable);
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

    @JsonView(LoadingPlanView.AllAndLoadingPlanItemAndDispatchScheduleAndJobAndItemAndSalesOrderItemAndSalesOrderAndCustomerItemAndPortOfLoadingAndContainerSizeAndAddressAndCustomer.class)
    @PostMapping
    public LoadingPlan save(@RequestBody LoadingPlan loadingPlan, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
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
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @PutMapping("/{id}")
    public LoadingPlan updateCustomer(@PathVariable int id, @RequestBody LoadingPlan loadingPlan, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        loadingPlan.setId(id);
        loadingPlan = service.save(loadingPlan);
        return loadingPlan;
    }
}
