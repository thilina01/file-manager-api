package com.trendsmixed.fma.module.operationtype;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.operation.Operation;
import com.trendsmixed.fma.module.subcontractoperationdefinition.SubcontractOperationDefinition;

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
@Table(name = "operation_type")
public class OperationType implements Serializable {

    private static final long serialVersionUID = 1L;
    @JsonView(OperationTypeView.Id.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JsonView(OperationTypeView.Code.class)
    @Column(name = "code", unique = true)
    private String code;
    @JsonView(OperationTypeView.Description.class)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "operationType")
    private List<Operation> operationList;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "operationType")
    private List<SubcontractOperationDefinition> subcontractOperationDefinition;

    public OperationType(int anId) {
        this.id = anId;
    }

    @JsonView(OperationTypeView.All.class)
    public String getDisplay() {
        return code + " : " + description;
    }
}
