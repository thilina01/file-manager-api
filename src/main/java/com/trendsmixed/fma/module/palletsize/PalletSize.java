package com.trendsmixed.fma.module.palletsize;
// import com.trendsmixed.fma.module.palletlable.PalletLable;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.packagingspecification.PackagingSpecification;
import com.trendsmixed.fma.module.palletlable.PalletLable;
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
@Table(name = "pallet_size")
@NamedQueries({
    @NamedQuery(name = "PalletSize.findAll", query = "SELECT b FROM PalletSize b")})
public class PalletSize implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(PalletSizeView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(PalletSizeView.Code.class)
    @Column(name = "code", unique = true)
    private String code;
    @JsonView(PalletSizeView.Name.class)
    @Column(name = "name")
    private String name;
    @JsonView(PalletSizeView.Length.class)
    @Column(name = "length")
    private Double length;
    @JsonView(PalletSizeView.Width.class)
    @Column(name = "width")
    private Double width;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "palletSize", fetch = FetchType.LAZY)
    private List<PalletLable> palletLableList;
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "palletSize")
    private List<PackagingSpecification> packagingSpecification;


    @JsonView(PalletSizeView.All.class)
    public String getDisplay() {
        return length + " : " + width;
    }
    
}
