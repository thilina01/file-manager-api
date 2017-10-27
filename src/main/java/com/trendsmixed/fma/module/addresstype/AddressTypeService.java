package com.trendsmixed.fma.module.addresstype;

import com.trendsmixed.fma.dao.Combo;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AddressTypeService {

    private AddressTypeRepository repository;

    public Iterable<AddressType> findAll() {
        return repository.findAll();
    }

    public Page<AddressType> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public AddressType save(AddressType addressType) {
        return repository.save(addressType);
    }

    public void save(List<AddressType> countries) {
        repository.save(countries);
    }

    public AddressType findOne(int id) {
        return repository.findOne(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public AddressType findByCode(String code) {
        return repository.findByCode(code);
    }

    public AddressType findByName(String name) {
        return repository.findByName(name);
    }
}
