package com.trendsmixed.fma.module.subcontractnote;

import com.trendsmixed.fma.module.location.Location;
import com.trendsmixed.fma.module.subcontractoperation.SubcontractOperation;
import com.trendsmixed.fma.module.subcontractor.Subcontractor;

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
@Table(name = "subcontract_note")
public class SubcontractNote implements Serializable {

    private static final long serialVersionUID = 1L;
    @JsonView(SubcontractNoteView.Id.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JsonView(SubcontractNoteView.NoteTime.class)
    @Column(name = "note_time")
    private Date noteTime;
    @JsonView(SubcontractNoteView.Recipient.class)
    @Column(name = "recipient")
    private String recipient;
    @JsonView(SubcontractNoteView.VehicleNumber.class)
    @Column(name = "vehicle_number")
    private String vehicleNumber;
    @JsonView(SubcontractNoteView.SubcontractReleaseTime.class)
    @Column(name = "subcontract_release_time")
    private Date subcontractReleaseTime;
    @JsonView(SubcontractNoteView.ContainerNumber.class)
    @Column(name = "container_number")
    private String containerNumber;
    private SubcontractOperation subcontractOperation;
    @JsonView(SubcontractNoteView.Location.class)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    @ManyToOne(optional = true)
    private Location location;
    @JsonView(SubcontractNoteView.Subcontractor.class)
    @JoinColumn(name = "subcontractor_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Subcontractor subcontractor;
    @JsonView(SubcontractNoteView.SubcontractOperation.class)
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "subcontractNote")
    private List<SubcontractOperation> subcontractOperationList;

    public SubcontractNote(Integer id) {
        this.id = id;
    }

    @JsonView(SubcontractNoteView.All.class)
    public String getDisplay() {
        return id + " : "; 
        
    }

}
