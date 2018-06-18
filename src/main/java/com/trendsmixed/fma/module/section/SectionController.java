package com.trendsmixed.fma.module.section;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/sections")
public class SectionController {

    private final SectionService service;
    

    @GetMapping
    @JsonView(SectionView.All.class)
    public Iterable<Section> findAll() {
        return service.findAll();
    }

    @JsonView(SectionView.All.class)
    @GetMapping("/page")
    Page<Section> page(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @PostMapping
    public Section save(@RequestBody Section section) {
        
        try {
            section = service.save(section);
            return section;
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<Section> sections) {

        
        try {
            for (Section section : sections) {
                section.setCode(section.getCode().trim());
                section.setName(section.getName().trim());
                Section existingSection = service.findByCode(section.getCode());
                if (existingSection != null) {
                    section.setId(existingSection.getId());
                }
            }
            service.save(sections);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(SectionView.All.class)
    @GetMapping("/{id}")
    public Section findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        
        service.delete(id);
    }

    @PutMapping("/{id}")
    public Section updateSection(@PathVariable int id, @RequestBody Section section) {
        
        section.setId(id);
        section = service.save(section);
        return section;
    }

    @JsonView(SectionView.AllAndCostCenterAndWorkCenterAndControlPointProduction.class)
    @GetMapping("/test/{id}")
    public Section test(@PathVariable("id") int id,
                     @RequestParam(value = "productionDate") long productionDate) {
        return service.findByIdAndCostCenterListWorkCenterListControlPointListProductionListProductionDate(id, new Date(productionDate));
    }

}
