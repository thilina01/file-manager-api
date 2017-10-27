package com.trendsmixed.fma.module.breakdown;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.machine.Machine;
import com.trendsmixed.fma.module.operationbreadown.OperationBreadown;
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
@Table(name = "breakdown")
public class Breakdown implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(BreakdownView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(BreakdownView.Date.class)
    @Column(name = "breakdown_date")
    @Temporal(TemporalType.DATE)
    private Date breakdownDate;
    @JsonView(BreakdownView.Duration.class)
    @Column(name = "duration")
    private Integer duration;
    @JsonView(BreakdownView.BreakdownTime.class)
    @Column(name = "breakdown_time")
    private Date breakdownTime;
    @JsonView(BreakdownView.RecoveryTime.class)
    @Column(name = "recovery_time")
    private Date recoveryTime;
    @JsonView(BreakdownView.BreakdownNumber.class)
    @Column(name = "breakdown_number")
    private String breakdownNumber;
    @JsonView(BreakdownView.Description.class)
    @Column(name = "description")
    private String description;
    @JsonView(BreakdownView.Machine.class)
    @JoinColumn(name = "machine_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Machine machine;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "breakdown")
    private List<OperationBreadown> operationBreadownList;

}
