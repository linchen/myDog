package com.mydog.core.events.Orders;

import java.util.Date;

/**
 * Created by Lin on 21.04.14.
 */
public class OrderStatusDetails {

    private Date statusDate;
    private String status;

    public OrderStatusDetails(Date statusDate, String status) {
        this.statusDate = statusDate;
        this.status = status;
    }

    public Date getStatusDate() {
        return statusDate;
    }

    public String getStatus() {
        return status;
    }
}
