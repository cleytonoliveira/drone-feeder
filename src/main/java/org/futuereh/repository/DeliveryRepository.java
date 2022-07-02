package org.futuereh.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.futuereh.entity.DeliveryEntity;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DeliveryRepository implements PanacheRepositoryBase<DeliveryEntity, Long> {
}