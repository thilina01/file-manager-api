package com.trendsmixed.fma.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.jsonView.LossReasonView;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class LossReason {

    @Id
    @GeneratedValue
    private Integer id;

    @JsonView(LossReasonView.Code.class)
    String code;

    @JsonView(LossReasonView.Type.class)
    String type;

    @JsonView(LossReasonView.TypeInShinhala.class)
    String typeInShinhala;

}
