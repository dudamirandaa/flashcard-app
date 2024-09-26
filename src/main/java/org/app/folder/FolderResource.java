package org.app.folder;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.app.model.Folder;

@Path("/folders")
public class FolderResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getAllFolders() {
        return "teste";
    }

    @GET
    @Path("/{folder}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFolder(@PathParam("folder") String folderName) {
        return Response.ok().entity(new Folder(folderName)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveFolder(Folder folder) {
        return Response.status(201).entity(folder).build();
    }
}
