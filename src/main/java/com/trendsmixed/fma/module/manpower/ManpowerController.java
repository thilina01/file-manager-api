package com.trendsmixed.fma.module.manpower;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import java.text.ParseException;

import com.trendsmixed.fma.module.controlpoint.ControlPoint;
import com.trendsmixed.fma.module.manpowertype.ManpowerType;
import com.trendsmixed.fma.module.shift.Shift;
import com.trendsmixed.fma.utility.Format;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/manpowers")
public class ManpowerController {

    
    private final ManpowerService service;

    @JsonView(ManpowerView.AllManpowerTypeAllProductionAll.class)
    @GetMapping
    public Iterable<Manpower> findAll() {
        return service.findAll();
    }

    @JsonView(ManpowerView.AllManpowerTypeAllProductionAll.class)
    @GetMapping("/page")
    Page<Manpower> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @JsonView(ManpowerView.AllManpowerTypeAllProductionAll.class)
    @GetMapping(value = "/controlPointAndShiftAndManpowerTypeAndProductionDateBetween")
    public Page<Manpower> getControlPointAndShiftAndManpowerTypeAndProductionDateBetweenPage(
        @RequestParam(value = "manpowerType", required = false, defaultValue = "0") String manpowerType,
        @RequestParam(value = "controlPoint", required = false, defaultValue = "0") String controlPoint,
        @RequestParam(value = "shift", required = false, defaultValue = "0") String shift,
        @RequestParam(value = "startDate", required = false, defaultValue = "1970-01-01") String startDate,
        @RequestParam(value = "endDate", required = false, defaultValue = "2100-12-31") String endDate, 
        Pageable pageable) throws ParseException {
        Page<Manpower> page;

        if(manpowerType.equals("0")&&controlPoint.equals("0")&&shift.equals("0")){
                    page = new Page(service.findByProductionProductionDateBetween(Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate),pageable));    
                }
        else if(controlPoint.equals("0")&&shift.equals("0")){
                    page = new Page(service.findByManpowerTypeAndProductionProductionDateBetween(new ManpowerType(Integer.valueOf(manpowerType)), Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate),pageable));
                }
        else if(manpowerType.equals("0")&&shift.equals("0")){
                    page = new Page(service.findByProductionControlPointAndProductionProductionDateBetween(new ControlPoint(Integer.valueOf(controlPoint)),Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate),pageable));
                }
        else if(manpowerType.equals("0")&&controlPoint.equals("0")){                   
                     page = new Page(service.findByProductionShiftAndProductionProductionDateBetween(new Shift(Integer.valueOf(shift)),Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate),pageable));
                }
        else if(manpowerType.equals("0")){                   
                    page = new Page(service.findByProductionControlPointAndProductionShiftAndProductionProductionDateBetween(new ControlPoint(Integer.valueOf(controlPoint)),new Shift(Integer.valueOf(shift)),Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate),pageable));
                }
        else if(controlPoint.equals("0")){                     
                   page = new Page(service.findByManpowerTypeAndProductionShiftAndProductionProductionDateBetween(new ManpowerType(Integer.valueOf(manpowerType)),new Shift(Integer.valueOf(shift)),Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate),pageable));
                }
        else if(shift.equals("0")){                     
                    page = new Page(service.findByManpowerTypeAndProductionControlPointAndProductionProductionDateBetween(new ManpowerType(Integer.valueOf(manpowerType)),new ControlPoint(Integer.valueOf(controlPoint)),Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate),pageable));
                }
        else    {                     
            page = new Page(service.findByManpowerTypeAndProductionControlPointAndProductionShiftAndProductionProductionDateBetween(new ManpowerType(Integer.valueOf(manpowerType)),new ControlPoint(Integer.valueOf(controlPoint)),new Shift(Integer.valueOf(shift)),Format.yyyy_MM_dd.parse(startDate), Format.yyyy_MM_dd.parse(endDate),pageable));
                }
                
        return page;
    }

    @JsonView(ManpowerView.All.class)
    @PostMapping
    public Manpower save(@RequestBody Manpower manpower) {
        
        try {
            manpower = service.save(manpower);
            return manpower;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<Manpower> manpowers) {

        
        try {
            service.save(manpowers);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Manpower findOne(@PathVariable("id") int id) {
        return service.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        
        service.deleteById(id);

    }

    @PutMapping("/{id}")
    public Manpower updateCustomer(@PathVariable int id, @RequestBody Manpower manpower) {
        
        manpower.setId(id);
        manpower = service.save(manpower);
        return manpower;
    }
}
