package com.trendsmixed.fma.module.dispatchnote;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.customer.Customer;
import com.trendsmixed.fma.module.dispatch.Dispatch;
import com.trendsmixed.fma.module.invoice.Invoice;
import com.trendsmixed.fma.module.loadingplan.LoadingPlan;
import com.trendsmixed.fma.module.location.Location;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Thilina
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "dispatch_note")
public class DispatchNote implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(DispatchNoteView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(DispatchNoteView.DispatchDate.class)
    @Column(name = "dispatch_date")
    @Temporal(TemporalType.DATE)
    private Date dispatchDate;
    @JsonView(DispatchNoteView.ContainerNumber.class)
    @Column(name = "container_number")
    private String containerNumber;
    @JsonView(DispatchNoteView.VehicleNumber.class)
    @Column(name = "vehicle_number")
    private String vehicleNumber;
    @JsonView(DispatchNoteView.DispatchReleaseTime.class)
    @Column(name = "dispatch_release_time")
    private Date dispatchReleaseTime;
    @JsonView(DispatchNoteView.Recipient.class)
    @Column(name = "recipient")
    private String recipient;
    @JsonView(DispatchNoteView.Customer.class)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Customer customer;
    @JsonView(DispatchNoteView.Location.class)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    @ManyToOne(optional = true)
    private Location location;
    @JsonView(DispatchNoteView.Invoice.class)
    @JoinColumn(name = "invoice_id", referencedColumnName = "id")
    @ManyToOne(optional = true)
    private Invoice invoice;
    @JsonView(DispatchNoteView.LoadingPlan.class)
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "dispatchNote")
    private List<LoadingPlan> loadingPlanList;
    @JsonView(DispatchNoteView.Dispatch.class)
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "dispatchNote")
    private List<Dispatch> dispatchList;

    public DispatchNote(Integer anId) {
        this.id = anId;
    }

    @JsonView(DispatchNoteView.All.class)
    public String getDisplay() {
        return id + " : "; 
        
    }

}
