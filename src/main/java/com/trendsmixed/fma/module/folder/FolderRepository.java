package com.trendsmixed.fma.module.folder;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FolderRepository extends JpaRepository<Folder, Integer> {

    public List<Folder> findByFolderIsNull();

}
