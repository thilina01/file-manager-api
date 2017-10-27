package com.trendsmixed.fma.module.filetype;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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

    public FileType findOne(int id) {
        return fileTypeRepository.findOne(id);
    }

    public void delete(int id) {
        fileTypeRepository.delete(id);
    }
}
