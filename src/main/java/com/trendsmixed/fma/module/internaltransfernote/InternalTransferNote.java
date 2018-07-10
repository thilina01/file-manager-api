package com.trendsmixed.fma.module.internaltransfernote;

import com.trendsmixed.fma.module.internaltransferitem.InternalTransferItem;
import com.trendsmixed.fma.module.location.Location;

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
@Table(name = "internal_transfer_note")
public class InternalTransferNote implements Serializable {

    private static final long serialVersionUID = 1L;
    @JsonView(InternalTransferNoteView.Id.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JsonView(InternalTransferNoteView.Description.class)
    @Column(name = "description")
    private String description;
    @JsonView(InternalTransferNoteView.NoteDate.class)
    @Column(name = "note_date")
    private Date noteDate;
    @JsonView(InternalTransferNoteView.ArrivalTime.class)
    @Column(name = "arrival_time")
    private Date arrivalTime;
    @JsonView(InternalTransferNoteView.Recipient.class)
    @Column(name = "recipient")
    private String recipient;
    @JsonView(InternalTransferNoteView.VehicleNumber.class)
    @Column(name = "vehicle_number")
    private String vehicleNumber;
    @JsonView(InternalTransferNoteView.ReleaseTime.class)
    @Column(name = "release_time")
    private Date releaseTime;
    @JsonView(InternalTransferNoteView.FromLocation.class)
    @JoinColumn(name = "from_location_id", referencedColumnName = "id")
    @ManyToOne(optional = true)
    private Location fromLocation;
    @JsonView(InternalTransferNoteView.ToLocation.class)
    @JoinColumn(name = "to_location_id", referencedColumnName = "id")
    @ManyToOne(optional = true)
    private Location toLocation;
    @JsonView(InternalTransferNoteView.InternalTransferItem.class)
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "internalTransferNote")
    private List<InternalTransferItem> internalTransferItemList;

    public InternalTransferNote(Integer id) {
        this.id = id;
    }

    @JsonView(InternalTransferNoteView.All.class)
    public String getDisplay() {
        return id + " : "; 
        
    }

}
