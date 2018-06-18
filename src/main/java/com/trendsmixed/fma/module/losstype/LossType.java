package com.trendsmixed.fma.module.losstype;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.lossreason.LossReason;
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
@Table(name = "loss_type")
public class LossType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(LossTypeView.Id.class)
    @Column(name = "id", nullable = false)
    private Integer id;
    @JsonView(LossTypeView.Code.class)
    @Column(name = "code", length = 45, unique = true)
    private String code;
    @JsonView(LossTypeView.Name.class)
    @Column(name = "name", length = 250)
    private String name;
    @JsonView(LossTypeView.TypeInSinhala.class)
    @Column(name = "type_in_sinhala", length = 250)
    private String typeInSinhala;
    @JsonView(LossTypeView.LossReasonList.class)
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "lossType")
    private List<LossReason> lossReasonList;

    public LossType(Integer id) {
        this.id = id;
    }

    @JsonView(LossTypeView.All.class)
    public String getDisplay() {
        return code + " : " + name;
    }
}
