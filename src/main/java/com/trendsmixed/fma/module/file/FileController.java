package com.trendsmixed.fma.module.file;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trendsmixed.fma.dao.Download;
import com.trendsmixed.fma.module.folder.Folder;
import com.trendsmixed.fma.module.folder.FolderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/files")
public class FileController {

    private final FileService fileService;
    private final FolderService folderService;
    

    @GetMapping
    public List<File> all() {
        return fileService.findAll();
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") int id) {
        deleteFile(id);
    }

    @GetMapping(value = "/{id}/download")
    public Download download(@PathVariable("id") int id, HttpServletResponse response) {
        Download download = new Download();
        try {
            File file = fileService.findById(id);

            int x = id / 100;
            java.io.File filePath = new java.io.File("files/" + x + "/" + id + file.getExtension());
            byte[] fileAsBytes = Files.readAllBytes(filePath.toPath());
            download.setName(file.getName());
            download.setExtension(file.getExtension());

            response.setContentType("application/x-msdownload");
            response.setHeader("Content-disposition", "attachment; filename=\"" + file.getName() + file.getExtension() + "\"");
            ServletOutputStream outStream = response.getOutputStream();
            outStream.write(fileAsBytes);
            outStream.flush();
            outStream.close();

        } catch (IOException ex) {
            Logger.getLogger(FileController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return download;
    }

    @PostMapping(value = "/upload")
    public File handleFileUpload(@RequestParam(value = "data") String data, @RequestParam(value = "file") MultipartFile multipartFile) {


        int fileId = 0;
        try {
            ObjectMapper mapper = new ObjectMapper();
            File file = mapper.readValue(data, File.class);
            String originalFileName = multipartFile.getOriginalFilename();
            file.setOriginalFileName(originalFileName);
            String extension = originalFileName.substring(originalFileName.lastIndexOf('.'));
            Folder folder = folderService.findById(file.getFolderList().get(0).getId());

            file.setUploadDate(new Date());
            file.setExtension(extension);
            file = fileService.save(file);
            folder.getFileList().add(file);
            folderService.save(folder);
            fileId = file.getId();
            String name = file.getId() + extension;

            if (!multipartFile.isEmpty()) {
                try {
                    byte[] bytes = multipartFile.getBytes();
                    java.io.File folderToSaveTxt = new java.io.File("txt");
                    if (!folderToSaveTxt.exists()) {
                        folderToSaveTxt.mkdir();
                    }

                    String jsonString = mapper.writeValueAsString(file);
                    System.out.println(jsonString);
                    PrintWriter out = new PrintWriter("txt/" + file.getId() + ".txt");
                    out.println(jsonString);
                    out.close();

                    java.io.File MainolderToSaveIn = new java.io.File("files");
                    if (!MainolderToSaveIn.exists()) {
                        MainolderToSaveIn.mkdir();
                    }

                    int x = fileId / 100;
                    java.io.File subFolderToSaveIn = new java.io.File("files/" + x);
                    if (!subFolderToSaveIn.exists()) {
                        subFolderToSaveIn.mkdir();
                    }

                    BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new java.io.File("files/" + x + "/" + name)));
                    stream.write(bytes);
                    stream.close();
                    System.out.println("You successfully uploaded " + name + " into " + name + "-uploaded !");
                    return file;
                } catch (Exception e) {
                    System.out.println("You failed to upload " + name + " => " + e.getMessage());
                    deleteFile(fileId);
                }
            } else {
                System.out.println("You failed to upload " + name + " because the file was empty.");
            }
        } catch (IOException ex) {
            Logger.getLogger(FileController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private void deleteFile(int id) {
        File file = fileService.findById(id);
        List<Folder> folders = file.getFolderList();
        for (Folder folder : folders) {
            folder.getFileList().remove(file);
            folderService.save(folder);
        }
        fileService.deleteById(id);
    }
}
