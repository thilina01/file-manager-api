package com.trendsmixed.fma.module.pack;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.palletsize.PalletSize;

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
@Table(name = "pack")
public class Pack implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(PackView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(PackView.CubicMeter.class)
    @Column(name = "cubic_meter ")
    private Double cubicMeter ;
    @JsonView(PackView.PalletSize.class)
    @JoinColumn(name = " pallet_size_id", referencedColumnName = "id")
    @ManyToOne(optional = true)
    private PalletSize palletSize;
    public Pack(Integer id) {
        this.id = id;
    }

    @JsonView(PackView.All.class)
    public String getDisplay() {
        return id + " : ";
    }
}
