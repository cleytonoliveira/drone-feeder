package org.futuereh.controller;

import org.futuereh.dto.DroneDto;
import org.futuereh.entity.DroneEntity;
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

  @Path("/drone")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)

  public class DroneController {

    /**
     * Atributos.
     */
    @Inject
    private DroneService service;


    /**
     * Métodos.
     */
    @GET
    public Response listar() {
      return Response.ok(service.listar()).build();
    }

    @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam(value = "id") Long id) {
      return Response.ok(service.buscarPorId(id)).build();
    }

    @POST
    public Response salvar(@Valid DroneDto droneDto) {
      return Response.status(Response.Status.CREATED).entity(service.salvar(droneDto)).build();
    }

    @PATCH
    @Path("/{id}")
    public Response atualizar(@PathParam("id") Long id, @Valid DroneDto droneDto) {
      return Response.ok(service.atualizar(droneDto, id)).build();
    }

    @DELETE
    @Path("/{id}")
    public void deletar(@PathParam("id") Long id) {
      service.deletar(id);
    }
  }

