package com.example.jsonmover.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Setter;

@Setter
@Embeddable
public class Fees {

    @Column(name = "cleaning_fee")
    private String cleaning;

    @Column(name = "baking_fee")
    private String baking;

    @Column(name = "commission_fee")
    private String commission;


}