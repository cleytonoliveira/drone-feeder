package org.futuereh.service;

import org.futuereh.dto.DeliveryDto;
import org.futuereh.entity.DeliveryEntity;
import org.futuereh.repository.DeliveryRepository;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class DeliveryService {

  /**
   * Attributes
   */
  @Inject
  private DeliveryRepository repository;

  /**
   * Methods.
   */
  public List<DeliveryEntity> listAll() {
    return repository.listAll();
  }

  public DeliveryEntity findById(Long id) {
    return repository.findById(id);
  }

  @Transactional
  public DeliveryEntity save(DeliveryDto deliveryDto) {
    DeliveryEntity delivery = new DeliveryEntity();
    delivery.setWithdrawalDate(deliveryDto.getWithdrawalDate());
    delivery.setDeliveryDate(deliveryDto.getDeliveryDate());
    delivery.setStatus(deliveryDto.getStatus());
    repository.persist(delivery);
    return delivery;
  }

  @Transactional
  public DeliveryEntity update(DeliveryDto deliveryDto, Long id) {
    DeliveryEntity delivery = repository.findById(id);
    delivery.setWithdrawalDate(deliveryDto.getWithdrawalDate());
    delivery.setDeliveryDate(deliveryDto.getDeliveryDate());
    delivery.setStatus(deliveryDto.getStatus());
    repository.persist(delivery);
    return delivery;
  }

  @Transactional
  public void delete(Long id) {
    repository.deleteById(id);
  }
}