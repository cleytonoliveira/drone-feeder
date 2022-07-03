package org.futuereh.entity;

import javax.persistence.*;

@Entity
public class DroneEntity {

  /**
   * Attributes
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long droneId;

  @Column
  private String alias;

  @Column
  private String brandName;

  @Column
  private String model;

  @Column
  private Float latitude;

  @Column
  private Float longitude;

  @Column
  private Boolean active;

  @OneToOne (fetch = FetchType.LAZY)
  @JoinColumn(name = "deliveryId")
  private DeliveryEntity delivery;

  /**
   * Methods
   */
  public Long getDroneId() {
    return droneId;
  }

  public void setDroneId(Long droneId) {
    this.droneId = droneId;
  }

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
