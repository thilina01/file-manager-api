package com.trendsmixed.fma.module.materialtype;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Thilina
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "material_type")
public class MaterialType implements Serializable {

    private static final long serialVersionUID = 1L;
    @JsonView(MaterialTypeView.Id.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JsonView(MaterialTypeView.Code.class)
    @Column(name = "code", unique = true)
    private String code;
    @JsonView(MaterialTypeView.Description.class)
    @Column(name = "name")
    private String name;

    public MaterialType(int anId) {
        this.id = anId;
    }

    @JsonView(MaterialTypeView.All.class)
    public String getDisplay() {
        return code + " : " + name;
    }
}
