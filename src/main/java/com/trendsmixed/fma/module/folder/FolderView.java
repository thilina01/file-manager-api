package com.trendsmixed.fma.module.folder;

import com.trendsmixed.fma.module.file.FileView;

/**
 *
 * @author Daminda
 */
public class FolderView {

    public interface Id {
    }

    public interface Description {
    }

    public interface Name {
    }

    public interface Folder {
    }

    public interface FolderList {
    }

    public interface FileList {
    }

    public interface All extends Id, Description, Name {
    }

    public interface AllAndFolderAll extends All, Folder {
    }

    public interface AllAndFolderListAll extends All, FolderList {
    }

    public interface AllAndFileListAll extends All, FileList, FileView.All {
    }

    public interface AllAndFolderListAllAndFileListAll extends FolderList, AllAndFileListAll {
    }
}
