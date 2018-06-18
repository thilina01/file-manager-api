package com.trendsmixed.fma.module.losstype;

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
@RequestMapping("/lossTypes")
public class LossTypeController {

    
    private final LossTypeService service;

    @JsonView(LossTypeView.AllAndLossReasonList.class)
    @GetMapping
    public Iterable<LossType> findAll() {
        return service.findAll();
    }

    @JsonView(LossTypeView.All.class)
    @GetMapping("/page")
    Page<LossType> page(Pageable pageable) {
        return new Page<LossType>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @PostMapping
    public LossType save(@RequestBody LossType lossType) {
        
        try {
            lossType = service.save(lossType);
            return lossType;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(LossTypeView.All.class)
    @GetMapping("/{id}")
    public LossType findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        
        service.delete(id);

    }

    @JsonView(LossTypeView.All.class)
    @PutMapping("/{id}")
    public LossType updateCustomer(@PathVariable int id, @RequestBody LossType lossType) {
        
        lossType.setId(id);
        lossType = service.save(lossType);
        return lossType;
    }
}
