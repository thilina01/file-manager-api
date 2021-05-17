package com.trendsmixed.fma.module.storage;

import com.trendsmixed.fma.module.fileinformation.FileInformation;
import com.trendsmixed.fma.module.fileinformation.FileInformationService;
import lombok.AllArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Date;

@AllArgsConstructor
@RestController
@RequestMapping("/files")
public class FileUploadController {

    private FileInformationService fileInformationService;
    private FileSystemStorageService fileSystemStorageService;

    @GetMapping(value = "/{id}")
    public HttpEntity<FileSystemResource> serveFile(@PathVariable("id") int id) throws IOException {
        FileInformation fileInformation = fileInformationService.findById(id);
        FileSystemResource fileSystemResource = new FileSystemResource(fileInformation.getPath());
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileInformation.getOriginalFileName());
        header.setContentLength(fileSystemResource.contentLength());

        return new HttpEntity<>(fileSystemResource, header);
    }

    @PostMapping
    public FileInformation handleFileUpload(@RequestParam("file") MultipartFile multipartFile) {

        Path destination = fileSystemStorageService.store(multipartFile);
        String originalFileName = multipartFile.getOriginalFilename();
        FileInformation fileInformation = new FileInformation();
        fileInformation.setOriginalFileName(originalFileName);
        fileInformation.setExtension(originalFileName.substring(originalFileName.lastIndexOf('.')));
        fileInformation.setPath(destination.toString());
        fileInformation.setUploadDate(new Date());

        return fileInformationService.save(fileInformation);

    }

}
