package com.trendsmixed.fma.module.filetype;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileTypeService {

    @Autowired
    private FileTypeRepository fileTypeRepository;

    public List<FileType> findAll() {
        return fileTypeRepository.findAll();
    }

    public FileType save(FileType fileType) {
        return fileTypeRepository.save(fileType);
    }

    public FileType findOne(int id) {
        return fileTypeRepository.findOne(id);
    }

    public void delete(int id) {
        fileTypeRepository.delete(id);
    }
}
