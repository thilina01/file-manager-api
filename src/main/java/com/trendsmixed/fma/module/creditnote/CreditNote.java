package com.trendsmixed.fma.module.creditnote;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.creditnoteitem.CreditNoteItem;
import com.trendsmixed.fma.module.invoice.Invoice;
import com.trendsmixed.fma.module.invoicetype.InvoiceType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Thilina
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "credit_note")
@NamedQueries({
    @NamedQuery(name = "CreditNote.findAll", query = "SELECT b FROM CreditNote b")})
public class CreditNote implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(CreditNoteView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(CreditNoteView.DateOfCreditNote.class)
    @Column(name = "date_of_credit_note")
    @Temporal(TemporalType.DATE)
    private Date dateOfCreditNote;
    @JsonView(CreditNoteView.CreditNoteNumber.class)
    @Column(name = "credit_note_number")
    private String creditNoteNumber;
    @JsonView(CreditNoteView.Invoice.class)
    @JoinColumn(name = "invoice_id", referencedColumnName = "id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Invoice invoice;
    @JsonView(CreditNoteView.InvoiceType.class)
    @JoinColumn(name = "invoice_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private InvoiceType invoiceType;
    @JsonView(CreditNoteView.CreditNoteItem.class)
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "creditNote")
    private List<CreditNoteItem> creditNoteItemList;
    public CreditNote(int anId) {
        this.id = anId;
    }

    @JsonView(CreditNoteView.All.class)
    public String getDisplay() {
        return id + " : " ;
    }
    
}
