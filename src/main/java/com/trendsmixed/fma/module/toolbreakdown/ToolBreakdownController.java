package com.trendsmixed.fma.module.toolbreakdown;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.module.tool.Tool;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import com.trendsmixed.fma.utility.Page;
import org.springframework.data.domain.Pageable;
import com.trendsmixed.fma.utility.Format;
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
    Page<ToolBreakdown> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }
    
    @JsonView(ToolBreakdownView.All.class)
    @GetMapping(value = "/toolBreakdown")
    public Page<ToolBreakdown> getToolBreakdownPage(
        @RequestParam(value = "tool", required = false, defaultValue = "0") String tool,
        @RequestParam(value = "startDate", required = false, defaultValue = "1970-01-01") String startDate,
        @RequestParam(value = "endDate", required = false, defaultValue = "2100-12-31") String endDate, 
        Pageable pageable) throws ParseException {
        Page<ToolBreakdown> page ;

        if(tool.equals("0") ){
            page = new Page(service.findByToolBreakdownTimeBetween(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));    
        } 
        else{
            page = new Page(service.findByToolAndToolBreakdownTimeBetween(new Tool(Integer.valueOf(tool)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate),pageable));
        }
        return page;
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
