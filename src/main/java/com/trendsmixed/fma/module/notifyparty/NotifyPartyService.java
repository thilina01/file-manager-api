package com.trendsmixed.fma.module.notifyparty;

import com.trendsmixed.fma.dao.Combo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class NotifyPartyService {

    @Autowired
    private NotifyPartyRepository repository;

    public Iterable<NotifyParty> findAll() {
        return repository.findAll();
    }

    public Page<NotifyParty> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public NotifyParty save(NotifyParty notifyParty) {
        return repository.save(notifyParty);
    }

    public NotifyParty findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public NotifyParty findByCode(String code) {
        return repository.findByCode(code);
    }

    public NotifyParty findByName(String name) {
        return repository.findByName(name);
    }
}
