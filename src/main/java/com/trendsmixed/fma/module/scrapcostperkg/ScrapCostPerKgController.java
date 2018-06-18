package com.trendsmixed.fma.module.scrapcostperkg;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/scrapCostPerKgs")
public class ScrapCostPerKgController {

    
    private final ScrapCostPerKgService service;

    @JsonView(ScrapCostPerKgView.All.class)
    @GetMapping
    public Iterable<ScrapCostPerKg> findAll() {
        return service.findAll();
    }

    @JsonView(ScrapCostPerKgView.All.class)
    @GetMapping("/page")
    Page<ScrapCostPerKg> page(Pageable pageable) {
        return service.findAll(pageable);
    }

    @PostMapping
    public ScrapCostPerKg save(@RequestBody ScrapCostPerKg scrapCostPerKg) {

        
        try {
            scrapCostPerKg = service.save(scrapCostPerKg);
            return scrapCostPerKg;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<ScrapCostPerKg> scrapCostPerKgs) {

        
        try {
            service.save(scrapCostPerKgs);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    @JsonView(ScrapCostPerKgView.All.class)
    public ScrapCostPerKg findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        
        service.delete(id);

    }

    @PutMapping("/{id}")
    public ScrapCostPerKg updateCustomer(@PathVariable int id, @RequestBody ScrapCostPerKg scrapCostPerKg) {
        
        scrapCostPerKg.setId(id);
        scrapCostPerKg = service.save(scrapCostPerKg);
        return scrapCostPerKg;
    }

}
