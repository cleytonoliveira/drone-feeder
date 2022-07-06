package org.futuereh.service;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.futuereh.dto.DeliveryDto;
import org.futuereh.entity.DeliveryEntity;
import org.futuereh.repository.DeliveryRepository;

@ApplicationScoped
public class DeliveryService {

  /**
   * Attributes.
   */
  @Inject
  private DeliveryRepository repository;

  /**
   * Method to list all deliveries.
   * @return List
   */
  public List<DeliveryEntity> listAll() {
    return repository.listAll();
  }

  /**
   * Method to find delivery by id.
   * @param id Long
   * @return DeliveryEntity
   */
  public DeliveryEntity findById(Long id) {
    return repository.findById(id);
  }

  /**
   * Method to register a new delivery.
   * @param deliveryDto DeliveryDto
   * @return DeliveryEntity
   */
  @Transactional
  public DeliveryEntity save(DeliveryDto deliveryDto) {
    DeliveryEntity delivery = new DeliveryEntity();
    delivery.setWithdrawalDate(deliveryDto.getWithdrawalDate());
    delivery.setDeliveryDate(deliveryDto.getDeliveryDate());
    delivery.setStatus(deliveryDto.getStatus());
    repository.persist(delivery);
    return delivery;
  }

  /**
   * Method to update all information about delivery.
   * @param deliveryDto DeliveryDto
   * @param id Long
   * @return DeliveryEntity
   */
  @Transactional
  public DeliveryEntity update(DeliveryDto deliveryDto, Long id) {
    DeliveryEntity delivery = repository.findById(id);
    delivery.setWithdrawalDate(deliveryDto.getWithdrawalDate());
    delivery.setDeliveryDate(deliveryDto.getDeliveryDate());
    delivery.setStatus(deliveryDto.getStatus());
    repository.persist(delivery);
    return delivery;
  }

  /**
   * Method to delete some delivery.
   * @param id Long
   */
  @Transactional
  public void delete(Long id) {
    repository.deleteById(id);
  }
}