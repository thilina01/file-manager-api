package com.trendsmixed.fma.module.mailconfiguration;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.trendsmixed.fma.dao.Combo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;

@AllArgsConstructor
@Service
public class MailConfigurationService {

    private MailConfigurationRepository repository;

    public Iterable<MailConfiguration> findAll() {
        return repository.findAll();
    }

    public Page<MailConfiguration> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public MailConfiguration save(MailConfiguration mailConfiguration) {
        return repository.save(mailConfiguration);
    }

    public void save(List<MailConfiguration> items) {
        repository.save(items);
    }

    public MailConfiguration findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

}
