package com.trendsmixed.fma.module.packagingspecification;

import com.trendsmixed.fma.dao.Combo;
import com.trendsmixed.fma.module.item.Item;
import com.trendsmixed.fma.module.palletsize.PalletSize;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PackagingSpecificationService {

    private PackagingSpecificationRepository repository;

    public Iterable<PackagingSpecification> findAll() {
        return repository.findAll();
    }

    public Page<PackagingSpecification> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Combo> getCombo() {
        return repository.getCombo();
    }

    public List<Combo> getComboByItemId(int id) {
        return repository.getComboByItemId(id);
    }

    public PackagingSpecification save(PackagingSpecification packagingSpecification) {
        return repository.save(packagingSpecification);
    }

    public PackagingSpecification findById(int id) {
        return repository.findById(id).get();
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public Page<PackagingSpecification> findByItem(Item item,Pageable pageable) {
        return repository.findByItem(item,pageable);
    }

    public Page<PackagingSpecification> findByPalletSize(PalletSize palletSize,Pageable pageable) {
        return repository.findByPalletSize(palletSize,pageable);
    }

    public Page<PackagingSpecification> findByItemAndPalletSize(Item item,PalletSize palletSize,Pageable pageable) {
        return repository.findByItemAndPalletSize(item,palletSize,pageable);
    }

}
