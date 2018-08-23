package com.trendsmixed.fma.module.subcontractreworknote;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.trendsmixed.fma.module.location.Location;
import com.trendsmixed.fma.module.subcontractor.Subcontractor;
import com.trendsmixed.fma.module.subcontractreworkoperation.SubcontractReworkOperation;
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
@Table(name = "subcontract_rework_note")
public class SubcontractReworkNote implements Serializable {

    private static final long serialVersionUID = 1L;
    @JsonView(SubcontractReworkNoteView.Id.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JsonView(SubcontractReworkNoteView.NoteTime.class)
    @Column(name = "note_time")
    private Date noteTime;
    @JsonView(SubcontractReworkNoteView.Recipient.class)
    @Column(name = "recipient")
    private String recipient;
    @JsonView(SubcontractReworkNoteView.VehicleNumber.class)
    @Column(name = "vehicle_number")
    private String vehicleNumber;
    @JsonView(SubcontractReworkNoteView.SubcontractReleaseTime.class)
    @Column(name = "subcontract_release_time")
    private Date subcontractReleaseTime;
    @JsonView(SubcontractReworkNoteView.ContainerNumber.class)
    @Column(name = "container_number")
    private String containerNumber;
    @JsonView(SubcontractReworkNoteView.Location.class)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    @ManyToOne(optional = true)
    private Location location;
    @JsonView(SubcontractReworkNoteView.Subcontractor.class)
    @JoinColumn(name = "subcontractor_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Subcontractor subcontractor;
    @JsonView(SubcontractReworkNoteView.SubcontractReworkOperation.class)
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "subcontractReworkNote")
    private List<SubcontractReworkOperation> subcontractReworkOperationList;

    public SubcontractReworkNote(Integer id) {
        this.id = id;
    }

    @JsonView(SubcontractReworkNoteView.All.class)
    public String getDisplay() {
        return id + " : "; 
        
    }

}
