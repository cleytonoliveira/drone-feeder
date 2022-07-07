package org.futuereh.service;

import java.time.LocalDateTime;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.futuereh.dto.DroneDto;
import org.futuereh.entity.DeliveryEntity;
import org.futuereh.entity.DroneEntity;
import org.futuereh.repository.DeliveryRepository;
import org.futuereh.repository.DroneRepository;
import org.futuereh.result.LocationResult;

@ApplicationScoped
public class DroneService {

  /**
   * Attributes.
   */
  @Inject
  private DroneRepository repository;

  @Inject
  private DeliveryRepository deliveryRepository;

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
   * @return DroneEntity
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
   * Method to withdrawal drone.
   * @param droneDto DroneDto
   * @param id Long
   * @return DroneEntity
   */
  @Transactional
  public DroneEntity withdrawal(DroneDto droneDto, Long id, Long deliveryId) {
    DeliveryEntity delivery = deliveryRepository.findById(deliveryId);
    delivery.setWithdrawalDate(LocalDateTime.now());
    delivery.setStatus(true);

    DroneEntity drone = repository.findById(id);
    drone.setDelivery(delivery);
    drone.setLatitude(droneDto.getLatitude());
    drone.setLongitude(droneDto.getLongitude());
    drone.setActive(true);
    repository.persist(drone);
    return drone;
  }

  /**
   * Method to delivery drone.
   * @param droneDto DroneDto
   * @param id Long
   * @return DroneEntity
   */
  @Transactional
  public DroneEntity delivery(DroneDto droneDto, Long id, Long deliveryId) {
    DeliveryEntity delivery = deliveryRepository.findById(deliveryId);
    delivery.setDeliveryDate(LocalDateTime.now());
    delivery.setStatus(false);

    DroneEntity drone = repository.findById(id);
    drone.setDelivery(delivery);
    drone.setLatitude(droneDto.getLatitude());
    drone.setLongitude(droneDto.getLongitude());
    repository.persist(drone);
    return drone;
  }

  /**
   * Method to maps drone.
   * @param droneDto DroneDto
   * @param id Long
   * @return DroneEntity
   */
  @Transactional
  public DroneEntity maps(DroneDto droneDto, Long id, Long deliveryId) {
    DeliveryEntity delivery = deliveryRepository.findById(deliveryId);

    DroneEntity drone = repository.findById(id);
    drone.setDelivery(delivery);
    drone.setLatitude(droneDto.getLatitude());
    drone.setLongitude(droneDto.getLongitude());
    repository.persist(drone);
    return drone;
  }

  /**
   * Method to deactivate drone.
   * @param id Long
   * @return DroneEntity
   */
  @Transactional
  public DroneEntity deactivate(Long id) {
    DroneEntity drone = repository.findById(id);
    drone.setDelivery(null);
    drone.setActive(false);
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

  /**
   * Method to get drone location.
   * @param id Long
   * @return LocationResult
   */
  public LocationResult getLocation(Long id) {
    DroneEntity drone = repository.findById(id);

    return new LocationResult(drone.getLatitude(), drone.getLongitude());
  }
}