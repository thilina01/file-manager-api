package com.trendsmixed.fma.module.warehouse;

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
@Table(name = "warehouse")
public class Warehouse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(WarehouseView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(WarehouseView.Code.class)
    @Column(name = "code", unique = true)
    private String code;
    @JsonView(WarehouseView.Name.class)
    @Column(name = "name")
    private String name;

    public Warehouse(Integer id) {
        this.id = id;
    }

    @JsonView(WarehouseView.All.class)
    public String getDisplay() {
        return code + " : " + name;
    }
}
