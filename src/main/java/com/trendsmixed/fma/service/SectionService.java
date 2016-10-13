package com.trendsmixed.fma.service;

import com.trendsmixed.fma.entity.Section;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendsmixed.fma.repository.SectionRepository;

@Service
public class SectionService {

    @Autowired
    private SectionRepository sectionRepository;

    public List<Section> findAll() {
        return sectionRepository.findAll();
    }

    public Section save(Section section) {
        return sectionRepository.save(section);
    }

    public Section findOne(int id) {
        return sectionRepository.findOne(id);
    }

    public void delete(int id) {
        sectionRepository.delete(id);
    }
}
