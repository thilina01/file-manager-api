package com.trendsmixed.fma.dao;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.dao.view.LossReasonSectionCountView;
import com.trendsmixed.fma.module.section.Section;
import lombok.Data;

import java.util.Calendar;
import java.util.Date;

@Data
public class LossReasonSectionCount {

    @JsonView(LossReasonSectionCountView.Section.class)
    Section section;
    @JsonView(LossReasonSectionCountView.Count.class)
    private long count;

    public LossReasonSectionCount(Section section, Long count) {
        this.section = section;
        this.count = count != null ? count : 0;
    }

}
