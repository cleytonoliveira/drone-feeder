package org.futuereh.dto;

import java.time.LocalDateTime;

public class DeliveryDto {
  
  /**
   * Attributes.
   */
  private LocalDateTime withdrawalDate;

  private LocalDateTime deliveryDate;

  private Boolean status;

  /**
   * Methods.
   * @return
   */
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
