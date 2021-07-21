package com.trendsmixed.fma.module.arbranch;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.log.LogExecution;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/arBranches")
public class ArBranchController {

    private final ArBranchService service;

    @LogExecution
    @JsonView(ArBranchView.All.class)
    @PostMapping
    public ArBranch save(@RequestBody ArBranch arBranch) {

        try {
            arBranch = service.save(arBranch);
            return arBranch;
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @LogExecution
    @GetMapping
    @JsonView(ArBranchView.All.class)
    public Iterable<ArBranch> findAll() {
        return service.findAll();
    }

    @LogExecution
    @JsonView(ArBranchView.All.class)
    @GetMapping("/{id}")
    public ArBranch findOne(@PathVariable("id") int id) {
        return service.findById(id);
    }

    @LogExecution
    @JsonView(ArBranchView.All.class)
    @GetMapping("/page")
    Page<ArBranch> page(Pageable pageable) {
        return service.findAll(pageable);
    }

    @LogExecution
    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @LogExecution
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {

        service.deleteById(id);
    }

    @LogExecution
    @PutMapping("/{id}")
    public ArBranch update(@PathVariable int id, @RequestBody ArBranch arBranch) {

        arBranch.setId(id);
        arBranch = service.save(arBranch);
        return arBranch;
    }
}
