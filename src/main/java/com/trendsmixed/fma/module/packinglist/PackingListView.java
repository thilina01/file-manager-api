package com.trendsmixed.fma.module.packinglist;

import com.trendsmixed.fma.module.containersize.ContainerSizeView;
import com.trendsmixed.fma.module.country.CountryView;
import com.trendsmixed.fma.module.invoice.InvoiceView;
import com.trendsmixed.fma.module.port.PortView;
import com.trendsmixed.fma.utility.PageView;

public class PackingListView {

    public static interface Id {
    }

    public static interface NoOfContainers {
    }

    public static interface ContactPerson {
    }

    public static interface Port {
    }

    public static interface Country {
    }

    public static interface ContainerSize {
    }

    public static interface Invoice {
    }

    public static interface All extends Id, ContactPerson, NoOfContainers, PageView.All {
    }

    public static interface AllAndPortAll extends All, Port, PortView.All {
    }

    public static interface AllAndCountryAll extends All, Country, CountryView.All {
    }

    public static interface AllAndContainerSizeAll extends All, ContainerSize, ContainerSizeView.All {
    }

    public static interface AllAndInvoiceAll extends All, Invoice, InvoiceView.All {
    }

    public static interface AllAndPortAllAndCountryAllAndContainerSizeAllAndInvoiceAll extends All, Port, PortView.All, Country, CountryView.All, ContainerSize, ContainerSizeView.All, Invoice, InvoiceView.All {
    }
}
