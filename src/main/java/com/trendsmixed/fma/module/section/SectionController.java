package com.trendsmixed.fma.module.section;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.production.ProductionView;
import com.trendsmixed.fma.utility.Page;
import com.trendsmixed.fma.module.appsession.AppSessionService;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/sections")
public class SectionController {

    private final SectionService service;
    private final AppSessionService appSessionService;

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
    public Section save(@RequestBody Section section, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
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
    public void saveMany(@RequestBody List<Section> sections, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
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
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);
    }

    @PutMapping("/{id}")
    public Section updateSection(@PathVariable int id, @RequestBody Section section, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
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
