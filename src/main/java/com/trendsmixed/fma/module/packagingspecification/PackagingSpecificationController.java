package com.trendsmixed.fma.module.packagingspecification;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.item.Item;
import com.trendsmixed.fma.module.palletsize.PalletSize;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import java.text.ParseException;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/packagingSpecifications")
public class PackagingSpecificationController {

    
    private final PackagingSpecificationService service;

    @JsonView(PackagingSpecificationView.AllAndPalletSizeAndItem.class)
    @GetMapping
    public Iterable<PackagingSpecification> findAll() {
        return service.findAll();
    } 

    @JsonView(PackagingSpecificationView.AllAndPalletSizeAndItem.class)
    @GetMapping("/page")
    Page<PackagingSpecification> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }
    
    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    @GetMapping("/comboByItem/{id}")
    List<Combo> comboByItem(@PathVariable("id") int id) {
        return service.getComboByItemId(id);
    }
    
    @JsonView(PackagingSpecificationView.AllAndPalletSizeAndItem.class)
    @GetMapping(value = "/palletSizeAndItemSearch")
    public Page<PackagingSpecification> getPalletSizeAndItemPage(
        @RequestParam(value = "palletSize", required = false, defaultValue = "0") String palletSize,
        @RequestParam(value = "item", required = false, defaultValue = "0") String item,
        Pageable pageable) throws ParseException {
        Page<PackagingSpecification> page ;

        if(item.equals("0")){
            page = new Page(service.findByPalletSize(new PalletSize(Integer.valueOf(palletSize)),pageable));
        }
        else if(palletSize.equals("0")){
            page = new Page(service.findByItem(new Item(Integer.valueOf(item)), pageable));
        }
        else{
            page = new Page(service.findByItemAndPalletSize( new Item(Integer.valueOf(item)),new PalletSize(Integer.valueOf(palletSize)), pageable));
        }
        return page;
    }

    @PostMapping
    public PackagingSpecification save(@RequestBody PackagingSpecification packagingSpecification) {
        
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
        return service.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        
        service.deleteById(id);

    }
    @JsonView(PackagingSpecificationView.AllAndPalletSizeAndItem.class)
    @PutMapping("/{id}")
    public PackagingSpecification updateCustomer(@PathVariable int id, @RequestBody PackagingSpecification packagingSpecification) {
        
        packagingSpecification.setId(id);
        packagingSpecification = service.save(packagingSpecification);
        return packagingSpecification;
    }
}
