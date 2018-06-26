package com.trendsmixed.fma.module.scrap;

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
@RequestMapping("/scraps")
public class ScrapController {

    
    private final ScrapService service;

    @JsonView(ScrapView.All.class)
    @GetMapping
    public Iterable<Scrap> findAll() {
        return service.findAll();
    }

    @JsonView(ScrapView.AllAndItemTypeAllAndLossReasonAllAndOperationTypeAllAndSectionAllAndJobAll.class)
    @GetMapping("/page")
    Page<Scrap> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @JsonView(ScrapView.All.class)
    @PostMapping
    public Scrap save(@RequestBody Scrap scrap, @RequestHeader(value = "email", defaultValue = "") String email,
            HttpServletRequest request) {
        
        try {
            scrap = service.save(scrap);
            return scrap;
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(ScrapView.AllAndItemTypeAllAndLossReasonAllAndOperationTypeAllAndSectionAllAndJobAll.class)
    @GetMapping(value = "/sectionAndScrapDateBetween")
    public Page<Scrap> getSectionAndScrapDateBetweenPage(
        @RequestParam(value = "section", required = false, defaultValue = "0") String section,
        @RequestParam(value = "startDate", required = false, defaultValue = "1970-01-01") String startDate,
        @RequestParam(value = "endDate", required = false, defaultValue = "2100-12-31") String endDate, 
        Pageable pageable) throws ParseException {
        Page<Scrap> page ;

        if(section.equals("0") ){
            page = new Page(service.findByScrapDateBetween(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));    
        } 

        else{
            page = new Page(service.findBySectionAndScrapDateBetween(new Section(Integer.valueOf(section)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate), pageable));
        }
        return page;
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<Scrap> scraps,
            @RequestHeader(value = "email", defaultValue = "") String email) {

        
        try {
            service.save(scraps);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(ScrapView.AllAndItemTypeAllAndLossReasonAllAndOperationTypeAllAndSectionAllAndJobAll.class)
    @GetMapping("/{id}")
    public Scrap findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email,
            HttpServletRequest request) {
        
        service.delete(id);

    }

    @JsonView(ScrapView.All.class)
    @PutMapping("/{id}")
    public Scrap updateCustomer(@PathVariable int id, @RequestBody Scrap scrap,
            @RequestHeader(value = "email", defaultValue = "") String email) {
        
        scrap.setId(id);
        scrap = service.save(scrap);
        return scrap;
    }
}
