package com.trendsmixed.fma.module.file;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class FileService {

    private FileRepository fileRepository;

    public List<File> findAll() {
        return fileRepository.findAll();
    }

    public File save(File file) {
        return fileRepository.save(file);
    }

    public File findById(int id) {
        return fileRepository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        fileRepository.deleteById(id);
    }
}
