package com.trendsmixed.fma.module.standardunit;

import com.fasterxml.jackson.annotation.JsonView;
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
@Table(name = "standard_unit")
public class StandardUnit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(StandardUnitView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(StandardUnitView.Code.class)
    @Column(name = "code", unique = true)
    private String code;
    @JsonView(StandardUnitView.Name.class)
    @Column(name = "name")
    private String name;

    @JsonView(StandardUnitView.All.class)
    public String getDisplay() {
        return code + " : " + name;
    }
}
