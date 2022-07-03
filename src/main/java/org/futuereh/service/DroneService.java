package org.futuereh.service;


import org.futuereh.dto.DroneDto;
import org.futuereh.entity.DroneEntity;
import org.futuereh.repository.DroneRepository;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class DroneService {

  /**
   * Atributos.
   */
  @Inject
  private DroneRepository repository;

  /**
   * Métodos.
   */
  public List<DroneEntity> listar() {
    return repository.listAll();
  }

  public DroneEntity buscarPorId(Long id) {
    return repository.findById(id);
  }

  @Transactional
  public DroneEntity salvar(DroneDto droneDto) {
    DroneEntity drone = new DroneEntity();
    drone.setAlias(droneDto.getAlias());
    drone.setBrandName(droneDto.getAlias());
    drone.setDelivery(droneDto.getDelivery());
    drone.setLatitude(droneDto.getLatitude());
    drone.setLongitude(droneDto.getLongitude());
    drone.setModel(droneDto.getModel());
    drone.setActive(droneDto.getActive());
    repository.persist(drone);
    return drone;
  }

  @Transactional
  public DroneEntity atualizar(DroneDto droneDto, Long id) {
    DroneEntity drone = repository.findById(id);
    drone.setAlias(droneDto.getAlias());
    drone.setBrandName(droneDto.getAlias());
    drone.setDelivery(droneDto.getDelivery());
    drone.setLatitude(droneDto.getLatitude());
    drone.setLongitude(droneDto.getLongitude());
    drone.setModel(droneDto.getModel());
    drone.setActive(droneDto.getActive());
    repository.persist(drone);
    return drone;
  }

  @Transactional
  public void deletar(Long id) {
    repository.deleteById(id);
  }
}