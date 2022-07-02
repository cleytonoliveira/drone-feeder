package org.futuereh.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.futuereh.entity.DroneEntity;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DroneRepository implements PanacheRepositoryBase<DroneEntity, Long> {
}