package com.trendsmixed.fma.module.debitnote;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.debitnoteitem.DebitNoteItem;
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
@Table(name = "debit_note")
@NamedQueries({
    @NamedQuery(name = "DebitNote.findAll", query = "SELECT b FROM DebitNote b")})
public class DebitNote implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(DebitNoteView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(DebitNoteView.DateOfDebitNote.class)
    @Column(name = "date_of_debit_note")
    @Temporal(TemporalType.DATE)
    private Date dateOfDebitNote;
    @JsonView(DebitNoteView.DebitNoteNumber.class)
    @Column(name = "debit_note_number")
    private String debitNoteNumber;
    @JsonView(DebitNoteView.Invoice.class)
    @JoinColumn(name = "invoice_id", referencedColumnName = "id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Invoice invoice;
    @JsonView(DebitNoteView.InvoiceType.class)
    @JoinColumn(name = "invoice_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private InvoiceType invoiceType;
    @JsonView(DebitNoteView.DebitNoteItem.class)
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "debitNote")
    private List<DebitNoteItem> debitNoteItemList;
    
    public DebitNote(int anId) {
        this.id = anId;
    }

    @JsonView(DebitNoteView.All.class)
    public String getDisplay() {
        return id + " : " ;
    }
    
}
