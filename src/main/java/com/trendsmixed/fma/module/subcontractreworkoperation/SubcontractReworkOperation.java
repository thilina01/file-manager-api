package com.trendsmixed.fma.module.subcontractreworkoperation;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.subcontractarrivalreject.SubcontractArrivalReject;
import com.trendsmixed.fma.module.subcontractreworknote.SubcontractReworkNote;

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
@Table(name = "subcontract_rework_operation")
public class SubcontractReworkOperation implements Serializable {

    private static final long serialVersionUID = 1L;
    @JsonView(SubcontractReworkOperationView.Id.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JsonView(SubcontractReworkOperationView.Quantity.class)
    @Column(name = "quantity")
    private Integer quantity;
    @JsonView(SubcontractReworkOperationView.SubcontractReworkNote.class)
    @JoinColumn(name = "subcontract_rework_note_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SubcontractReworkNote subcontractReworkNote;
    @JsonView(SubcontractReworkOperationView.SubcontractArrivalReject.class)
    @JoinColumn(name = "subcontract_arrival_reject_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SubcontractArrivalReject subcontractArrivalReject;
   
    public SubcontractReworkOperation(Integer id) {
        this.id = id;
    }

    @JsonView(SubcontractReworkOperationView.All.class)
    public String getDisplay() {
        return id + " : "; 
        
    }

}
