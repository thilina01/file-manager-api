package com.trendsmixed.fma.module.status;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
        return statusRepository.save(statuses);
    }

    public Status findOne(int id) {
        return statusRepository.findOne(id);
    }

    public void delete(int id) {
        statusRepository.delete(id);
    }

    public Status findByName(String name) {
        return statusRepository.findByName(name);

    }

}
