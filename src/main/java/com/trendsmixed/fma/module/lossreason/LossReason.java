package com.trendsmixed.fma.module.lossreason;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.loss.Loss;
import com.trendsmixed.fma.module.losstype.LossType;
import com.trendsmixed.fma.module.subcontractarrivalreject.SubcontractArrivalReject;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Thilina
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "loss_reason")
public class LossReason implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(LossReasonView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(LossReasonView.Code.class)
    @Column(name = "code", unique = true)
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
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "lossReason")
    private List<SubcontractArrivalReject> subcontractArrivalRejectList;

    public LossReason(Integer id) {
        this.id = id;
    }

    @JsonView(LossReasonView.All.class)
    public String getDisplay() {
        return code + " : " + name;
    }
}
