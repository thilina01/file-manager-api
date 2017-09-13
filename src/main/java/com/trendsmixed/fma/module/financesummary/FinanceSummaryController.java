package com.trendsmixed.fma.module.financesummary     ;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.utility.Page;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

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
    public FinanceSummary save(@RequestBody FinanceSummary financeSummary  , @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
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
    public void saveMany(@RequestBody List<FinanceSummary> financeSummaries, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
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
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @PutMapping("/{id}")
    public FinanceSummary updateCustomer(@PathVariable int id, @RequestBody FinanceSummary financeSummary, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        financeSummary.setId(id);
        financeSummary= service.save(financeSummary    );
        return financeSummary;
    }

}
