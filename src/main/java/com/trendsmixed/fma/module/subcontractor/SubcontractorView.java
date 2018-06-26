package com.trendsmixed.fma.module.subcontractor;

import com.trendsmixed.fma.utility.PageView;

import com.trendsmixed.fma.module.subcontractoroperation.SubcontractorOperationView;

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

        public interface Validity {
        }

        public interface SubcontractorOperation {
        }

        public interface All extends Id, Code, Name, Address, Contact, Validity, PageView.All {
        }

        public interface AllAndSubcontractorOperation
                        extends All, SubcontractorOperation, SubcontractorOperationView.All {
        }

}
