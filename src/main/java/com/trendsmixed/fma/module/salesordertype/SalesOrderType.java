package com.trendsmixed.fma.module.salesordertype;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.salesorder.SalesOrder;
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
@Table(name = "sales_order_type")
public class SalesOrderType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(SalesOrderTypeView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(SalesOrderTypeView.Code.class)
    @Column(name = "code")
    private String code;
    @JsonView(SalesOrderTypeView.Name.class)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "salesOrderType")
    private List<SalesOrder> salesOrderList;

    public SalesOrderType(Integer id) {
        this.id = id;
    }

    @JsonView(SalesOrderTypeView.All.class)
    public String getDisplay() {
        return code + " : " + name;
    }
}
