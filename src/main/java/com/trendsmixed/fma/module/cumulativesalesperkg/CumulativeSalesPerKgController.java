package com.trendsmixed.fma.module.cumulativesalesperkg;

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
@RequestMapping("/cumulativeSalesPerKgs")
public class CumulativeSalesPerKgController {

    private final AppSessionService appSessionService;
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
    public CumulativeSalesPerKg save(@RequestBody CumulativeSalesPerKg cumulativeSalesPerKg, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
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
    public void saveMany(@RequestBody List<CumulativeSalesPerKg> cumulativeSalesPerKgs, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
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
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @PutMapping("/{id}")
    public CumulativeSalesPerKg updateCustomer(@PathVariable int id, @RequestBody CumulativeSalesPerKg cumulativeSalesPerKg, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        cumulativeSalesPerKg.setId(id);
        cumulativeSalesPerKg = service.save(cumulativeSalesPerKg);
        return cumulativeSalesPerKg;
    }

}
