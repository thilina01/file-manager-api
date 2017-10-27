package com.trendsmixed.fma.module.toolbreakdown;

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
@RequestMapping("/toolBreakdowns")
public class ToolBreakdownController {

    private final ToolBreakdownService service;
    private final AppSessionService appSessionService;

    @PostMapping
    @JsonView(ToolBreakdownView.All.class)
    public ToolBreakdown save(@RequestBody ToolBreakdown toolBreakdown, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            toolBreakdown = service.save(toolBreakdown);
            return toolBreakdown;
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping
    @JsonView(ToolBreakdownView.All.class)
    public Iterable<ToolBreakdown> findAll() {
        return service.findAll();
    }

    @JsonView(ToolBreakdownView.All.class)
    @GetMapping("/page")
    public Page<ToolBreakdown> page(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/{id}")
    @JsonView(ToolBreakdownView.All.class)
    public ToolBreakdown findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @PutMapping("/{id}")
    @JsonView(ToolBreakdownView.All.class)
    public ToolBreakdown update(@PathVariable int id, @RequestBody ToolBreakdown toolBreakdown, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        toolBreakdown.setId(id);
        toolBreakdown = service.save(toolBreakdown);
        return toolBreakdown;
    }
}
