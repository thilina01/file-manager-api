package com.trendsmixed.fma.module.breakdown;

import com.trendsmixed.fma.module.machine.Machine;
import com.trendsmixed.fma.module.machine.MachineService;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.utility.Page;
import javax.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import com.trendsmixed.fma.utility.Format;
import java.text.ParseException;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/breakdowns")
public class BreakdownController {

    private final BreakdownService service;
    private final AppSessionService appSessionService;
    private final MachineService machineService;

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
    return new Page<>(service.findAll(pageable));
    }

    @JsonView(BreakdownView.All.class)
    @GetMapping(value = "/breakdown")
    public Page<Breakdown> getBreakdownPage(
        @RequestParam(value = "machine", required = false, defaultValue = "0") String machine,
        @RequestParam(value = "startDate", required = false, defaultValue = "1970-01-01") String startDate,
        @RequestParam(value = "endDate", required = false, defaultValue = "2100-12-31") String endDate, 
        Pageable pageable) throws ParseException {
        Page<Breakdown> page ;

        if(machine.equals("0") ){
            page = new Page(service.findByBreakdownTimeBetween(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
        } 
        else{
            page = new Page(service.findByBreakdownTimeBetweenAndMachine(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new Machine(Integer.valueOf(machine)), pageable));
        }
        return page;
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
