package org.futuereh.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import javax.enterprise.context.ApplicationScoped;
import org.futuereh.entity.DroneEntity;

@ApplicationScoped
public class DroneRepository implements PanacheRepositoryBase<DroneEntity, Long> {
}
