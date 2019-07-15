package com.trendsmixed.fma.module.rawmaterialitem;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.customer.Customer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Thilina
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "raw_material_item")
public class RawMaterialItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(RawMaterialItemView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(RawMaterialItemView.Code.class)
    @Column(name = "code", unique = true)
    private String code;
    @JsonView(RawMaterialItemView.Description.class)
    @Column(name = "description")
    private String description;
    @JsonView(RawMaterialItemView.UnitWeight.class)
    @Column(name = "unit_weight")
    private Double unitWeight;
    @JsonView(RawMaterialItemView.NumberOfPieces.class)
    @Column(name = "number_of_pieces")
    private Double numberOfPieces;

}
