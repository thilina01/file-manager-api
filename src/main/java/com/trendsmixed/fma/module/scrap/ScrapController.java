package com.trendsmixed.fma.module.scrap;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/scraps")
public class ScrapController {

    
    private final ScrapService service;

    @JsonView(ScrapView.All.class)
    @GetMapping
    public Iterable<Scrap> findAll() {
        return service.findAll();
    }

    @JsonView(ScrapView.AllAndItemTypeAllAndLossReasonAllAndOperationTypeAllAndSectionAllAndJobAll.class)
    @GetMapping("/page")
    Page<Scrap> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @JsonView(ScrapView.All.class)
    @PostMapping
    public Scrap save(@RequestBody Scrap scrap, @RequestHeader(value = "email", defaultValue = "") String email,
            HttpServletRequest request) {
        
        try {
            scrap = service.save(scrap);
            return scrap;
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<Scrap> scraps,
            @RequestHeader(value = "email", defaultValue = "") String email) {

        
        try {
            service.save(scraps);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(ScrapView.AllAndItemTypeAllAndLossReasonAllAndOperationTypeAllAndSectionAllAndJobAll.class)
    @GetMapping("/{id}")
    public Scrap findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email,
            HttpServletRequest request) {
        
        service.delete(id);

    }

    @JsonView(ScrapView.All.class)
    @PutMapping("/{id}")
    public Scrap updateCustomer(@PathVariable int id, @RequestBody Scrap scrap,
            @RequestHeader(value = "email", defaultValue = "") String email) {
        
        scrap.setId(id);
        scrap = service.save(scrap);
        return scrap;
    }
}
