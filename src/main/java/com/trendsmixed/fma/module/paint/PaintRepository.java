package com.trendsmixed.fma.module.paint;

import com.trendsmixed.fma.entity.Paint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaintRepository extends JpaRepository<Paint, Integer> {

    public Paint findByCode(String code);

    public Paint findByDescription(String description);

}
