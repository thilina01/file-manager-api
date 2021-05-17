package com.trendsmixed.fma.module.status;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/statuses")
public class StatusController {

    
    private final StatusService statusService;

    @JsonView(StatusView.All.class)
    @GetMapping
    public List<Status> findAll() {
        return statusService.findAll();
    }

    @PostMapping
    public Status save(@RequestBody Status status) {

        
        try {
            status = statusService.save(status);
            return status;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<Status> statuss) {

        
        try {
            for (Status status : statuss) {
                status.setName(status.getName().trim());
                Status existingStatus = statusService.findByName(status.getName());
                if (existingStatus != null) {
                    status.setId(existingStatus.getId());
                }
            }
            statusService.save(statuss);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Status findOne(@PathVariable("id") int id) {
        return statusService.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        
        statusService.deleteById(id);

    }

    @PutMapping("/{id}")
    public Status updateCustomer(@PathVariable int id, @RequestBody Status status) {
        
        status.setId(id);
        status = statusService.save(status);
        return status;
    }

}
