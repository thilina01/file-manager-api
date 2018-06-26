package com.trendsmixed.fma.module.subcontractoperationdefinition;

import com.trendsmixed.fma.module.item.Item;
import com.trendsmixed.fma.module.operationtype.OperationType;
import com.trendsmixed.fma.module.producttype.ProductType;
import com.trendsmixed.fma.module.subcontractoperation.SubcontractOperation;
import com.trendsmixed.fma.module.subcontractoperationrate.SubcontractOperationRate;
import com.trendsmixed.fma.module.subcontractoroperation.SubcontractorOperation;

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
@Table(name = "subcontract_operation_definition")
public class SubcontractOperationDefinition implements Serializable {

    private static final long serialVersionUID = 1L;
    @JsonView(SubcontractOperationDefinitionView.Id.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JsonView(SubcontractOperationDefinitionView.Description.class)
    @Column(name = "description")
    private String description;
    @JsonView(SubcontractOperationDefinitionView.Item.class)
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Item item;
    @JsonView(SubcontractOperationDefinitionView.OperationType.class)
    @JoinColumn(name = "operation_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OperationType operationType;
    @JsonView(SubcontractOperationDefinitionView.ProductType.class)
    @JoinColumn(name = "product_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ProductType productType;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "subcontractOperationDefinition")
    private List<SubcontractorOperation> subcontractorOperationList;
    
    public SubcontractOperationDefinition(Integer id) {
        this.id = id;
    }

    @JsonView(SubcontractOperationDefinitionView.All.class)
    public String getDisplay() {
        return item.getDisplay()+"  |  "+productType.getDisplay()+"  |  "+operationType.getDisplay() ;
        
    }

}
