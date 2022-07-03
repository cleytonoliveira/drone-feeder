package org.futuereh.controller;

import org.futuereh.dto.DeliveryDto;
import org.futuereh.dto.DroneDto;
import org.futuereh.entity.DeliveryEntity;
import org.futuereh.entity.DroneEntity;
import org.futuereh.service.DeliveryService;
import org.futuereh.service.DroneService;

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

@Path("/delivery")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class DeliveryController {

  /**
   * Attributes
   */
  @Inject
  private DeliveryService service;

  /**
   * Methods.
   */
  @GET
  public Response listar() {
    return Response.ok(service.listar()).build();
  }

  @GET
  @Path("/{id}")
  public DeliveryEntity buscarPorId(@PathParam(value = "id") Long id) {
    return service.buscarPorId(id);
  }

  @POST
  public Response salvar(@Valid DeliveryDto deliveryDto) {
    return Response.status(Response.Status.CREATED).entity(service.salvar(deliveryDto)).build();
  }

  @PATCH
  @Path("/{id}")
  public Response atualizar(@PathParam("id") Long id, @Valid DeliveryDto deliveryDto) {
    return Response.ok(service.atualizar(deliveryDto, id)).build();
  }

  @DELETE
  @Path("/{id}")
  public void deletar(@PathParam("id") Long id) {
    service.deletar(id);
  }
}

