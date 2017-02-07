package com.trendsmixed.fma.module.file;

import com.trendsmixed.fma.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Integer> {

}
