package com.trendsmixed.fma.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.jsonView.JobView;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Job {

    @Id
    @GeneratedValue
    private Integer id;

    @JsonView(JobView.JobNo.class)
    String jobNo;

    @JsonView(JobView.AcualShippedDate.class)
    Date actualShippedDate;

    @JsonView(JobView.ConfirmShippedDate.class)
    Date confirmShippedDate;

    @JsonView(JobView.JobQuantity.class)
    double jobQuantity;

    @JsonView(JobView.JobDate.class)
    Date jobDate;

    @JsonView(JobView.Comment.class)
    String comment;

}
