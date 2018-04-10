package com.trendsmixed.fma.module.packagingspecification;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Pageable;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.module.item.Item;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/packagingSpecifications")
public class PackagingSpecificationController {

    private final AppSessionService appSessionService;
    private final PackagingSpecificationService service;

    @JsonView(PackagingSpecificationView.AllAndPalletSizeAndItem.class)
    @GetMapping
    public Iterable<PackagingSpecification> findAll() {
        return service.findAll();
    } 

    @JsonView(PackagingSpecificationView.AllAndPalletSizeAndItem.class)
    @GetMapping("/page")
    Page<PackagingSpecification> page(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @GetMapping("/comboByItem/{id}")
    List<Combo> comboByItem(@PathVariable("id") int id) {
        return service.getComboByItemId(id);
    }

    @PostMapping
    public PackagingSpecification save(@RequestBody PackagingSpecification packagingSpecification, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            packagingSpecification = service.save(packagingSpecification);
            return packagingSpecification;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(PackagingSpecificationView.AllAndPalletSizeAndItem.class)
    @GetMapping("/{id}")
    public PackagingSpecification findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }
    @JsonView(PackagingSpecificationView.AllAndPalletSizeAndItem.class)
    @PutMapping("/{id}")
    public PackagingSpecification updateCustomer(@PathVariable int id, @RequestBody PackagingSpecification packagingSpecification, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        packagingSpecification.setId(id);
        packagingSpecification = service.save(packagingSpecification);
        return packagingSpecification;
    }
}
