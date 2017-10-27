package com.trendsmixed.fma.module.controlpointtype;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/controlPointTypes")
public class ControlPointTypeController {

    private final ControlPointTypeService service;
    private final AppSessionService appSessionService;

    @JsonView(ControlPointTypeView.All.class)
    @PostMapping
    public ControlPointType save(@RequestBody ControlPointType controlPointType, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
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
    public void saveMany(@RequestBody List<ControlPointType> controlPointTypes, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
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
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @PutMapping("/{id}")
    @JsonView(ControlPointTypeView.All.class)
    public ControlPointType updateCustomer(@PathVariable int id, @RequestBody ControlPointType controlPointType, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        controlPointType.setId(id);
        controlPointType = service.save(controlPointType);
        return controlPointType;
    }
}
