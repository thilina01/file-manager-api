package com.trendsmixed.fma.module.contact;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.contacttype.ContactType;
import com.trendsmixed.fma.module.customer.Customer;
import com.trendsmixed.fma.module.employee.Employee;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *
 * @author Thilina
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "contact")
public class Contact implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(ContactView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(ContactView.ContactNumber.class)
    @Column(name = "contact_number")
    private String contactNumber;
    @JsonView(ContactView.Customer.class)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Customer customer;
    @JsonView(ContactView.ContactType.class)
    @JoinColumn(name = "contact_type_id", referencedColumnName = "id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private ContactType contactType;
   
}
