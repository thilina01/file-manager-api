package com.trendsmixed.fma.module.location;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Pageable;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/locations")
public class LocationController {

    private final AppSessionService appSessionService;
    private final LocationService service;

    @JsonView(LocationView.All.class)
    @GetMapping
    public Iterable< Location> findAll() {
        return service.findAll();
    }

    @JsonView(LocationView.All.class)
    @GetMapping("/page")
    Page< Location> page(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(LocationView.All.class)
    @PostMapping
    public Location save(@RequestBody Location location, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            location = service.save(location);
            return location;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List< Location> locations, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
        try {
            for (Location location : locations) {
                location.setCode(location.getCode().trim());
                location.setName(location.getName().trim());
                Location existingLocation = service.findByCode(location.getCode());
                if (existingLocation != null) {
                    location.setId(existingLocation.getId());
                }
            }
            service.save(locations);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(LocationView.All.class)
    @GetMapping("/{id}")
    public Location findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @PutMapping("/{id}")
    public Location updateCustomer(@PathVariable int id, @RequestBody Location location, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        location.setId(id);
        location = service.save(location);
        return location;
    }
}
