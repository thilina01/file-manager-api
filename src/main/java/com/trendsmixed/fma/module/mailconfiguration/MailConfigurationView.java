package com.trendsmixed.fma.module.mailconfiguration;

import com.trendsmixed.fma.utility.PageView;

public class MailConfigurationView {

    public interface Id {
    }

    public interface Host {
    }

    public interface Port {
    }

    public interface User {
    }

    public interface Password {
    }

    public interface All extends Id, Host, Port, User, Password, PageView.All {
    }

}
