package com.trendsmixed.fma.module.processedscrap;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.utility.Page;

@RestController
@CrossOrigin
@RequestMapping("/processedScraps")
public class ProcessedScrapController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private ProcessedScrapService service;

    @JsonView(ProcessedScrapView.All.class)
    @GetMapping
    public Iterable<ProcessedScrap> findAll() {
        return service.findAll();
    }

    @JsonView(ProcessedScrapView.All.class)
    @GetMapping("/page")
    Page<ProcessedScrap> page(Pageable pageable) {
        return service.findAll(pageable);
    }

    @PostMapping
    public ProcessedScrap save(@RequestBody ProcessedScrap processedScrap,
            @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            processedScrap = service.save(processedScrap);
            return processedScrap;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<ProcessedScrap> processedScraps,
            @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {

            service.save(processedScraps);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(ProcessedScrapView.All.class)
    @GetMapping("/{id}")
    public ProcessedScrap findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email,
            HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @PutMapping("/{id}")
    public ProcessedScrap updateCustomer(@PathVariable int id, @RequestBody ProcessedScrap processedScrap,
            @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        processedScrap.setId(id);
        processedScrap = service.save(processedScrap);
        return processedScrap;
    }
}
