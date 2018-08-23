package com.trendsmixed.fma.module.drawingchangerequest;

import com.trendsmixed.fma.dao.Combo;
import java.util.List;

import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;


@AllArgsConstructor
@Service
public class DrawingChangeRequestService {

    private DrawingChangeRequestRepository repository;

    public Iterable<DrawingChangeRequest> findAll() {
        return repository.findAll();
    }

    public Page<DrawingChangeRequest> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public DrawingChangeRequest save(DrawingChangeRequest drawingChangeRequest) {
        return repository.save(drawingChangeRequest);
    }

    public void save(List<DrawingChangeRequest> drawingChangeRequestList) {
        repository.save(drawingChangeRequestList);
    }

    public DrawingChangeRequest findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

}
