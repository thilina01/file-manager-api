package com.trendsmixed.fma.module.labourturnover;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/labourTurnovers")
public class LabourTurnoverController {

    
    private final LabourTurnoverService service;

    @JsonView(LabourTurnoverView.AllAndLabourSource.class)
    @GetMapping
    public Iterable<LabourTurnover> findAll() {
        return service.findAll();
    }

    @JsonView(LabourTurnoverView.AllAndLabourSource.class)
    @GetMapping("/page")
    Page<LabourTurnover> page(Pageable pageable) {
        return service.findAll(pageable);
    }

    @PostMapping
    @JsonView(LabourTurnoverView.AllAndLabourSource.class)
    public LabourTurnover save(@RequestBody LabourTurnover labourTurnover) {

        
        try {
            labourTurnover = service.save(labourTurnover);
            return labourTurnover;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<LabourTurnover> labourTurnovers) {

        
        try {
            service.save(labourTurnovers);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    @JsonView(LabourTurnoverView.AllAndLabourSource.class)
    public LabourTurnover findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        
        service.delete(id);

    }

    @PutMapping("/{id}")
    @JsonView(LabourTurnoverView.AllAndLabourSource.class)
    public LabourTurnover updateCustomer(@PathVariable int id, @RequestBody LabourTurnover labourTurnover) {
        
        labourTurnover.setId(id);
        labourTurnover = service.save(labourTurnover);
        return labourTurnover;
    }

}
