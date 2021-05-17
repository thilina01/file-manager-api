package com.trendsmixed.fma.module.menutype;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/menuTypes")
public class MenuTypeController {

    private AppSessionService appSessionService;
    private MenuTypeService service;

    @JsonView(MenuTypeView.All.class)
    @GetMapping
    public Iterable<MenuType> findAll() {
        return service.findAll();
    }

    @JsonView(MenuTypeView.All.class)
    @GetMapping("/page")
    Page<MenuType> page(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @PostMapping
    public MenuType save(@RequestBody MenuType menuType,
            @RequestHeader(value = "email", defaultValue = "") String email) {
        
        try {
            menuType = service.save(menuType);
            return menuType;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<MenuType> menuTypes,
            @RequestHeader(value = "email", defaultValue = "") String email) {
        
        try {

            service.save(menuTypes);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(MenuTypeView.All.class)
    @GetMapping("/{id}")
    public MenuType findOne(@PathVariable("id") int id) {
        return service.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email,
            HttpServletRequest request) {
        
        service.deleteById(id);

    }

    @PutMapping("/{id}")
    public MenuType updateCustomer(@PathVariable int id, @RequestBody MenuType menuType,
            @RequestHeader(value = "email", defaultValue = "") String email) {
        
        menuType.setId(id);
        menuType = service.save(menuType);
        return menuType;
    }
}
