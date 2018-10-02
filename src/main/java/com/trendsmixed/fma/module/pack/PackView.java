package com.trendsmixed.fma.module.pack;

import com.trendsmixed.fma.utility.PageView;

import com.trendsmixed.fma.module.palletsize.PalletSizeView;

public class PackView {

        public interface Id {
        }

        public interface CubicMeter {
        }

        public interface PalletSize {
        }

        public interface All extends Id, CubicMeter, PageView.All {

        }

        public interface AllAndPalletSize extends All, PalletSize, PalletSizeView.All {
        }

}
