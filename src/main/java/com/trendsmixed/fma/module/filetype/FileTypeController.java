package com.trendsmixed.fma.module.filetype;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/fileTypes")
public class FileTypeController {

    
    private final FileTypeService fileTypeService;

    @GetMapping
    public List<FileType> findAll() {
        return fileTypeService.findAll();
    }

    @PostMapping
    public FileType save(@RequestBody FileType fileType) {
        
        try {
            fileType = fileTypeService.save(fileType);
            return fileType;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }

    }

    @GetMapping("/{id}")
    public FileType findOne(@PathVariable("id") int id) {
        return fileTypeService.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        fileTypeService.deleteById(id);

    }

    @PutMapping("/{id}")
    public FileType updateCustomer(@PathVariable int id, @RequestBody FileType fileType) {
        fileType.setId(id);
        fileType = fileTypeService.save(fileType);
        return fileType;
    }
}
