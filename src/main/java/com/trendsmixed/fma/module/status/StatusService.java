package com.trendsmixed.fma.module.status;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StatusService {

    private StatusRepository statusRepository;

    public List<Status> findAll() {
        return statusRepository.findAll();
    }

    public Status save(Status status) {
        return statusRepository.save(status);
    }

    public List<Status> save(List<Status> statuses) {
        return statusRepository.saveAll(statuses);
    }

    public Status findById(int id) {
        return statusRepository.findById(id).get();
    }

    public void deleteById(int id) {
        statusRepository.deleteById(id);
    }

    public Status findByName(String name) {
        return statusRepository.findByName(name);

    }

}
