package com.trendsmixed.fma.module.costcenter;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.module.section.Section;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.module.section.SectionService;
import com.trendsmixed.fma.utility.Page;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@RestController
@CrossOrigin
@RequestMapping("/costCenters")
public class CostCenterController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private CostCenterService service;
    @Autowired
    private SectionService sectionService;

    @GetMapping
    @JsonView(CostCenterView.AllAndSectionAll.class)
    public Iterable<CostCenter> findAll() {
        return service.findAll();
    }

    @JsonView(CostCenterView.All.class)
    @GetMapping("/page")
    Page<CostCenter> page(Pageable pageable) {
        return new Page<CostCenter>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @PostMapping
    @JsonView(CostCenterView.AllAndSectionId.class)
    public CostCenter save(@RequestBody CostCenter costCenter, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            costCenter = service.save(costCenter);
            return costCenter;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<CostCenter> costCenters, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
        try {
            for (CostCenter costCenter : costCenters) {
                costCenter.setCode(costCenter.getCode().trim());
                costCenter.setName(costCenter.getName().trim());
                CostCenter existingCostCenter = service.findByCode(costCenter.getCode());
                if (existingCostCenter != null) {
                    costCenter.setId(existingCostCenter.getId());
                }
                Section section = costCenter.getSection();
                if (section != null) {
                    section = sectionService.findByCode(section.getCode());
                    costCenter.setSection(section);
                }
            }
            service.save(costCenters);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(CostCenterView.AllAndSectionAll.class)
    @GetMapping("/{id}")
    public CostCenter findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);

    }

    @JsonView(CostCenterView.All.class)
    @PutMapping("/{id}")
    public CostCenter updateCustomer(@PathVariable int id, @RequestBody CostCenter costCenter) {
        costCenter.setId(id);
        costCenter = service.save(costCenter);
        return costCenter;
    }

}
