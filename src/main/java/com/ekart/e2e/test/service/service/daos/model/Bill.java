package com.ekart.e2e.test.service.service.daos.model;

/**
 * Created by hemantj on 23/06/17.
 */
public class Bill {

    public Bill() {
    }

    private String restrauntId;

    private long orderId;

    private Object menuDetails;

    public String getrId() {
        return restrauntId;
    }

    public long getoId() {
        return orderId;
    }

    public void setoId(long oId) {
        this.orderId = oId;
    }

    public Object getMenuDetails() {
        return menuDetails;
    }

    public void setMenuDetails(Object menuDetails) {
        this.menuDetails = menuDetails;
    }

    public void setrId(String rId) {
        this.restrauntId = rId;

    }

    public Bill(String rId, long oId, Object menuDetails) {
        this.restrauntId = rId;
        this.orderId = oId;

        this.menuDetails = menuDetails;
    }


    @Override
    public String toString() {
        return "Bill [orderId=" + orderId + ", restrauntId=" + restrauntId + ", menuDetails=" + menuDetails
                + "]";
    }
}
