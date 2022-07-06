package org.futuereh.controller;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.futuereh.dto.DroneDto;
import org.futuereh.service.DroneService;

@Path("/drone")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class DroneController {

  /**
   * Attributes.
   */
  @Inject
  private DroneService service;

  /**
   * Methods.
   */
  @GET
  public Response listAll() {
    return Response.ok(service.listAll()).build();
  }

  @GET
  @Path("/{id}")
  public Response findById(@PathParam(value = "id") Long id) {
    return Response.ok(service.findById(id)).build();
  }

  @POST
  public Response save(@Valid DroneDto droneDto) {
    return Response.status(Response.Status.CREATED).entity(service.save(droneDto)).build();
  }

  @PATCH
  @Path("/{id}")
  public Response update(@PathParam("id") Long id, @Valid DroneDto droneDto) {
    return Response.ok(service.update(droneDto, id)).build();
  }

  @DELETE
  @Path("/{id}")
  public void delete(@PathParam("id") Long id) {
    service.delete(id);
  }
}
