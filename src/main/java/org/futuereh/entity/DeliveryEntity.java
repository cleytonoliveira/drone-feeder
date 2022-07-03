package org.futuereh.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class DeliveryEntity {

  /**
   * Attributes
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long deliveryId;

  @Column
  private LocalDateTime withdrawalDate;

  @Column
  private LocalDateTime deliveryDate;

  @Column
  private Boolean status;

  /**
   * Methods
   */
  public Long getDeliveryId() {
    return deliveryId;
  }

  public void setDeliveryId(Long deliveryId) {
    this.deliveryId = deliveryId;
  }

  public LocalDateTime getWithdrawalDate() {
    return withdrawalDate;
  }

  public void setWithdrawalDate(LocalDateTime withdrawalDate) {
    this.withdrawalDate = withdrawalDate;
  }

  public LocalDateTime getDeliveryDate() {
    return deliveryDate;
  }

  public void setDeliveryDate(LocalDateTime deliveryDate) {
    this.deliveryDate = deliveryDate;
  }

  public Boolean getStatus() {
    return status;
  }

  public void setStatus(Boolean status) {
    this.status = status;
  }
}
