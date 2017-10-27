package com.trendsmixed.fma.module.fileinformation;

/**
 *
 * @author Daminda
 */
public class FileInformationView {

    public static interface Id {
    }

    public static interface Link {
    }
    
    public static interface Path {
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

    public static interface All extends Id, Link, Path, Description, Extension, Name, OriginalFileName, UploadDate {
    }

}
