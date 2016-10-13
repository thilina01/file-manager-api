package com.trendsmixed.fma.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.jsonView.SectionView;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Section {

    @Id
    @GeneratedValue
    private Integer id;

    @JsonView(SectionView.Code.class)
    String code;

    @JsonView(SectionView.Name.class)
    String name;

}
