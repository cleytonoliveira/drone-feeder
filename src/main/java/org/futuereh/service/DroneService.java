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
  public DroneEntity salvar(DroneDto restDto) {
    DroneEntity drone = new DroneEntity();
    drone.setAlias(restDto.getAlias());
    drone.setBrandName(restDto.getAlias());
    drone.setDelivery(restDto.getDelivery());
    drone.setLatitude(restDto.getLatitude());
    drone.setLongitude(restDto.getLongitude());
    drone.setModel(restDto.getModel());
    drone.setActive(restDto.getActive());
    repository.persist(drone);
    return drone;
  }

  @Transactional
  public DroneEntity atualizar(DroneDto restDto, Long id) {
    DroneEntity drone = repository.findById(id);
    drone.setAlias(restDto.getAlias());
    drone.setBrandName(restDto.getAlias());
    drone.setDelivery(restDto.getDelivery());
    drone.setLatitude(restDto.getLatitude());
    drone.setLongitude(restDto.getLongitude());
    drone.setModel(restDto.getModel());
    drone.setActive(restDto.getActive());
    repository.persist(drone);
    return drone;
  }

  @Transactional
  public void deletar(Long id) {
    repository.deleteById(id);
  }
}