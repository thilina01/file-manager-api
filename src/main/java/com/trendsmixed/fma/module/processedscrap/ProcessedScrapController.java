package com.trendsmixed.fma.module.processedscrap;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Pageable;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/processedScraps")
public class ProcessedScrapController {

    private final AppSessionService appSessionService;
    private final ProcessedScrapService service;

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
