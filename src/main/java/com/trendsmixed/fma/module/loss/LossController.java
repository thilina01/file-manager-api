package com.trendsmixed.fma.module.loss;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/losses")
public class LossController {

    private final AppSessionService appSessionService;
    private final LossService lossService;

    @JsonView(LossView.All.class)
    @GetMapping
    public List<Loss> findAll() {
        return lossService.findAll();
    }

    @JsonView(LossView.All.class)
    @PostMapping
    public Loss save(@RequestBody Loss loss, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            loss = lossService.save(loss);
            return loss;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<Loss> losses, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        appSessionService.isValid(email, request);
        try {
            lossService.save(losses);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Loss findOne(@PathVariable("id") int id) {
        return lossService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        lossService.delete(id);

    }

    @PutMapping("/{id}")
    public Loss updateCustomer(@PathVariable int id, @RequestBody Loss loss, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        loss.setId(id);
        loss = lossService.save(loss);
        return loss;
    }
}
