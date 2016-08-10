package com.trwlanka.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trwlanka.entity.Folder;

public interface FolderRepository extends JpaRepository<Folder, Integer> {

}
