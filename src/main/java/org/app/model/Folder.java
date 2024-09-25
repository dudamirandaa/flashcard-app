package org.app.model;

public class Folder {
    private String folderName;

    public Folder() {
    }

    public Folder(String folderName) {
        this.folderName = folderName;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }
}
