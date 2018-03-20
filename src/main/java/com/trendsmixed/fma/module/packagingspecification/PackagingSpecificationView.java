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

    public interface AllAndItemAll extends All, Item, ItemView.All {
    }

    public interface AllAndPalletSizeAll extends All, PalletSize, PalletSizeView.All {
    }

    public interface AllAndPalletSizeAndItemAll extends All, PalletSize, PalletSizeView.All, Item, ItemView.All {
    }
}
