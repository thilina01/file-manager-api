package com.trendsmixed.fma.module.productionemployee;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Pageable;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/productionEmployees")
public class ProductionEmployeeController {

    private final AppSessionService appSessionService;
    private final ProductionEmployeeService service;

    @JsonView(ProductionEmployeeView.All.class)
    @GetMapping
    public Iterable<ProductionEmployee> findAll() {
        return service.findAll();
    }

    @JsonView(ProductionEmployeeView.All.class)
    @GetMapping("/page")
    Page<ProductionEmployee> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(ProductionEmployeeView.All.class)
    @PostMapping
    public ProductionEmployee save(@RequestBody ProductionEmployee productionEmployee,
            @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            productionEmployee = service.save(productionEmployee);
            return productionEmployee;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<ProductionEmployee> productionEmployees,
            @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {

            service.save(productionEmployees);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(ProductionEmployeeView.All.class)
    @GetMapping("/{id}")
    public ProductionEmployee findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email,
            HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);
    }

    @JsonView(ProductionEmployeeView.All.class)
    @PutMapping("/{id}")
    public ProductionEmployee updateCustomer(@PathVariable int id, @RequestBody ProductionEmployee productionEmployee,
            @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        productionEmployee.setId(id);
        productionEmployee = service.save(productionEmployee);
        return productionEmployee;
    }
}
