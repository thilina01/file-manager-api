package com.trendsmixed.fma.module.exchangerate;

import com.trendsmixed.fma.module.currency.CurrencyView;
import com.trendsmixed.fma.utility.PageView;

public class ExchangeRateView {

    public interface Id {
    }

    public interface ExchangeRate {
    }

    public interface ExchangeRateDate {
    }

    public interface Currency {
    }

    public interface All extends Id, ExchangeRate, ExchangeRateDate, PageView.All {
    }

    public interface AllAndCurrencyId extends All, Currency, CurrencyView.Id {
    }

    public interface AllAndCurrencyAll extends All, Currency, CurrencyView.All {
    }
}
