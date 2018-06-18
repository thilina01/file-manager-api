package com.trendsmixed.fma.module.leavetype;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/leaveTypes")
public class LeaveTypeController {

    
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
    public LeaveType save(@RequestBody LeaveType leaveType) {
        
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
    public void delete(@PathVariable int id) {
        
        service.delete(id);

    }

    @JsonView(LeaveTypeView.All.class)
    @PutMapping("/{id}")
    public LeaveType updateCustomer(@PathVariable int id, @RequestBody LeaveType leaveType) {
        
        leaveType.setId(id);
        leaveType = service.save(leaveType);
        return leaveType;
    }
}
