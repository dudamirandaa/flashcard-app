package org.app.folder;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.app.model.Folder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Path("/folders")
public class FolderResource {

    private FolderService folderService = new FolderService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Folder> getAllFolders() {
        return folderService.findAll();
    }

    @GET
    @Path("/{folder}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFolder(@PathParam("folder") String folderName) {
        Folder folder = folderService.find(folderName);

        if (folder == null) {
            return Response.status(404).entity("Folder not found").build();
        }

        return Response.ok().entity(folder).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveFolder(Folder folder) {
        return Response.status(201).entity(folder).build();
    }
}
