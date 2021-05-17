package com.trendsmixed.fma.module.cumulativesalesperkg;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/cumulativeSalesPerKgs")
public class CumulativeSalesPerKgController {

    
    private final CumulativeSalesPerKgService service;

    @JsonView(CumulativeSalesPerKgView.All.class)
    @GetMapping
    public Iterable<CumulativeSalesPerKg> findAll() {
        return service.findAll();
    }

    @JsonView(CumulativeSalesPerKgView.All.class)
    @GetMapping("/page")
    Page<CumulativeSalesPerKg> page(Pageable pageable) {
        return service.findAll(pageable);
    }

    @PostMapping
    public CumulativeSalesPerKg save(@RequestBody CumulativeSalesPerKg cumulativeSalesPerKg) {

        
        try {
            cumulativeSalesPerKg = service.save(cumulativeSalesPerKg);
            return cumulativeSalesPerKg;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<CumulativeSalesPerKg> cumulativeSalesPerKgs) {

        
        try {
            service.save(cumulativeSalesPerKgs);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    @JsonView(CumulativeSalesPerKgView.All.class)
    public CumulativeSalesPerKg findOne(@PathVariable("id") int id) {
        return service.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        
        service.deleteById(id);

    }

    @PutMapping("/{id}")
    public CumulativeSalesPerKg updateCustomer(@PathVariable int id, @RequestBody CumulativeSalesPerKg cumulativeSalesPerKg) {
        
        cumulativeSalesPerKg.setId(id);
        cumulativeSalesPerKg = service.save(cumulativeSalesPerKg);
        return cumulativeSalesPerKg;
    }

}
