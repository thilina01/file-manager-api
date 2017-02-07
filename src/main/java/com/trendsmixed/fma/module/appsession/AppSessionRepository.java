package com.trendsmixed.fma.module.appsession;

import com.trendsmixed.fma.entity.AppSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppSessionRepository extends JpaRepository<AppSession, String> {

}
