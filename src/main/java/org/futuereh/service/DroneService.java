package org.futuereh.service;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.futuereh.dto.DroneDto;
import org.futuereh.entity.DroneEntity;
import org.futuereh.repository.DroneRepository;

@ApplicationScoped
public class DroneService {

  /**
   * Attributes.
   */
  @Inject
  private DroneRepository repository;

  /**
   * Method to list all drones.
   * @return List
   */
  public List<DroneEntity> listAll() {
    return repository.listAll();
  }

  /**
   * Method to list drone by id.
   * @param id Long
   * @return DroneEntity
   */
  public DroneEntity findById(Long id) {
    return repository.findById(id);
  }

  /**
   * Method to register a new drone.
   * @param droneDto DroneDto
   * @return DroneEntity
   */
  @Transactional
  public DroneEntity save(DroneDto droneDto) {
    DroneEntity drone = new DroneEntity();
    drone.setAlias(droneDto.getAlias());
    drone.setBrandName(droneDto.getBrandName());
    drone.setDelivery(droneDto.getDelivery());
    drone.setLatitude(droneDto.getLatitude());
    drone.setLongitude(droneDto.getLongitude());
    drone.setModel(droneDto.getModel());
    drone.setActive(droneDto.getActive());
    repository.persist(drone);
    return drone;
  }

  /**
   * Method to update all information about drone.
   * @param droneDto DroneDto
   * @param id Long
   * @return
   */
  @Transactional
  public DroneEntity update(DroneDto droneDto, Long id) {
    DroneEntity drone = repository.findById(id);
    drone.setAlias(droneDto.getAlias());
    drone.setBrandName(droneDto.getBrandName());
    drone.setDelivery(droneDto.getDelivery());
    drone.setLatitude(droneDto.getLatitude());
    drone.setLongitude(droneDto.getLongitude());
    drone.setModel(droneDto.getModel());
    drone.setActive(droneDto.getActive());
    repository.persist(drone);
    return drone;
  }

  /**
   * Method to delete some drone.
   * @param id Long
   */
  @Transactional
  public void delete(Long id) {
    repository.deleteById(id);
  }
}