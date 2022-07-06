package org.futuereh.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import javax.enterprise.context.ApplicationScoped;
import org.futuereh.entity.DeliveryEntity;

@ApplicationScoped
public class DeliveryRepository implements PanacheRepositoryBase<DeliveryEntity, Long> {
}