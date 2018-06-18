package com.trendsmixed.fma.module.loadingplan;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.address.Address;
import com.trendsmixed.fma.module.containersize.ContainerSize;
import com.trendsmixed.fma.module.customer.Customer;
import com.trendsmixed.fma.module.dispatchnote.DispatchNote;
import com.trendsmixed.fma.module.employee.Employee;
import com.trendsmixed.fma.module.loadingplanitem.LoadingPlanItem;
import com.trendsmixed.fma.module.port.Port;
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
@Table(name = "loading_plan")
public class LoadingPlan implements Serializable {

    private static final long serialVersionUID = 1L;
    @JsonView(LoadingPlanView.Id.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JsonView(LoadingPlanView.LoadingPlanDate.class)
    @Column(name = "loading_plan_date")
    @Temporal(TemporalType.DATE)
    private Date loadingPlanDate;
    @JsonView(LoadingPlanView.ContainerSize.class)
    @JoinColumn(name = "container_size_id", referencedColumnName = "id")
    @ManyToOne(optional = true)
    private ContainerSize containerSize;
    @JsonView(LoadingPlanView.Address.class)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Address address;
    @JsonView(LoadingPlanView.NoOfContainers.class)
    @Column(name = "no_of_containers")
    private Integer noOfContainers;
    @JsonView(LoadingPlanView.Port.class)
    @JoinColumn(name = "port_id", referencedColumnName = "id")
    @ManyToOne(optional = true)
    private Port port;
    @JsonView(LoadingPlanView.PortOfLoading.class)
    @JoinColumn(name = "port_of_loading_id", referencedColumnName = "id")
    @ManyToOne(optional = true)
    private Port portOfLoading;
    @JsonView(LoadingPlanView.Customer.class)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Customer customer;
    // @JsonView(LoadingPlanView.Invoice.class)
    // @JoinColumn(name = "invoice_id", referencedColumnName = "id")
    // @ManyToOne(optional = true)
    // private Invoice invoice;
    @JsonView(LoadingPlanView.DispatchNote.class)
    @JoinColumn(name = "dispatchNote_id", referencedColumnName = "id")
    @ManyToOne(optional = true)
    private DispatchNote dispatchNote;
    @JsonView(LoadingPlanView.LoadingPlanItem.class)
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "loadingPlan", fetch = FetchType.LAZY)
    private List<LoadingPlanItem> loadingPlanItemList;
    @JsonView(LoadingPlanView.Employee.class)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Employee employee;

    @JsonView(LoadingPlanView.All.class)
    public String getDisplay() {
        return id + " : "; 
        
    }
    
    
}
