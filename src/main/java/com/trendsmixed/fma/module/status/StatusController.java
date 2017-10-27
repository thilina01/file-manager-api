package com.trendsmixed.fma.module.status;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/statuses")
public class StatusController {

    private final AppSessionService appSessionService;
    private final StatusService statusService;

    @JsonView(StatusView.All.class)
    @GetMapping
    public List<Status> findAll() {
        return statusService.findAll();
    }

    @PostMapping
    public Status save(@RequestBody Status status, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
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
    public void saveMany(@RequestBody List<Status> statuss, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
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
        return statusService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        statusService.delete(id);

    }

    @PutMapping("/{id}")
    public Status updateCustomer(@PathVariable int id, @RequestBody Status status, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        status.setId(id);
        status = statusService.save(status);
        return status;
    }

}
