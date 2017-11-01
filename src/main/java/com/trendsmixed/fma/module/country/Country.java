package com.trendsmixed.fma.module.country;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.address.Address;
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
@Table(name = "country")
public class Country implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(CountryView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(CountryView.Code.class)
    @Column(name = "code", unique = true)
    private String code;
    @JsonView(CountryView.Name.class)
    @Column(name = "name", unique = true)
    private String name;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "country")
    private List<Address> addressList;

    @JsonView(CountryView.All.class)
    public String getDisplay() {
        return code + " : " + name;
    }
}
