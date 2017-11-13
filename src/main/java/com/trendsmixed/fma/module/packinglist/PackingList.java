package com.trendsmixed.fma.module.packinglist;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.containersize.ContainerSize;
import com.trendsmixed.fma.module.country.Country;
import com.trendsmixed.fma.module.invoice.Invoice;
import com.trendsmixed.fma.module.port.Port;
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
    @JsonView(PackingListView.ContactPerson.class)
    @Column(name = "contact_person")
    private String contactPerson;
    @JsonView(PackingListView.Port.class)
    @JoinColumn(name = "port_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Port port;
    @JsonView(PackingListView.Country.class)
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Country country;
    @JsonView(PackingListView.ContainerSize.class)
    @JoinColumn(name = "container_size_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ContainerSize containerSize;
    @JsonView(PackingListView.Invoice.class)
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "packingList", fetch = FetchType.LAZY)
    private List<Invoice> invoiceList;

    public PackingList(Integer anId) {
        this.id = anId;
    }

}
