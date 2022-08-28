package com.nz.entity;

import java.util.ArrayList;
import java.util.List;

public class Discount {

    private Integer discount = 0;

    private List<String> message = new ArrayList<String>();

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public void addMessage(String message) {
        this.message.add(message);
    }

    public List<String> getMessage() {
        return this.message;
    }
}
