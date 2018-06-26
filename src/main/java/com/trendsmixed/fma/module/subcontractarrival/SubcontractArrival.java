package com.trendsmixed.fma.module.subcontractarrival;

import com.trendsmixed.fma.module.subcontractarrivalreject.SubcontractArrivalReject;
import com.trendsmixed.fma.module.subcontractoperation.SubcontractOperation;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import java.util.List;
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
@Table(name = "subcontract_arrival")
public class SubcontractArrival implements Serializable {

    private static final long serialVersionUID = 1L;
    @JsonView(SubcontractArrivalView.Id.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JsonView(SubcontractArrivalView.ArrivalTime.class)
    @Column(name = "arrival_time")
    private Date arrivalTime;
    @JsonView(SubcontractArrivalView.Quantity.class)
    @Column(name = "quantity")
    private Integer quantity;
    @JsonView(SubcontractArrivalView.SubcontractOperation.class)
    @JoinColumn(name = "subcontract_operation_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SubcontractOperation subcontractOperation;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "subcontractArrival")
    private List<SubcontractArrivalReject> subcontractArrivalRejectList;  
    @JsonView(SubcontractArrivalView.All.class)
    public String getDisplay() {
        return id + " : "; 
        
    }

}
