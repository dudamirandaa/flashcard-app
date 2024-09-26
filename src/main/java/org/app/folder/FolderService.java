package org.app.folder;

import org.app.model.Folder;
import org.app.util.JPAUtil;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class FolderService {

    public Folder find(String folder) {
        return FolderRepository.find(Folder.class, folder);
    }

    public List<Folder> findAll() {
        return JPAUtil.findAll();
    }
}
