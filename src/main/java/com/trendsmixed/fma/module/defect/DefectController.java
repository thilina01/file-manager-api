package com.trendsmixed.fma.module.defect;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;

import com.trendsmixed.fma.module.section.Section;
import com.trendsmixed.fma.utility.Format;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/defects")
public class DefectController {

    
    private final DefectService service;

    @JsonView(DefectView.All.class)
    @GetMapping
    public Iterable<Defect> findAll() {
        return service.findAll();
    }

    @JsonView(DefectView.AllAndItemTypeAllAndLossReasonAllAndOperationTypeAllAndSectionAllAndJobAll.class)
    @GetMapping("/page")
    Page<Defect> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @JsonView(DefectView.All.class)
    @PostMapping
    public Defect save(@RequestBody Defect defect, @RequestHeader(value = "email", defaultValue = "") String email,
            HttpServletRequest request) {
        
        try {
            defect = service.save(defect);
            return defect;
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(DefectView.AllAndItemTypeAllAndLossReasonAllAndOperationTypeAllAndSectionAllAndJobAll.class)
    @GetMapping(value = "/sectionAndDefectDateBetween")
    public Page<Defect> getSectionAndDefectDateBetweenPage(
        @RequestParam(value = "section", required = false, defaultValue = "0") String section,
        @RequestParam(value = "startDate", required = false, defaultValue = "1970-01-01") String startDate,
        @RequestParam(value = "endDate", required = false, defaultValue = "2100-12-31") String endDate, 
        Pageable pageable) throws ParseException {
        Page<Defect> page ;

        if(section.equals("0") ){
            page = new Page(service.findByDefectDateBetween(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));    
        } 

        else{
            page = new Page(service.findBySectionAndDefectDateBetween(new Section(Integer.valueOf(section)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
        }
        return page;
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<Defect> defects,
            @RequestHeader(value = "email", defaultValue = "") String email) {

        
        try {
            service.save(defects);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(DefectView.AllAndItemTypeAllAndLossReasonAllAndOperationTypeAllAndSectionAllAndJobAll.class)
    @GetMapping("/{id}")
    public Defect findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email,
            HttpServletRequest request) {
        
        service.delete(id);

    }

    @JsonView(DefectView.All.class)
    @PutMapping("/{id}")
    public Defect updateCustomer(@PathVariable int id, @RequestBody Defect defect,
            @RequestHeader(value = "email", defaultValue = "") String email) {
        
        defect.setId(id);
        defect = service.save(defect);
        return defect;
    }
}
