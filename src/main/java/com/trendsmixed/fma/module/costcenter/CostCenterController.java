package com.trendsmixed.fma.module.costcenter;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.CostCenter;
import com.trendsmixed.fma.entity.Section;
import com.trendsmixed.fma.module.costcenter.CostCenterView;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.module.section.SectionService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
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
    private CostCenterService costCenterService;
    @Autowired
    private SectionService sectionService;

    @GetMapping
    @JsonView(CostCenterView.AllAndSectionAll.class)
    public List<CostCenter> findAll() {
        return costCenterService.findAll();
    }

    @PostMapping
    @JsonView(CostCenterView.AllAndSectionId.class)
    public CostCenter save(@RequestBody CostCenter costCenter, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            costCenter = costCenterService.save(costCenter);
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
                CostCenter existingCostCenter = costCenterService.findByCode(costCenter.getCode());
                if (existingCostCenter != null) {
                    costCenter.setId(existingCostCenter.getId());
                }
                Section section = costCenter.getSection();
                if (section != null) {
                    section = sectionService.findByCode(section.getCode());
                    costCenter.setSection(section);
                }
            }
            costCenterService.save(costCenters);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public CostCenter findOne(@PathVariable("id") int id) {
        return costCenterService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        costCenterService.delete(id);

    }

    @PutMapping("/{id}")
    public CostCenter updateCustomer(@PathVariable int id, @RequestBody CostCenter costCenter) {
        costCenter.setId(id);
        costCenter = costCenterService.save(costCenter);
        return costCenter;
    }

}
