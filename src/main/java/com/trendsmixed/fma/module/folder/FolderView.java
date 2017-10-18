package com.trendsmixed.fma.module.folder;

import com.trendsmixed.fma.module.file.FileView;

/**
 *
 * @author Daminda
 */
public class FolderView {

    public static interface Id {
    }

    public static interface Description {
    }

    public static interface Name {
    }

    public static interface Folder {
    }

    public static interface FolderList {
    }

    public static interface FileList {
    }

    public static interface All extends Id, Description, Name {
    }

    public static interface AllAndFolderAll extends All, Folder {
    }

    public static interface AllAndFolderListAll extends All, FolderList {
    }

    public static interface AllAndFileListAll extends All, FileList, FileView.All {
    }

    public static interface AllAndFolderListAllAndFileListAll extends FolderList, AllAndFileListAll {
    }
}
