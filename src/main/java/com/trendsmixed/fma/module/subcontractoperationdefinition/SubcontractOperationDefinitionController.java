package com.trendsmixed.fma.module.subcontractoperationdefinition;

import java.text.ParseException;
import java.util.List;
import org.springframework.data.domain.Pageable;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.item.Item;
import com.trendsmixed.fma.module.operationtype.OperationType;
import com.trendsmixed.fma.module.producttype.ProductType;
import com.trendsmixed.fma.utility.Page;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/subcontractOperationDefinitions")
public class SubcontractOperationDefinitionController {

    private final SubcontractOperationDefinitionService service;

    @JsonView(SubcontractOperationDefinitionView.All.class)
    @GetMapping
    public Iterable<SubcontractOperationDefinition> findAll() {
        return service.findAll();
    }

    @JsonView(SubcontractOperationDefinitionView.AllAndItemAndOperationTypeAndProductType.class)
    @GetMapping("/page")
    Page<SubcontractOperationDefinition> page(Pageable pageable) {
        return new Page<>(service.findAll(pageable));
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<SubcontractOperationDefinition> subcontractOperationDefinitionList) {

        try {

            service.save(subcontractOperationDefinitionList);
        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping("/combo")
    List<Combo> combo() {
        return service.getCombo();
    }

    // @JsonView(SubcontractOperationDefinitionView.AllAndItemAndOperationTypeAndProductType.class)
    // @GetMapping(value = "/getByItemAndProductTypeAndOperationType")
    // public Iterable<SubcontractOperationDefinition> getItemAndProductTypeAndOperationType(
    //         @RequestParam(value = "item", required = false, defaultValue = "0") String item,
    //         @RequestParam(value = "productType", required = false, defaultValue = "0") String productType,
    //         @RequestParam(value = "operationType", required = false, defaultValue = "0") String operationType)
    //         throws ParseException {

    //     return service.findByOperationTypeAndItemAndProductType(new OperationType(Integer.valueOf(operationType)),
    //             new Item(Integer.valueOf(item)), new ProductType(Integer.valueOf(productType)));
    // }

    @JsonView(SubcontractOperationDefinitionView.AllAndItemAndOperationTypeAndProductType.class)
    @GetMapping(value = "/getsubcontractOperationDefinition")
        public Page<SubcontractOperationDefinition> getsubcontractOperationDefinition(
        @RequestParam(value = "item", required = false, defaultValue = "0")String item,
        @RequestParam(value = "productType", required = false, defaultValue = "0") String productType,   
        @RequestParam(value = "operationType", required = false, defaultValue = "0") String operationType,
            Pageable pageable) throws ParseException {
            Page<SubcontractOperationDefinition> page ;
            if(productType.equals("0")&& operationType.equals("0") ){
                page = new Page(service.findByItem(new Item(Integer.valueOf(item)), pageable));
            } 
            else if(productType.equals("0")&& item.equals("0") ){
                page = new Page(service.findByOperationType(new OperationType(Integer.valueOf(operationType)), pageable));
            }
            else if(operationType.equals("0")&& item.equals("0") ){
                page = new Page(service.findByProductType(new ProductType(Integer.valueOf(productType)), pageable));
            }
            else if(item.equals("0") ){
                page = new Page(service.findByOperationTypeAndProductType(new OperationType(Integer.valueOf(operationType)),new ProductType(Integer.valueOf(productType)), pageable));
            }
            else if(productType.equals("0") ){
                page = new Page(service.findByOperationTypeAndItem(new OperationType(Integer.valueOf(operationType)),new Item(Integer.valueOf(item)), pageable));
            }
            else if(operationType.equals("0") ){
                page = new Page(service.findByProductTypeAndItem(new ProductType(Integer.valueOf(productType)),new Item(Integer.valueOf(item)), pageable));
            }
            else {
                page = new Page(service.findByOperationTypeAndItemAndProductType(new OperationType(Integer.valueOf(operationType)),
                 new Item(Integer.valueOf(item)), new ProductType(Integer.valueOf(productType)), pageable));
            }
            return page;
        }

    @PostMapping
    public SubcontractOperationDefinition save(
            @RequestBody SubcontractOperationDefinition subcontractOperationDefinition) {
        try {
            subcontractOperationDefinition = service.save(subcontractOperationDefinition);
            return subcontractOperationDefinition;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(SubcontractOperationDefinitionView.AllAndItemAndOperationTypeAndProductType.class)
    @GetMapping("/{id}")
    public SubcontractOperationDefinition findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);

    }

    @PutMapping("/{id}")
    public SubcontractOperationDefinition updateCustomer(@PathVariable int id,
            @RequestBody SubcontractOperationDefinition subcontractOperationDefinition) {
        subcontractOperationDefinition.setId(id);
        subcontractOperationDefinition = service.save(subcontractOperationDefinition);
        return subcontractOperationDefinition;
    }
}
