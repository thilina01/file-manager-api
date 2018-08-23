package com.trendsmixed.fma.module.subcontractoroperation;

import com.trendsmixed.fma.module.subcontractoperationdefinition.SubcontractOperationDefinition;
import com.trendsmixed.fma.module.subcontractoperationrate.SubcontractOperationRate;
import com.trendsmixed.fma.module.subcontractor.Subcontractor;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.persistence.*;

/**
 *
 * @author Thilina
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "subcontractor_operation")
public class SubcontractorOperation implements Serializable {

    private static final long serialVersionUID = 1L;
	public static final String job = null;
    @JsonView(SubcontractorOperationView.Id.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JsonView(SubcontractorOperationView.Subcontractor.class)
    @JoinColumn(name = "subcontractor_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Subcontractor subcontractor;
    @JsonView(SubcontractorOperationView.SubcontractOperationDefinition.class)
    @JoinColumn(name = "subcontract_operation_definition_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SubcontractOperationDefinition subcontractOperationDefinition;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "subcontractorOperation")
    private List<SubcontractOperationRate> subcontractOperationRateList;

    public SubcontractorOperation(Integer id) {
        this.id = id;
    }

    @JsonView(SubcontractorOperationView.All.class)
    public String getDisplay() {
        return subcontractOperationDefinition.getItem().getCode()+"  :  "+subcontractOperationDefinition.getItem().getDescription()+"  |  "+subcontractOperationDefinition.getProductType().getCode()+"  :  "+subcontractOperationDefinition.getProductType().getDescription()+"  |  "+subcontractOperationDefinition.getOperationType().getCode()+"  :  "+subcontractOperationDefinition.getOperationType().getDescription();

    }

}
