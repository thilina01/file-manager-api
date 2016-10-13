package com.trendsmixed.fma.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.jsonView.DefectTypeView;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class DefectType {

    @Id
    @GeneratedValue
    private Integer id;

    @JsonView(DefectTypeView.Type.class)
    String type;

    @JsonView(DefectTypeView.Name.class)
    String name;

    @JsonView(DefectTypeView.NameInShinhala.class)
    String nameInShinhala;

}
