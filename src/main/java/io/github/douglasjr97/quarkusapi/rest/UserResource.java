package io.github.douglasjr97.quarkusapi.rest;

import io.github.douglasjr97.quarkusapi.service.UserService;
import io.github.douglasjr97.quarkusapi.rest.dto.CreateUserRequest;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    UserService userService;

    @POST
    public Response createUser(CreateUserRequest userRequest){
        return Response.ok(userService.createUser(userRequest)).build();
    }

    @GET
    public Response listAllUsers(){
        return Response.ok(userService.listAllUsers()).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateUser(@PathParam("id") Long id, CreateUserRequest userData){
        return Response.ok(userService.updateUser(id, userData)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") Long id){
        userService.deleteUser(id);
        return Response.ok().build();
    }
}
