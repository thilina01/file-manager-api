package com.trendsmixed.fma.module.subcontractoperationrate;

import com.trendsmixed.fma.module.subcontractoperation.SubcontractOperation;
import com.trendsmixed.fma.module.subcontractoroperation.SubcontractorOperation;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "subcontract_operation_rate")
public class SubcontractOperationRate implements Serializable {

    private static final long serialVersionUID = 1L;
    @JsonView(SubcontractOperationRateView.Id.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JsonView(SubcontractOperationRateView.DateOfRate.class)
    @Column(name = "date_of_rate")
    @Temporal(TemporalType.DATE)
    private Date dateOfRate;
    @JsonView(SubcontractOperationRateView.Rate.class)
    @Column(name = "rate")
    private Double rate;
    @JsonView(SubcontractOperationRateView.SubcontractorOperation.class)
    @JoinColumn(name = "subcontractor_operation_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
	public SubcontractorOperation subcontractorOperation;
    @JsonView(SubcontractOperationRateView.SubcontractOperation.class)
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "subcontractOperationRate")
    private List<SubcontractOperation> subcontractOperationList;
    
    public SubcontractOperationRate(Integer id) {
        this.id = id;
    }

    @JsonView(SubcontractOperationRateView.All.class)
    public String getDisplay() {
        return subcontractorOperation.getDisplay();
     
    }

}
