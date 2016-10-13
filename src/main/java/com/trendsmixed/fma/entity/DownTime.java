package com.trendsmixed.fma.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.jsonView.DownTimeView;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class DownTime {

    @Id
    @GeneratedValue
    private Integer id;

    @JsonView(DownTimeView.DownTimeDate.class)
    Date downTimeDate;

    @JsonView(DownTimeView.Duretion.class)
    int duretion;

    @JsonView(DownTimeView.Reason.class)
    String reason;

}
