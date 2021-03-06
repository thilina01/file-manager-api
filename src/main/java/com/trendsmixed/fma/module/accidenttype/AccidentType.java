package com.trendsmixed.fma.module.accidenttype;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.accident.Accident;
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
@Table(name = "accident_type")
public class AccidentType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(AccidentTypeView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(AccidentTypeView.Code.class)
    @Column(name = "code", unique = true)
    private String code;
    @JsonView(AccidentTypeView.Name.class)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "accidentType")
    private List<Accident> accidentList;

    @JsonView(AccidentTypeView.All.class)
    public String getDisplay() {
        return code + " : " + name;
    }
}
