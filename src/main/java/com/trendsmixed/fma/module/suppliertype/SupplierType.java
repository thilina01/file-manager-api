package com.trendsmixed.fma.module.suppliertype;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.supplier.Supplier;
import java.io.Serializable;
import java.util.List;
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
@Table(name = "supplier_type")
public class SupplierType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(SupplierTypeView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(SupplierTypeView.Code.class)
    @Column(name = "code", unique = true)
    private String code;
    @JsonView(SupplierTypeView.Name.class)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "supplierType")
    private List<Supplier> supplierList;

}
