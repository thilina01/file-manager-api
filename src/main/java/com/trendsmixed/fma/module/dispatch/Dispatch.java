package com.trendsmixed.fma.module.dispatch;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.dispatchnote.DispatchNote;
import com.trendsmixed.fma.module.dispatchschedule.DispatchSchedule;
import com.trendsmixed.fma.module.jobdispatch.JobDispatch;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Thilina
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "dispatch")
public class Dispatch implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    @JsonView(DispatchView.Id.class)
    private Integer id;
    @JsonView(DispatchView.Quantity.class)
    @Column(name = "quantity")
    private Double quantity;
    @JsonView(DispatchView.JobDispatch.class)
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "dispatch")
    private List<JobDispatch> jobDispatchList;
    @JsonView(DispatchView.DispatchSchedule.class)
    @JoinColumn(name = "dispatch_schedule_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private DispatchSchedule dispatchSchedule;
    @JsonView(DispatchView.DispatchNote.class)
    @JoinColumn(name = "dispatch_note_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private DispatchNote dispatchNote;

}
