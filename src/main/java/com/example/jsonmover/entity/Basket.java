package com.example.jsonmover.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;



@Entity
@Table(name = "basket")
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "beans", nullable = false)
    private int beans;

    @Column(name = "apples", nullable = false)
    private int apples;

    @Column(name = "oranges", nullable = false)
    private int oranges;

    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "ratio", nullable = false)
    private double ratio;

    @Embedded
    private Fees fees;

    @ElementCollection
    @CollectionTable(name = "basket_descriptors", joinColumns = @JoinColumn(name = "basket_id"))
    @Column(name = "descriptor")
    private List<String> descriptors;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getBeans() {
        return beans;
    }

    public void setBeans(int beans) {
        this.beans = beans;
    }

    public int getApples() {
        return apples;
    }

    public void setApples(int apples) {
        this.apples = apples;
    }

    public int getOranges() {
        return oranges;
    }

    public void setOranges(int oranges) {
        this.oranges = oranges;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

    public Fees getFees() {
        return fees;
    }

    public void setFees(Fees fees) {
        this.fees = fees;
    }

    public List<String> getDescriptors() {
        return descriptors;
    }

    public void setDescriptors(List<String> descriptors) {
        this.descriptors = descriptors;
    }

    public Basket() {
    }

    public Basket(String type, int beans, int apples, int oranges, String brand, double ratio, Fees fees, List<String> descriptors) {
        this.type = type;
        this.beans = beans;
        this.apples = apples;
        this.oranges = oranges;
        this.brand = brand;
        this.ratio = ratio;
        this.fees = fees;
        this.descriptors = descriptors;
    }
}