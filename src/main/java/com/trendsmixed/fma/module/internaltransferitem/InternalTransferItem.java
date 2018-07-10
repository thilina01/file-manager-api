package com.trendsmixed.fma.module.internaltransferitem;

import com.trendsmixed.fma.module.internaltransfernote.InternalTransferNote;
import com.trendsmixed.fma.module.job.Job;
import com.trendsmixed.fma.module.producttype.ProductType;

import java.io.Serializable;

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
@Table(name = "internal_transfer_Item")
public class InternalTransferItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @JsonView(InternalTransferItemView.Id.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JsonView(InternalTransferItemView.Quantity.class)
    @Column(name = "quantity")
    private Integer quantity;
    @JsonView(InternalTransferItemView.InternalTransferNote.class)
    @JoinColumn(name = "internal_transfer_note_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private InternalTransferNote internalTransferNote;
    @JsonView(InternalTransferItemView.Job.class)
    @JoinColumn(name = "job_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Job job;
    @JsonView(InternalTransferItemView.ProductType.class)
    @JoinColumn(name = "product_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ProductType productType;
   
    @JsonView(InternalTransferItemView.All.class)
    public String getDisplay() {
        return id + " : "; 
        
    }

}
