package com.trendsmixed.fma.module.invoice;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.customer.Customer;
import com.trendsmixed.fma.module.invoicedispatchnote.InvoiceDispatchNote;
import com.trendsmixed.fma.module.invoicetype.InvoiceType;
import com.trendsmixed.fma.module.packinglist.PackingList;
import java.io.Serializable;
import java.util.Date;
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
@Table(name = "invoice")
public class Invoice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(InvoiceView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(InvoiceView.InvoiceDate.class)
    @Column(name = "invoice_date")
    @Temporal(TemporalType.DATE)
    private Date invoiceDate;
    @JsonView(InvoiceView.InvoiceNumber.class)
    @Column(name = "invoice_number")
    private String invoiceNumber;
    @JsonView(InvoiceView.InvoiceType.class)
    @JoinColumn(name = "invoice_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private InvoiceType invoiceType;
    @JsonView(InvoiceView.Customer.class)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Customer customer;
    @JsonView(InvoiceView.InvoiceDispatchNote.class)
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "invoice")
    private List<InvoiceDispatchNote> invoiceDispatchNoteList;
    @JoinColumn(name = "packing_list_id", referencedColumnName = "id")
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, optional = true)
    private PackingList packingList;

    public Invoice(Integer id) {
        this.id = id;
    }

}
