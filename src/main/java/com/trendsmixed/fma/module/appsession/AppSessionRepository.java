package com.trendsmixed.fma.module.appsession;

import com.trendsmixed.fma.entity.AppSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface AppSessionRepository extends JpaRepository<AppSession, String> {

    AppSession findFirstByLoginTimeMills(long loginTimeMills);

    @Transactional
    long deleteByLoginTimeMills(long loginTimeMills);

}
