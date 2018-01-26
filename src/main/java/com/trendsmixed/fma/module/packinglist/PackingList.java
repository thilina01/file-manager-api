package com.trendsmixed.fma.module.packinglist;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.containersize.ContainerSize;
import com.trendsmixed.fma.module.country.Country;
import com.trendsmixed.fma.module.employee.Employee;
import com.trendsmixed.fma.module.port.Port;
import com.trendsmixed.fma.module.invoice.Invoice;
import com.trendsmixed.fma.module.dispatchnote.DispatchNote;


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
@Table(name = "packing_list")
public class PackingList implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(PackingListView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(PackingListView.NoOfContainers.class)
    @Column(name = "no_of_containers")
    private Integer noOfContainers;
    @JsonView(PackingListView.Port.class)
    @JoinColumn(name = "port_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Port port;
    @JsonView(PackingListView.PortOfLoading.class)
    @JoinColumn(name = "port_of_loading_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Port portOfLoading;
    @JsonView(PackingListView.NetWeight.class)
    @Column(name = "net_weight")
    private Double netWeight;
    @JsonView(PackingListView.GrossWeight.class)
    @Column(name = "gross_weight")
    private Double grossWeight;
    @JsonView(PackingListView.CubicMeter.class)
    @Column(name = "cubic_meter ")
    private Double cubicMeter ;
    @JsonView(PackingListView.NumberOfPackage.class)
    @Column(name = "number_of_package")
    private Double numberOfPackage;
    @JsonView(PackingListView.Country.class)
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Country country;
    @JsonView(PackingListView.ContainerSize.class)
    @JoinColumn(name = "container_size_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ContainerSize containerSize;
    @JsonView(PackingListView.Employee.class)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Employee employee;    
    @JsonView(PackingListView.DispatchNote.class)
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "packingList")
    private List<DispatchNote> dispatchNoteList;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "packingList")
    private List<Invoice> invoiceList;

    public PackingList(Integer anId) {
        this.id = anId;
    }

}
