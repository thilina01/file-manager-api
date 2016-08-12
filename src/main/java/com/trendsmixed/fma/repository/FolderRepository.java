package com.trendsmixed.fma.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trendsmixed.fma.entity.Folder;

public interface FolderRepository extends JpaRepository<Folder, Integer> {

}
