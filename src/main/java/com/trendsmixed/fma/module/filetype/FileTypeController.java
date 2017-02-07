package com.trendsmixed.fma.module.filetype;

import com.trendsmixed.fma.entity.AppSession;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendsmixed.fma.entity.FileType;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@RestController
@CrossOrigin
@RequestMapping("/fileTypes")
public class FileTypeController {

    @Autowired
    private AppSessionService appSessionService;
    @Autowired
    private FileTypeService fileTypeService;

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
