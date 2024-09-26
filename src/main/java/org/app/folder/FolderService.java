package org.app.folder;

import org.app.model.Folder;
import org.app.util.JPAUtil;

public class FolderService {

    public Object find(String folder) {
        return JPAUtil.find(Folder.class, folder);
    }
}
