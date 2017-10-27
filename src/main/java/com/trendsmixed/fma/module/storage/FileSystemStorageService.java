package com.trendsmixed.fma.module.storage;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;

@Service
public class FileSystemStorageService {

    private final Path rootLocation = Paths.get("storage");

    public Path store(MultipartFile file) {
        String originalFileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (file.isEmpty()) {
                throw new StorageException("Failed to store empty file " + originalFileName);
            }
            if (originalFileName.contains("..")) {
                // This is a security check
                throw new StorageException(
                        "Cannot store file with relative path outside current directory "
                        + originalFileName);
            }
            Calendar calendar = Calendar.getInstance();
            Path folderToSaveIn = rootLocation.resolve(calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1) + File.separator);

            if (!rootLocation.toFile().exists()) {
                rootLocation.toFile().mkdir();
            }
            if (!folderToSaveIn.toFile().exists()) {
                folderToSaveIn.toFile().mkdir();
            }
            System.out.println("Saving: " + originalFileName);
            Path destination = folderToSaveIn.resolve(System.currentTimeMillis() + originalFileName.substring(originalFileName.lastIndexOf('.')));
            Files.copy(file.getInputStream(), destination);
            System.out.println("Saved as: " + destination);
            return destination;
        } catch (IOException e) {
            throw new StorageException("Failed to store file " + originalFileName, e);
        }
    }

//    public Stream<Path> loadAll() {
//        try {
//            return Files.walk(this.rootLocation, 1)
//                    .filter(path -> !path.equals(this.rootLocation))
//                    .map(path -> this.rootLocation.relativize(path));
//        } catch (IOException e) {
//            throw new StorageException("Failed to read stored files", e);
//        }
//
//    }
//
//    public Path load(String filename) {
//        return rootLocation.resolve(filename);
//    }
//
//    public Resource loadAsResource(String filename) {
//        try {
//            Path file = load(filename);
//            Resource resource = new UrlResource(file.toUri());
//            if (resource.exists() || resource.isReadable()) {
//                return resource;
//            } else {
//                throw new StorageFileNotFoundException(
//                        "Could not read file: " + filename);
//
//            }
//        } catch (MalformedURLException e) {
//            throw new StorageFileNotFoundException("Could not read file: " + filename, e);
//        }
//    }
//
//    public void deleteAll() {
//        FileSystemUtils.deleteRecursively(rootLocation.toFile());
//    }
//
//    public void init() {
//        try {
//            Files.createDirectories(rootLocation);
//        } catch (IOException e) {
//            throw new StorageException("Could not initialize storage", e);
//        }
//    }
}
