package com.trendsmixed.fma.module.productionoverheadcostperkg;

import com.fasterxml.jackson.annotation.JsonView;
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
@RequestMapping("/productionOverheadCostPerKgs")
public class ProductionOverheadCostPerKgController {

    private final AppSessionService appSessionService;
    private final ProductionOverheadCostPerKgService service;

    @JsonView(ProductionOverheadCostPerKgView.All.class)
    @GetMapping
    public Iterable<ProductionOverheadCostPerKg> findAll() {
        return service.findAll();
    }

    @JsonView(ProductionOverheadCostPerKgView.All.class)
    @GetMapping("/page")
    Page<ProductionOverheadCostPerKg> page(Pageable pageable) {
        return service.findAll(pageable);
    }

    @PostMapping
    public ProductionOverheadCostPerKg save(@RequestBody ProductionOverheadCostPerKg productionOverheadCostPerKg, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
        try {
            productionOverheadCostPerKg = service.save(productionOverheadCostPerKg);
            return productionOverheadCostPerKg;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<ProductionOverheadCostPerKg> productionOverheadCostPerKgs, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
        try {
            service.save(productionOverheadCostPerKgs);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    @JsonView(ProductionOverheadCostPerKgView.All.class)
    public ProductionOverheadCostPerKg findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @PutMapping("/{id}")
    public ProductionOverheadCostPerKg updateCustomer(@PathVariable int id, @RequestBody ProductionOverheadCostPerKg productionOverheadCostPerKg, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        productionOverheadCostPerKg.setId(id);
        productionOverheadCostPerKg = service.save(productionOverheadCostPerKg);
        return productionOverheadCostPerKg;
    }

}
