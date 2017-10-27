package com.trendsmixed.fma.module.leavetype;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.utility.Page;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/leaveTypes")
public class LeaveTypeController {

    private final AppSessionService appSessionService;
    private final LeaveTypeService service;

    @JsonView(LeaveTypeView.All.class)
    @GetMapping
    public Iterable<LeaveType> findAll() {
        return service.findAll();
    }

    @JsonView(LeaveTypeView.All.class)
    @GetMapping("/page")
    Page<LeaveType> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @PostMapping
    public LeaveType save(@RequestBody LeaveType leaveType, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            leaveType = service.save(leaveType);
            return leaveType;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(LeaveTypeView.All.class)
    @GetMapping("/{id}")
    public LeaveType findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @JsonView(LeaveTypeView.All.class)
    @PutMapping("/{id}")
    public LeaveType updateCustomer(@PathVariable int id, @RequestBody LeaveType leaveType, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        leaveType.setId(id);
        leaveType = service.save(leaveType);
        return leaveType;
    }
}
