package com.trendsmixed.fma.module.item;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.entity.Item;
import com.trendsmixed.fma.entity.ItemType;
import com.trendsmixed.fma.entity.Paint;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.module.itemtype.ItemTypeService;
import com.trendsmixed.fma.module.paint.PaintService;
import com.trendsmixed.fma.utility.Page;

@RestController
@CrossOrigin
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private ItemService service;
    @Autowired
    private ItemTypeService itemTypeService;
    @Autowired
    private PaintService paintService;

    @JsonView(ItemView.AllAndItemTypeAllAndPaintAll.class)
    @GetMapping
    public Iterable<Item> findAll() {
        return service.findAll();
    }

    @JsonView(ItemView.AllAndItemTypeAllAndPaintAll.class)
    @GetMapping("/page")
	Page<Item> page( Pageable pageable){
    	return service.findAll(pageable);
	} 
    
    @GetMapping("/combo")
	List<Combo> combo(){
    	return service.getCombo();
	} 
	
    @JsonView(ItemView.AllAndItemTypeAllAndPaintAll.class)
    @PostMapping
    public Item save(@RequestBody Item item, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            item = service.save(item);
            return item;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @PostMapping("/many")
    public void saveMany(@RequestBody List<Item> items, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            //List<Item> itemsToRemove = new ArrayList<>();
            for (Item item : items) {
                String code = item.getCode();
                if (code == null) {
                    continue;
                }
                String description = item.getDescription();
                if (description == null) {
                    continue;
                }
                item.setCode(code.trim());
                item.setDescription(description.trim());
                Item existingItem = service.findByCode(code.trim());
                if (existingItem != null) {
                    //itemsToRemove.add(item);
                    item.setId(existingItem.getId());
                }

                ItemType itemType = item.getItemType();
                if (itemType != null) {
                    String type = itemType.getType().trim();
                    ItemType existingItemType = itemTypeService.findByType(type);
                    if (existingItemType == null) {
                        existingItemType = new ItemType();
                        existingItemType.setCode(type);
                        existingItemType.setType(type);
                        existingItemType = itemTypeService.save(itemType);
                    }
                    item.setItemType(existingItemType);
                }

                Paint paint = item.getPaint();
                if (paint != null) {
                    String paintCode = paint.getCode();
                    String paintDescription = paint.getDescription();
                    if (paintCode != null) {
                        paint = paintService.findByCode(paintCode);
                    } else if (paintDescription != null) {
                        paint = paintService.findByDescription(paintDescription);
                    }
                    if (paint == null) {
                        paint = paintService.findByCode("NA");
                        if (paint == null) {
                            paint = new Paint();
                            paint.setCode("NA");
                            paint = paintService.save(paint);
                        }
                        
                    }
                    item.setPaint(paint);
                }
            }
            /*System.out.println(items.size());
            System.out.println(itemsToRemove.size());
            for (Item item : itemsToRemove) {
                System.out.println(item.getCode());
                Predicate<Item> itemPredicate = i -> i.getCode() == item.getCode();
                items.removeIf(itemPredicate);
            }
            System.out.println(items.size());
            //items.removeAll(itemsToRemove);*/
            service.save(items);
        } catch (Throwable e) {
            e.printStackTrace();
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @JsonView(ItemView.AllAndItemTypeAllAndPaintAll.class)
    @GetMapping("/{id}")
    public Item findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        service.delete(id);

    }

    @PutMapping("/{id}")
    public Item updateCustomer(@PathVariable int id, @RequestBody Item item, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        item.setId(id);
        item = service.save(item);
        return item;
    }
}
