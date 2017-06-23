package com.my.db;

public class Inventory {
  private Long inventoryid;
  private String inventoryname;
  private Double priceperunit;
  private Double estimatedavailableqty;
  private Double estiamtedorderqty;
  private Double minreserveqty;
  private Double maxstorageqty;
  private Long restaurantid;

  public Long getInventoryid() {
    return inventoryid;
  }

  public void setInventoryid(Long inventoryid) {
    this.inventoryid = inventoryid;
  }

  public String getInventoryname() {
    return inventoryname;
  }

  public void setInventoryname(String inventoryname) {
    this.inventoryname = inventoryname;
  }

  public Double getPriceperunit() {
    return priceperunit;
  }

  public void setPriceperunit(Double priceperunit) {
    this.priceperunit = priceperunit;
  }

  public Double getEstimatedavailableqty() {
    return estimatedavailableqty;
  }

  public void setEstimatedavailableqty(Double estimatedavailableqty) {
    this.estimatedavailableqty = estimatedavailableqty;
  }

  public Double getEstiamtedorderqty() {
    return estiamtedorderqty;
  }

  public void setEstiamtedorderqty(Double estiamtedorderqty) {
    this.estiamtedorderqty = estiamtedorderqty;
  }

  public Double getMinreserveqty() {
    return minreserveqty;
  }

  public void setMinreserveqty(Double minreserveqty) {
    this.minreserveqty = minreserveqty;
  }

  public Double getMaxstorageqty() {
    return maxstorageqty;
  }

  public void setMaxstorageqty(Double maxstorageqty) {
    this.maxstorageqty = maxstorageqty;
  }

  public Long getRestaurantid() {
    return restaurantid;
  }

  public void setRestaurantid(Long restaurantid) {
    this.restaurantid = restaurantid;
  }
}
