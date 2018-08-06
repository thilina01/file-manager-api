package com.trendsmixed.fma.module.subcontractoperation;

import com.trendsmixed.fma.module.job.Job;
import com.trendsmixed.fma.module.subcontractarrival.SubcontractArrival;
import com.trendsmixed.fma.module.subcontractnote.SubcontractNote;
import com.trendsmixed.fma.module.subcontractoperationrate.SubcontractOperationRate;

import java.io.Serializable;
import java.util.List;

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
@Table(name = "subcontract_operation")
public class SubcontractOperation implements Serializable {

    private static final long serialVersionUID = 1L;
    @JsonView(SubcontractOperationView.Id.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JsonView(SubcontractOperationView.Quantity.class)
    @Column(name = "quantity")
    private Double quantity;
    @JsonView(SubcontractOperationView.SubcontractNote.class)
    @JoinColumn(name = "subcontract_note_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SubcontractNote subcontractNote;
    @JsonView(SubcontractOperationView.SubcontractOperationRate.class)
    @JoinColumn(name = "subcontract_operation_rate_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SubcontractOperationRate subcontractOperationRate;
    @JsonView(SubcontractOperationView.Job.class)
    @JoinColumn(name = "job_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Job job;
    @JsonView(SubcontractOperationView.SubcontractArrival.class)
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "subcontractOperation")
    private List<SubcontractArrival> subcontractArrivalList;

    public SubcontractOperation(Integer id) {
        this.id = id;
    }

    @JsonView(SubcontractOperationView.All.class)
    public String getDisplay() {
        return id + " : "; 
        
    }

}
