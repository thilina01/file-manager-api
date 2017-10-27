package com.trendsmixed.fma.module.breakdown;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.utility.Page;
import javax.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/breakdowns")
public class BreakdownController {

    private final BreakdownService service;
    private final AppSessionService appSessionService;

    @PostMapping
    @JsonView(BreakdownView.All.class)
    public Breakdown save(@RequestBody Breakdown breakdown, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            breakdown = service.save(breakdown);
            return breakdown;
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping
    @JsonView(BreakdownView.All.class)
    public Iterable<Breakdown> findAll() {
        return service.findAll();
    }

    @JsonView(BreakdownView.All.class)
    @GetMapping("/page")
    Page<Breakdown> page(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/{id}")
    @JsonView(BreakdownView.All.class)
    public Breakdown findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @PutMapping("/{id}")
    @JsonView(BreakdownView.All.class)
    public Breakdown updateCustomer(@PathVariable int id, @RequestBody Breakdown breakdown, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        breakdown.setId(id);
        breakdown = service.save(breakdown);
        return breakdown;
    }
}
