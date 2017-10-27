package com.trendsmixed.fma.module.producttype;

import com.trendsmixed.fma.module.operation.Operation;
import com.fasterxml.jackson.annotation.JsonView;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
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
@Table(name = "product_type")
public class ProductType implements Serializable {

    private static final long serialVersionUID = 1L;
    @JsonView(ProductTypeView.Id.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JsonView(ProductTypeView.Code.class)
    @Column(name = "code", unique = true)
    private String code;
    @JsonView(ProductTypeView.Description.class)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "productType")
    private List<Operation> operationList;

}
