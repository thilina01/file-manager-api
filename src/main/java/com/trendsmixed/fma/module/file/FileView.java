package com.trendsmixed.fma.module.file;

/**
 *
 * @author Daminda
 */
public class FileView {

    public static interface Id {
    }

    public static interface Link {
    }

    public static interface Description {
    }

    public static interface Extension {
    }

    public static interface Name {
    }

    public static interface OriginalFileName {
    }

    public static interface UploadDate {
    }

    public static interface FileType {
    }

    public static interface All extends Id, Link, Description, Extension, Name, OriginalFileName, UploadDate {
    }

}
