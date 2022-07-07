package org.futuereh.controller;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
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

  @PUT
  @Path("/{id}")
  public Response update(@PathParam("id") Long id, @Valid DroneDto droneDto) {
    return Response.ok(service.update(droneDto, id)).build();
  }

  @PATCH
  @Path("/{id}/withdrawal/{deliveryId}")
  public Response withdrawal(@PathParam("id") Long id, @PathParam("deliveryId") Long deliveryId, @Valid DroneDto droneDto) {
    return Response.ok(service.withdrawal(droneDto, id, deliveryId)).build();
  }

  @PATCH
  @Path("/{id}/delivery/{deliveryId}")
  public Response delivery(@PathParam("id") Long id, @PathParam("deliveryId") Long deliveryId, @Valid DroneDto droneDto) {
    return Response.ok(service.delivery(droneDto, id, deliveryId)).build();
  }

  @PATCH
  @Path("/{id}/map/{deliveryId}")
  public Response maps(@PathParam("id") Long id, @PathParam("deliveryId") Long deliveryId, @Valid DroneDto droneDto) {
    return Response.ok(service.maps(droneDto, id, deliveryId)).build();
  }

  @PATCH
  @Path("/{id}/deactivate")
  public Response deactivate(@PathParam("id") Long id) {
    return Response.ok(service.deactivate(id)).build();
  }

  @DELETE
  @Path("/{id}")
  public void delete(@PathParam("id") Long id) {
    service.delete(id);
  }
}
