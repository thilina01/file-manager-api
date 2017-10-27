package com.trendsmixed.fma.module.mailconfiguration;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Pageable;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.utility.MailService;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/mailConfigurations")
public class MailConfigurationController {

    private final AppSessionService appSessionService;
    private final MailConfigurationService service;
    private final MailService mailService;

    @JsonView(MailConfigurationView.All.class)
    @GetMapping
    public Iterable<MailConfiguration> findAll() {
        return service.findAll();
    }

    @JsonView(MailConfigurationView.All.class)
    @GetMapping("/page")
    Page<MailConfiguration> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(MailConfigurationView.All.class)
    @PostMapping
    public MailConfiguration save(@RequestBody MailConfiguration mailConfiguration,
            @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            mailConfiguration = service.save(mailConfiguration);
            return mailConfiguration;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<MailConfiguration> mailConfigurations,
            @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {

            service.save(mailConfigurations);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(MailConfigurationView.All.class)
    @GetMapping("/{id}")
    public MailConfiguration findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email,
            HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);
    }

    @JsonView(MailConfigurationView.All.class)
    @PutMapping("/{id}")
    public MailConfiguration updateCustomer(@PathVariable int id, @RequestBody MailConfiguration mailConfiguration,
            @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        mailConfiguration.setId(id);
        mailConfiguration = service.save(mailConfiguration);
        return mailConfiguration;
    }

    @GetMapping("/test")
    private void test() {
        mailService.send("r.thilina@gmail.com", "Test", "Mail configuration is okay.");
    }
}
