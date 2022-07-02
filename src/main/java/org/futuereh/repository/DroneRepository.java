package org.futuereh.repository;

import org.futuereh.entity.DroneEntity;

import javax.enterprise.context.ApplicationScoped;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class DroneRepository implements PanacheRepositoryBase<DroneEntity, Long> {
}
