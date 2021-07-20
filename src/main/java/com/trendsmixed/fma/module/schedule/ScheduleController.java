package com.trendsmixed.fma.module.schedule;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.log.LogExecution;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/schedules")
public class ScheduleController {

    private final ScheduleService service;

    @LogExecution
    @JsonView(ScheduleView.All.class)
    @GetMapping
    public Iterable<Schedule> findAll() {
        return service.findAll();
    }

    @LogExecution
    @JsonView(ScheduleView.All.class)
    @GetMapping("/page")
    public Page<Schedule> page(Pageable pageable) {
        return new Page(service.findAll(pageable));
    }

    @LogExecution
    @JsonView(ScheduleView.All.class)
    @PostMapping
    public Schedule save(@RequestBody Schedule schedule,
                         @RequestHeader(value = "email", defaultValue = "") String email) {

        try {
            schedule = service.save(schedule);
            return schedule;
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @LogExecution
    @PostMapping("/many")
    public void saveMany(@RequestBody List<Schedule> schedules,
                         @RequestHeader(value = "email", defaultValue = "") String email) {
        try {
            service.save(schedules);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @LogExecution
    @JsonView(ScheduleView.All.class)
    @GetMapping("/{id}")
    public Schedule findOne(@PathVariable("id") int id) {
        return service.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email,
                       HttpServletRequest request) {
        service.deleteById(id);
    }

    @LogExecution
    @PutMapping("/{id}")
    public Schedule updateCustomer(@PathVariable int id, @RequestBody Schedule schedule,
                                   @RequestHeader(value = "email", defaultValue = "") String email) {
        schedule.setId(id);
        schedule = service.save(schedule);
        return schedule;
    }

}
