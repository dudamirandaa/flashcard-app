package org.app.folder;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/folders")
public class FolderResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getAllFolders() {
        return "teste";
    }
}
