package com.trendsmixed.fma.module.filetype;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class FileTypeService {

    private FileTypeRepository fileTypeRepository;

    public List<FileType> findAll() {
        return fileTypeRepository.findAll();
    }

    public FileType save(FileType fileType) {
        return fileTypeRepository.save(fileType);
    }

    public FileType findById(int id) {
        return fileTypeRepository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        fileTypeRepository.deleteById(id);
    }
}
