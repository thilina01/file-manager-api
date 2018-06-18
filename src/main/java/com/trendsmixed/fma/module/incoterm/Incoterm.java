package com.trendsmixed.fma.module.incoterm;

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
@Table(name = "incoterm")
public class Incoterm implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(IncotermView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(IncotermView.Code.class)
    @Column(name = "code", unique = true)
    private String code;
    @JsonView(IncotermView.Name.class)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "incoterm")
    private List<Customer> customerList;

    @JsonView(IncotermView.All.class)
    public String getDisplay() {
        return code + " : " + name;
    }
}
