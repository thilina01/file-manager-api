package com.trendsmixed.fma.module.invoicedispatchnote;

import com.fasterxml.jackson.annotation.JsonView;
// import com.trendsmixed.fma.module.dispatchnote.DispatchNote;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author Thilina
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "invoice_dispatch_note")
public class InvoiceDispatchNote implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(InvoiceDispatchNoteView.Id.class)
    @Column(name = "id")
    private Integer id;
    // @JsonView(InvoiceDispatchNoteView.DispatchNote.class)
    // @OneToOne(optional = false, fetch = FetchType.LAZY)
    // @JoinColumn(name = "dispatch_note_id", referencedColumnName = "id")
    // private DispatchNote dispatchNote;
    // @JsonView(InvoiceDispatchNoteView.Invoice.class)
    // @JoinColumn(name = "invoice_id", referencedColumnName = "id")
    // @ManyToOne(optional = false)
    // private Invoice invoice;

}
