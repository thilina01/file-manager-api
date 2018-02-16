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
    @GetMapping(value = "/breakdownDurationPage", params = {"startDate", "endDate"})
    public Page<Breakdown> breakdownDurationPage(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, Pageable pageable) throws ParseException {
        return new Page(service.findByBreakdownTimeBetween(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
    }
    @JsonView(BreakdownView.All.class)
    @GetMapping(value = "/breakdownDurationAndMachinePage", params = {"startDate", "endDate", "machine"})
    public Page<Breakdown> breakdownDurationAndMachinePage(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, @RequestParam("machine") String machine, Pageable pageable) throws ParseException {
        return new Page(service.findByBreakdownTimeBetweenAndMachine(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), new Machine(Integer.valueOf(machine)), pageable));
    } 
    @JsonView(BreakdownView.All.class)
    @GetMapping(value = "/breakdownTimeAndMachinePage", params = {"breakdownTime", "machine"})
    public Page<Breakdown> breakdownTimeAndMachinePage(@RequestParam("breakdownTime") String breakdownTime, @RequestParam("machine") String machine, Pageable pageable) throws ParseException {
        return new Page(service.findByBreakdownTimeAndMachine(Format.yyyy_MM_dd.parse(breakdownTime), new Machine(Integer.valueOf(machine)), pageable));
    }
    @JsonView(BreakdownView.All.class)
    @PostMapping("/pageByMachine")
    Page<Breakdown> pageByMachine(Pageable pageable, @RequestBody Machine machine) {
        if (machine.getId() == null) {
            machine = machineService.findByCode(machine.getCode());
        }
        return new Page<>(service.findByMachine(machine, pageable));
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
