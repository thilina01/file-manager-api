package com.trendsmixed.fma.module.subcontractor;

import com.trendsmixed.fma.utility.PageView;

/**
 *
 * @author Daminda
 */
public class SubcontractorView {

        public interface Id {
        }

        public interface Code {
        }

        public interface Name {
        }

        public interface Address {
        }

        public interface Contact {
        }

        public interface All extends Id, Code, Name, Address, Contact, PageView.All {
        }

}
