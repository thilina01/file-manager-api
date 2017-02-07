package com.trendsmixed.fma.module.folder;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trendsmixed.fma.entity.Folder;
import java.util.List;

public interface FolderRepository extends JpaRepository<Folder, Integer> {

    public List<Folder> findByFolderIsNull();

}
