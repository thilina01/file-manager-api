package com.trendsmixed.fma.module.filetype;

import com.trendsmixed.fma.module.appsession.AppSessionService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/fileTypes")
public class FileTypeController {

    private final AppSessionService appSessionService;
    private final FileTypeService fileTypeService;

    @GetMapping
    public List<FileType> findAll() {
        return fileTypeService.findAll();
    }

    @PostMapping
    public FileType save(@RequestBody FileType fileType, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
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
        return fileTypeService.findOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        fileTypeService.delete(id);

    }

    @PutMapping("/{id}")
    public FileType updateCustomer(@PathVariable int id, @RequestBody FileType fileType) {
        fileType.setId(id);
        fileType = fileTypeService.save(fileType);
        return fileType;
    }
}
