package com.trendsmixed.fma.jsonView;
public class Views {
    
    public static interface FolderOnly {
    }
    public static interface FileOnly {
    }
    public static interface FolderWithSubFolders extends FolderOnly {
    }
    public static interface FolderWithParent extends FolderOnly {
    }
    public static interface FolderWithFiles extends FolderOnly {
    }
    public static interface FolderWithSubFoldersAndFiles extends FolderWithSubFolders,FolderWithFiles {
    }
    public static interface FolderParentAndWithSubFoldersAndFiles extends FolderWithSubFolders,FolderWithFiles,FolderWithParent,FileOnly {
    }
    
    public static interface Full extends FolderOnly {
    }
 
}