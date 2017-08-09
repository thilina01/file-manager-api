/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trendsmixed.fma.module.lossreason;

import com.trendsmixed.fma.module.loss.Loss;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.losstype.LossType;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

/**
 *
 * @author Thilina
 */
@Entity
@Data
@EqualsAndHashCode(of = {"id"})
@Table(name = "loss_reason")
@NamedQueries({
    @NamedQuery(name = "LossReason.findAll", query = "SELECT l FROM LossReason l")})
public class LossReason implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(LossReasonView.Id.class)
    @Column(name = "id")
    @NonNull
    private Integer id;
    @JsonView(LossReasonView.Code.class)
    @Column(name = "code")
    private String code;
    @JsonView(LossReasonView.Name.class)
    @Column(name = "name")
    private String name;
    @JsonView(LossReasonView.ReasonInSinhala.class)
    @Column(name = "reason_in_sinhala")
    private String reasonInSinhala;
    @JsonView(LossReasonView.LossType.class)
    @JoinColumn(name = "loss_type_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private LossType lossType;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "lossReason")
    private List<Loss> lossList;

}
