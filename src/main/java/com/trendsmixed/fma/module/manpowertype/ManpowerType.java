package com.trendsmixed.fma.module.manpowertype;

import com.trendsmixed.fma.module.manpower.Manpower;
import com.fasterxml.jackson.annotation.JsonView;
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
@Table(name = "manpower_type")
public class ManpowerType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(ManpowerTypeView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(ManpowerTypeView.Code.class)
    @Column(name = "code", unique = true)
    private String code;
    @JsonView(ManpowerTypeView.Name.class)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "manpowerType")
    private List<Manpower> manpowerList;

    @JsonView(ManpowerTypeView.All.class)
    public String getDisplay() {
        return code + " : " + name;
    }
}
