package com.trendsmixed.fma.module.fileinformation;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class FileInformationService {

    private FileInformationRepository fileRepository;

    public List<FileInformation> findAll() {
        return fileRepository.findAll();
    }

    public FileInformation save(FileInformation file) {
        return fileRepository.save(file);
    }

    public FileInformation findOne(int id) {
        return fileRepository.findOne(id);
    }

    public void delete(int id) {
        fileRepository.delete(id);
    }
}
