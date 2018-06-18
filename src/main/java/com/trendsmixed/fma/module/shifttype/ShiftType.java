package com.trendsmixed.fma.module.shifttype;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.production.Production;
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
@Table(name = "shift_type")
public class ShiftType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(ShiftTypeView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(ShiftTypeView.Code.class)
    @Column(name = "code", unique = true)
    private String code;
    @JsonView(ShiftTypeView.Name.class)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "shiftType")
    private List<Production> productionList;

    @JsonView(ShiftTypeView.All.class)
    public String getDisplay() {
        return code + " : " + name;
    }
}
