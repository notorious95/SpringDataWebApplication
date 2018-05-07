package com.dziura.patryk.model;

import javax.persistence.*;
import java.math.BigInteger;

/**
 * This class describe Contract
 * Include all attributes with setters and getters
 */
@Entity
public class Contract {
    @Id
    @TableGenerator(name = "contractGenerator", initialValue = 1000)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "contractGenerator")
    private long id;

    private String number;
    private String startDate;
    private String endDate;
    private double incomes;
    private String scale;
    private String status;

    /**
     * Instance of Soft
     */
    @ManyToOne
    private Soft soft;

    /**
     * Variable that helps with specify Soft to assign to Contract
     * This field will be not saving to database
     */
    @Transient
    private int softId;

    public Contract(String number, String startDate, String endDate, double incomes, String scale, String status) {
        this.number = number;
        this.startDate = startDate;
        this.endDate = endDate;
        this.incomes = incomes;
        this.scale = scale;
        this.status = status;
    }

    public Contract() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getIncomes() {
        return incomes;
    }

    public void setIncomes(double incomes) {
        this.incomes = incomes;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Soft getSoft() {
        return soft;
    }

    public void setSoft(Soft soft) {
        this.soft = soft;
    }

    public int getSoftId() {
        return softId;
    }

    public void setSoftId(int softId) {
        this.softId = softId;
    }
}
