package com.trendsmixed.fma.module.absenteeism;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/absenteeisms")
public class AbsenteeismController {

    
    private final AbsenteeismService service;

    @JsonView(AbsenteeismView.AllAndLabourSource.class)
    @GetMapping
    public Iterable<Absenteeism> findAll() {
        return service.findAll();
    }

    @JsonView(AbsenteeismView.AllAndLabourSource.class)
    @GetMapping("/page")
    Page<Absenteeism> page(Pageable pageable) {
        return service.findAll(pageable);
    }

    @PostMapping
    public Absenteeism save(@RequestBody Absenteeism absenteeism) {

        
        try {
            absenteeism = service.save(absenteeism);
            return absenteeism;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<Absenteeism> absenteeisms) {

        
        try {
            service.save(absenteeisms);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    @JsonView(AbsenteeismView.AllAndLabourSource.class)
    public Absenteeism findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        
        service.delete(id);

    }

    @PutMapping("/{id}")
    public Absenteeism updateCustomer(@PathVariable int id, @RequestBody Absenteeism absenteeism) {
        
        absenteeism.setId(id);
        absenteeism = service.save(absenteeism);
        return absenteeism;
    }

}
