package com.trendsmixed.fma.module.port;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.packinglist.PackingList;
import java.io.Serializable;
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
@Table(name = "port")
public class Port implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(PortView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(PortView.Code.class)
    @Column(name = "code", unique = true)
    private String code;
    @JsonView(PortView.Name.class)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "port")
    private List<PackingList> packingListList;

    @JsonView(PortView.All.class)
    public String getDisplay() {
        return code + " : " + name;
    }
}