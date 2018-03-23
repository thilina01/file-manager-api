package com.trendsmixed.fma.module.palletsize;

import com.trendsmixed.fma.utility.PageView;

public class PalletSizeView {

    public interface Id {
    }

    public interface Name {
    }

    public interface Code {
    }

    public interface Length {
    }

    public interface Width {
    }

    public interface Weight {
    }

    public interface All extends Id, Name, Length, Width, Code, Weight, PageView.All {
    }
}
