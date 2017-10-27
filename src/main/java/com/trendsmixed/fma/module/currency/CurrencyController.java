package com.trendsmixed.fma.module.currency;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.utility.Page;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/currencies")
public class CurrencyController {

    private final AppSessionService appSessionService;
    private final CurrencyService service;

    @JsonView(CurrencyView.All.class)
    @GetMapping
    public Iterable<Currency> findAll() {
        return service.findAll();
    }

    @JsonView(CurrencyView.All.class)
    @GetMapping("/page")
    Page<Currency> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @JsonView(CurrencyView.All.class)
    @PostMapping
    public Currency save(@RequestBody Currency currency, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            currency = service.save(currency);
            return currency;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(CurrencyView.All.class)
    @GetMapping("/{id}")
    public Currency findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @JsonView(CurrencyView.All.class)
    @PutMapping("/{id}")
    public Currency updateCustomer(@PathVariable int id, @RequestBody Currency currency, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        currency.setId(id);
        currency = service.save(currency);
        return currency;
    }
}
