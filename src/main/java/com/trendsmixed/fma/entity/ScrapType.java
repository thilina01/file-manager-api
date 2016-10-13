package com.trendsmixed.fma.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.jsonView.ScrapTypeView;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class ScrapType {

    @Id
    @GeneratedValue
    private Integer id;

    @JsonView(ScrapTypeView.Code.class)
    String code;

    @JsonView(ScrapTypeView.Type.class)
    String type;

    @JsonView(ScrapTypeView.TypeInShinhala.class)
    String typeInShinhala;

}
