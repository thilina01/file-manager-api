package com.trendsmixed.fma.module.invoicetype;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.invoice.Invoice;
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
@Table(name = "invoice_type")
@NamedQueries({
    @NamedQuery(name = "InvoiceType.findAll", query = "SELECT i FROM InvoiceType i")})
public class InvoiceType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(InvoiceTypeView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(InvoiceTypeView.Code.class)
    @Column(name = "code", unique = true)
    private String code;
    @JsonView(InvoiceTypeView.Name.class)
    @Column(name = "name")
    private String name;
    @JsonView(InvoiceTypeView.TaxRate.class)
    @Column(name = "taxRate")
    private Double taxRate;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "invoiceType")
    private List<Invoice> invoiceList;

    @JsonView(InvoiceTypeView.All.class)
    public String getDisplay() {
        return code + " : " + name;
    }
}
