package com.trendsmixed.fma.module.packagingspecification;

import com.fasterxml.jackson.annotation.JsonView;
import com.trendsmixed.fma.module.item.Item;
import com.trendsmixed.fma.module.loadingplanitem.LoadingPlanItem;
import com.trendsmixed.fma.module.palletsize.PalletSize;
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
@Table(name = "packaging_specification")
public class PackagingSpecification implements Serializable {

    private static final long serialVersionUID = 1L;
    @JsonView(PackagingSpecificationView.Id.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JsonView(PackagingSpecificationView.PerPalletQuantity.class)
    @Column(name = "per_pallet_quantity")
    private Integer perPalletQuantity;
    @JsonView(PackagingSpecificationView.Item.class)
    @JoinColumn(name = " item_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Item item;
    @JsonView(PackagingSpecificationView.PalletSize.class)
    @JoinColumn(name = " pallet_size_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PalletSize palletSize;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "packagingSpecification", fetch = FetchType.LAZY)
    private List<LoadingPlanItem> loadingPlanItemList;

    @JsonView(PackagingSpecificationView.All.class)
    public String getDisplay() {
        return  palletSize.getName() + " : " + perPalletQuantity ;

    }
    
   
}
