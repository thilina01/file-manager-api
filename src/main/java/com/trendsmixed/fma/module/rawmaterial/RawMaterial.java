package com.trendsmixed.fma.module.rawmaterial;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author Thilina
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "raw_material")
public class RawMaterial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(RawMaterialView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(RawMaterialView.Code.class)
    @Column(name = "code", unique = true)
    private String code;
    @JsonView(RawMaterialView.Name.class)
    @Column(name = "name")
    private String name;
    }

