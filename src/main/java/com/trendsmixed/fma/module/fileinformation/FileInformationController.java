package com.trendsmixed.fma.module.fileinformation;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trendsmixed.fma.entity.AppSession;
import com.trendsmixed.fma.module.appsession.AppSessionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/fileInformations")
public class FileInformationController {

    private final FileInformationService fileInformationService;
    private final AppSessionService appSessionService;

    @GetMapping
    public List<FileInformation> all() {
        return fileInformationService.findAll();
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

//    @GetMapping(value = "/{id}/download")
//    public Download download(@PathVariable("id") int id, HttpServletResponse response) {
//        Download download = new Download();
//        try {
//            FileInformation fileInformation = fileInformationService.findOne(id);
//
//            int x = id / 100;
//            java.io.File filePath = new java.io.File("files/" + x + "/" + id + fileInformation.getExtension());
//            byte[] fileAsBytes = Files.readAllBytes(filePath.toPath());
//            download.setName(fileInformation.getName());
//            download.setExtension(fileInformation.getExtension());
//
//            response.setContentType("application/x-msdownload");
//            response.setHeader("Content-disposition", "attachment; filename=\"" + fileInformation.getName() + fileInformation.getExtension() + "\"");
//            ServletOutputStream outStream = response.getOutputStream();
//            outStream.write(fileAsBytes);
//            outStream.flush();
//            outStream.close();
//
//        } catch (IOException ex) {
//            Logger.getLogger(FileInformation.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return download;
//    }
    @PostMapping(value = "/upload")
    public FileInformation handleFileUpload(@RequestParam(value = "data") String data, @RequestParam(value = "file") MultipartFile multipartFile, @RequestHeader(value = "email", defaultValue = "") String email, HttpServletRequest request) {

        AppSession appSession = appSessionService.findOne(email);
        if (appSession == null) {
            throw new Error("Unauthorized access");
        } else {
            int fileId = 0;
            try {
                ObjectMapper mapper = new ObjectMapper();
                FileInformation file = mapper.readValue(data, FileInformation.class);
                String originalFileName = multipartFile.getOriginalFilename();
                file.setOriginalFileName(originalFileName);
                String extension = originalFileName.substring(originalFileName.lastIndexOf('.'));
//                Folder folder = folderService.findOne(file.getFolderList().get(0).getId());

                file.setUploadDate(new Date());
                file.setExtension(extension);
                file = fileInformationService.save(file);
//                folder.getFileList().add(file);
//                folderService.save(folder);
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
                Logger.getLogger(FileInformationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    private void deleteFile(int id) {
//        FileInformation file = fileInformationService.findOne(id);
//        List<Folder> folders = file.getFolderList();
//        for (Folder folder : folders) {
//            folder.getFileList().remove(file);
//            folderService.save(folder);
//        }
        fileInformationService.delete(id);
    }
}
