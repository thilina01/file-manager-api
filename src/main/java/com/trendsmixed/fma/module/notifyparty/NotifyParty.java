package com.trendsmixed.fma.module.notifyparty;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.customer.Customer;
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
@Table(name = "notify_party")
@NamedQueries({
    @NamedQuery(name = "NotifyParty.findAll", query = "SELECT c FROM NotifyParty c")})
public class NotifyParty implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(NotifyPartyView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(NotifyPartyView.Code.class)
    @Column(name = "code", unique = true)
    private String code;
    @JsonView(NotifyPartyView.Name.class)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "notifyParty")
    private List<Customer> customerList;

    @JsonView(NotifyPartyView.All.class)
    public String getDisplay() {
        return code + " : " + name;
    }
}
