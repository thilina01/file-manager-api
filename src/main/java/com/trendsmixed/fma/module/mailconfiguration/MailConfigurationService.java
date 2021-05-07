package com.trendsmixed.fma.module.mailconfiguration;

import com.trendsmixed.fma.dao.Combo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void save(List<MailConfiguration> mailConfigurations) {
        repository.saveAll(mailConfigurations);
    }

    public MailConfiguration findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

}
