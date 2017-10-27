package com.trendsmixed.fma.module.file;

/**
 *
 * @author Daminda
 */
public class FileView {

    public interface Id {
    }

    public interface Link {
    }

    public interface Description {
    }

    public interface Extension {
    }

    public interface Name {
    }

    public interface OriginalFileName {
    }

    public interface UploadDate {
    }

    public interface FileType {
    }

    public interface All extends Id, Link, Description, Extension, Name, OriginalFileName, UploadDate {
    }

}
