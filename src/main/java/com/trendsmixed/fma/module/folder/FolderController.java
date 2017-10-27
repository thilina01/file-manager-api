package com.trendsmixed.fma.module.folder;

import com.fasterxml.jackson.annotation.JsonView;
import java.util.List;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import javax.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/folders")
public class FolderController {

    private final FolderService folderService;
    private final AppSessionService appSessionService;

    @PostMapping
    public Folder save(@RequestBody Folder folder, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        appSessionService.isValid(email, request);
        try {
            folder = folderService.save(folder);
            return folder;

        } catch (Throwable e) {
            while (e.getCause() != null) {
                e = e.getCause();
            }
            throw new Error(e.getMessage());
        }
    }

    @GetMapping
    public @JsonView(FolderView.All.class)
    List<Folder> all() {
        return folderService.findAll();
    }

    @GetMapping("/top")
    public @JsonView(FolderView.All.class)
    List<Folder> top(@RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        return folderService.findByFolderIsNull();
    }

    @GetMapping("/{id}")
    public @JsonView(FolderView.All.class)
    Folder one(@PathVariable("id") int id) {
        return folderService.findOne(id);
    }

    @GetMapping("/{id}/with-parent")
    public @JsonView(FolderView.AllAndFolderAll.class)
    Folder oneWithParent(@PathVariable("id") int id) {
        return folderService.findOne(id);
    }

    @GetMapping("/{id}/with-sub-folders")
    public @JsonView(FolderView.AllAndFolderListAll.class)
    Folder oneWithSubFolders(@PathVariable("id") int id) {
        return folderService.findOne(id);
    }

    @GetMapping("/{id}/with-files")
    public @JsonView(FolderView.AllAndFileListAll.class)
    Folder oneWithFiles(@PathVariable("id") int id) {
        return folderService.findOne(id);
    }

    @GetMapping("/{id}/with-sub-folders-and-files")
    public @JsonView(FolderView.AllAndFolderListAllAndFileListAll.class)
    Folder oneWithSubFoldersAndFiles(@PathVariable("id") int id) {
        return folderService.findOne(id);
    }

    @GetMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id) {
        folderService.delete(id);
    }

}
