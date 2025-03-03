package com.example.jsonmover.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Setter;


@Embeddable
public class Fees {

    @Column(name = "cleaning_fee")
    private String cleaning;

    @Column(name = "baking_fee")
    private String baking;

    @Column(name = "commission_fee")
    private String commission;

    public String getCleaning() {
        return cleaning;
    }

    public void setCleaning(String cleaning) {
        this.cleaning = cleaning;
    }

    public String getBaking() {
        return baking;
    }

    public void setBaking(String baking) {
        this.baking = baking;
    }

    public String getCommission() {
        return commission;
    }

    public void setCommission(String commission) {
        this.commission = commission;
    }
}