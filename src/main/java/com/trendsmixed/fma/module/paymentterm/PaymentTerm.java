package com.trendsmixed.fma.module.paymentterm;

import com.trendsmixed.fma.module.customer.Customer;
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
@Table(name = "payment_term")
public class PaymentTerm implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(PaymentTermView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(PaymentTermView.Code.class)
    @Column(name = "code", unique = true)
    private String code;
    @JsonView(PaymentTermView.Name.class)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "paymentTerm")
    private List<Customer> customerList;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "paymentTerm")
    private List<Supplier> supplierList;

}
