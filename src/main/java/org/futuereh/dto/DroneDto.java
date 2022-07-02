package org.futuereh.dto;

import org.futuereh.entity.DroneEntity;

public class DroneDto {
  
  private String alias;

  private String brandName;

  private String model;

  private Float latitude;

  private Float longitude;

  private Boolean active;

  private DeliveryEntity delivery;

  public String getAlias() {
    return alias;
  }

  public void setAlias(String alias) {
    this.alias = alias;
  }

  public String getBrandName() {
    return brandName;
  }

  public void setBrandName(String brandName) {
    this.brandName = brandName;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public Float getLatitude() {
    return latitude;
  }

  public void setLatitude(Float latitude) {
    this.latitude = latitude;
  }

  public Float getLongitude() {
    return longitude;
  }

  public void setLongitude(Float longitude) {
    this.longitude = longitude;
  }

  public Boolean getActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }

  public DeliveryEntity getDelivery() {
    return delivery;
  }

  public void setDelivery(DeliveryEntity delivery) {
    this.delivery = delivery;
  }

}
