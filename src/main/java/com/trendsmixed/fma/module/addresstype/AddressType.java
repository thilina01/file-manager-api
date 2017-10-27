package com.trendsmixed.fma.module.addresstype;

import java.io.Serializable;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.address.Address;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
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
@Table(name = "address_type")
public class AddressType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(AddressTypeView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(AddressTypeView.Code.class)
    @Column(name = "code", unique = true)
    private String code;
    @JsonView(AddressTypeView.Name.class)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "addressType")
    private List<Address> addressList;

}
