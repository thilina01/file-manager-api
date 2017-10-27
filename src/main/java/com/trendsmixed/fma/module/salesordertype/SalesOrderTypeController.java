package com.trendsmixed.fma.module.salesordertype;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.utility.Page;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/salesOrderTypes")
public class SalesOrderTypeController {

    private final AppSessionService appSessionService;
    private final SalesOrderTypeService service;

    @JsonView(SalesOrderTypeView.All.class)
    @GetMapping
    public Iterable<SalesOrderType> findAll() {
        return service.findAll();
    }

    @JsonView(SalesOrderTypeView.All.class)
    @GetMapping("/page")
    Page<SalesOrderType> page(Pageable pageable) {
        return new Page(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(SalesOrderTypeView.All.class)
    @PostMapping
    public SalesOrderType save(@RequestBody SalesOrderType salesOrderType, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            salesOrderType = service.save(salesOrderType);
            return salesOrderType;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public SalesOrderType findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @PutMapping("/{id}")
    public SalesOrderType updateCustomer(@PathVariable int id, @RequestBody SalesOrderType salesOrderType, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        salesOrderType.setId(id);
        salesOrderType = service.save(salesOrderType);
        return salesOrderType;
    }
}
