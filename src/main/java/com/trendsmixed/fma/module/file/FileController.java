package com.trendsmixed.fma.module.file;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trendsmixed.fma.entity.AppSession;
import com.trendsmixed.fma.dao.Download;
import com.trendsmixed.fma.module.folder.Folder;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import com.trendsmixed.fma.module.folder.FolderService;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
@RequestMapping("/files")
public class FileController {

    @Autowired
    private FileService fileService;
    @Autowired
    private FolderService folderService;
    @Autowired
    private AppSessionService appSessionService;

    @GetMapping//("/top")
    public List<File> all() {
        return fileService.findAll();
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") int id, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {
        AppSession appSession = appSessionService.findOne(email);
        if (appSession == null) {
            throw new Error("Unauthorized access");
        } else {
            deleteFile(id);
        }
    }

    @GetMapping(value = "/{id}/download")
    public Download download(@PathVariable("id") int id, HttpServletResponse response) {
        Download download = new Download();
        try {
            File file = fileService.findOne(id);

            int x = id / 100;
            java.io.File filePath = new java.io.File("files/" + x + "/" + id + file.getExtension());
            byte[] fileAsBytes = Files.readAllBytes(filePath.toPath());
            download.setName(file.getName());
            download.setExtension(file.getExtension());
            //download.setBytes(fileAsBytes);
            //System.out.println(fileAsBytes);
            //InputStream targetStream = new FileInputStream(filePath);
            // copy it to response's OutputStream

            //org.apache.commons.io.IOUtils.copy(targetStream, response.getOutputStream());
            response.setContentType("application/x-msdownload");
            response.setHeader("Content-disposition", "attachment; filename=\"" + file.getName() + file.getExtension() + "\"");
            ServletOutputStream outStream = response.getOutputStream();
            outStream.write(fileAsBytes);
            outStream.flush();
            outStream.close();/* */

            //response.flushBuffer();

        } catch (IOException ex) {
            Logger.getLogger(FileController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return download;
    }

    @PostMapping(value = "/upload")
    public File handleFileUpload(@RequestParam(value = "data") String data, @RequestParam(value = "file") MultipartFile multipartFile, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        AppSession appSession = appSessionService.findOne(email);
        if (appSession == null) {
            throw new Error("Unauthorized access");
        } else {
            int fileId = 0;
            try {
                ObjectMapper mapper = new ObjectMapper();
                File file = mapper.readValue(data, File.class);
                String originalFileName = multipartFile.getOriginalFilename();
                file.setOriginalFileName(originalFileName);
                String extension = originalFileName.substring(originalFileName.lastIndexOf('.'));
                //System.out.println(file.getName());
                //System.out.println("folder id: " + file.getFolders().get(0).getId());
                Folder folder = folderService.findOne(file.getFolderList().get(0).getId());
                //String name = System.currentTimeMillis() + extension;
                //System.out.println(name);
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
        }
        return null;
    }

    private void deleteFile(int id) {
        File file = fileService.findOne(id);
        List<Folder> folders = file.getFolderList();
        for (Folder folder : folders) {
            folder.getFileList().remove(file);
            folderService.save(folder);
        }
        fileService.delete(id);
    }
}
