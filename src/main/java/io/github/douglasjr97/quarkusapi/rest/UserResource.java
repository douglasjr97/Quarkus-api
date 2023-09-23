package io.github.douglasjr97.quarkusapi.rest;

import io.github.douglasjr97.quarkusapi.domain.model.User;
import io.github.douglasjr97.quarkusapi.rest.dto.CreateUserRequest;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
@POST
@Transactional
    public Response createUser(CreateUserRequest userRequest){

    User user = new User();
    user.setName(userRequest.getName());
    user.setAge(userRequest.getAge());

    user.persist();

        return Response.ok(user).build();
    }
    @GET
    public Response listAllUsers(){
        PanacheQuery<User> query = User.findAll();
        return Response.ok(query.list()).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response updateUser(@PathParam("id") Long id, CreateUserRequest userData){

       User changedUser = User.findById(id);

        if (changedUser != null) {
            changedUser.setName(userData.getName());
            changedUser.setAge(userData.getAge());
            return Response.ok(changedUser).build();
        }

        return Response.ok(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteUser(@PathParam("id") Long id){
        User user = User.findById(id);

        if(user != null){
            user.delete();
            return Response.ok().build();
        }

        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
