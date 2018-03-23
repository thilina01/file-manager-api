package com.trendsmixed.fma.module.loadingplanitem;

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
@RequestMapping("/loadingPlanItems")
public class LoadingPlanItemController {

    private final AppSessionService appSessionService;
    private final LoadingPlanItemService service;

    @JsonView(LoadingPlanItemView.All.class)
    @GetMapping
    public Iterable<LoadingPlanItem> findAll() {
        return service.findAll();
    }

    @JsonView(LoadingPlanItemView.All.class)
    @GetMapping("/page")
    Page<LoadingPlanItem> page(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @PostMapping
    public LoadingPlanItem save(@RequestBody LoadingPlanItem loadingPlanItem, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            loadingPlanItem = service.save(loadingPlanItem);
            return loadingPlanItem;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(LoadingPlanItemView.All.class)
    @GetMapping("/{id}")
    public LoadingPlanItem findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @PutMapping("/{id}")
    public LoadingPlanItem updateCustomer(@PathVariable int id, @RequestBody LoadingPlanItem loadingPlanItem, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        loadingPlanItem.setId(id);
        loadingPlanItem = service.save(loadingPlanItem);
        return loadingPlanItem;
    }
}
