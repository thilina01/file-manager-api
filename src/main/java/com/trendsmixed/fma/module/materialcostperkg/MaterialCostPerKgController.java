package com.trendsmixed.fma.module.materialcostperkg;

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
@RequestMapping("/materialCostPerKgs")
public class MaterialCostPerKgController {

    private final AppSessionService appSessionService;
    private final MaterialCostPerKgService service;

    @JsonView(MaterialCostPerKgView.All.class)
    @GetMapping
    public Iterable<MaterialCostPerKg> findAll() {
        return service.findAll();
    }

    @JsonView(MaterialCostPerKgView.All.class)
    @GetMapping("/page")
    Page<MaterialCostPerKg> page(Pageable pageable) {
        return service.findAll(pageable);
    }

    @PostMapping
    public MaterialCostPerKg save(@RequestBody MaterialCostPerKg materialCostPerKg, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
        try {
            materialCostPerKg = service.save(materialCostPerKg);
            return materialCostPerKg;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<MaterialCostPerKg> materialCostPerKgs, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
        try {
            service.save(materialCostPerKgs);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    @JsonView(MaterialCostPerKgView.All.class)
    public MaterialCostPerKg findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @PutMapping("/{id}")
    public MaterialCostPerKg updateCustomer(@PathVariable int id, @RequestBody MaterialCostPerKg materialCostPerKg, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        materialCostPerKg.setId(id);
        materialCostPerKg = service.save(materialCostPerKg);
        return materialCostPerKg;
    }

}
