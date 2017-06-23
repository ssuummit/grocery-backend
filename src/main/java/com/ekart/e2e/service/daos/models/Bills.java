package com.ekart.e2e.service.daos.models;

public class Bills {
  private Long orderid;
  private String ordercontent;
  private java.sql.Timestamp date;
  private Long restaurantid;

  public Long getOrderid() {
    return orderid;
  }

  public void setOrderid(Long orderid) {
    this.orderid = orderid;
  }

  public String getOrdercontent() {
    return ordercontent;
  }

  public void setOrdercontent(String ordercontent) {
    this.ordercontent = ordercontent;
  }

  public java.sql.Timestamp getDate() {
    return date;
  }

  public void setDate(java.sql.Timestamp date) {
    this.date = date;
  }

  public Long getRestaurantid() {
    return restaurantid;
  }

  public void setRestaurantid(Long restaurantid) {
    this.restaurantid = restaurantid;
  }
}
