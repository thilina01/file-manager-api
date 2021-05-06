package com.trendsmixed.fma.module.controlpointtype;

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
@RequestMapping("/controlPointTypes")
public class ControlPointTypeController {

    private final ControlPointTypeService service;
    

    @JsonView(ControlPointTypeView.All.class)
    @PostMapping
    public ControlPointType save(@RequestBody ControlPointType controlPointType) {
        
        try {
            controlPointType = service.save(controlPointType);
            return controlPointType;
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<ControlPointType> controlPointTypes) {

        
        try {
            for (ControlPointType controlPointType : controlPointTypes) {
                controlPointType.setCode(controlPointType.getCode().trim());
                controlPointType.setName(controlPointType.getName().trim());
                ControlPointType existingControlPointType = service.findByCode(controlPointType.getCode());
                if (existingControlPointType != null) {
                    controlPointType.setId(existingControlPointType.getId());
                }
            }
            service.save(controlPointTypes);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping
    @JsonView(ControlPointTypeView.All.class)
    public Iterable<ControlPointType> findAll() {
        return service.findAll();
    }

    @GetMapping("/page")
    @JsonView(ControlPointTypeView.All.class)
    Page<ControlPointType> page(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @GetMapping("/{id}")
    @JsonView(ControlPointTypeView.All.class)
    public ControlPointType findOne(@PathVariable("id") int id) {
        return service.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        
        service.deleteById(id);

    }

    @PutMapping("/{id}")
    @JsonView(ControlPointTypeView.All.class)
    public ControlPointType updateCustomer(@PathVariable int id, @RequestBody ControlPointType controlPointType) {
        
        controlPointType.setId(id);
        controlPointType = service.save(controlPointType);
        return controlPointType;
    }
}
