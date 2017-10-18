package com.trendsmixed.fma.module.operationtype;

import com.trendsmixed.fma.module.operation.Operation;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *
 * @author Thilina
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "operation_type")
@NamedQueries({
    @NamedQuery(name = "OperationType.findAll", query = "SELECT o FROM OperationType o")})
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

}
