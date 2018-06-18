package com.trendsmixed.fma.module.packagingspecification;

import com.trendsmixed.fma.module.item.ItemView;
import com.trendsmixed.fma.module.palletsize.PalletSizeView;
import com.trendsmixed.fma.utility.PageView;

/**
 *
 * @author Thilina
 */
public class PackagingSpecificationView {

    public interface Id {
    }

    public interface PerPalletQuantity {
    }

    public interface Item {
    }

    public interface PalletSize {
    }

    public interface All extends Id, PerPalletQuantity, PageView.All {
    }

    public interface AllAndItem extends All, Item, ItemView.All {
    }

    public interface AllAndPalletSize extends All, PalletSize, PalletSizeView.All {
    }

    public interface AllAndPalletSizeAndItem extends All, AllAndItem, AllAndPalletSize {
    }

}
