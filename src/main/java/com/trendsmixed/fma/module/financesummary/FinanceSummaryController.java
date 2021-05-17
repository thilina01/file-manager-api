package com.trendsmixed.fma.module.financesummary;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/financeSummaries")
public class FinanceSummaryController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private FinanceSummaryService service;

    @JsonView(FinanceSummaryView.All.class)
    @GetMapping
    public Iterable<FinanceSummary> findAll() {
        return service.findAll();
    }

    @JsonView(FinanceSummaryView.All.class)
    @GetMapping("/page")
    public Page<FinanceSummary> page(Pageable pageable) {
        return new Page(service.findAll(pageable));
    }

    @JsonView(FinanceSummaryView.All.class)
    @PostMapping
    public FinanceSummary save(@RequestBody FinanceSummary financeSummary) {

        
        try {
            financeSummary = service.save(financeSummary);
            return financeSummary;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<FinanceSummary> financeSummaries) {

        
        try {
            service.save(financeSummaries);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    @JsonView(FinanceSummaryView.All.class)
    public FinanceSummary findOne(@PathVariable("id") int id) {
        return service.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        
        service.deleteById(id);

    }

    @PutMapping("/{id}")
    public FinanceSummary updateCustomer(@PathVariable int id, @RequestBody FinanceSummary financeSummary) {
        
        financeSummary.setId(id);
        financeSummary = service.save(financeSummary);
        return financeSummary;
    }

}
