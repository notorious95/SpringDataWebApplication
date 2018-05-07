package com.dziura.patryk.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * This class describe Soft
 * Include all attributes with setters and getters
 */
@Entity
public class Soft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String description;
    private String technology;
    private String owner;

    /**
     * Set of Contracts
     * It is filled through assign specific Soft to Contract
     */
    @OneToMany(mappedBy = "soft")
    private Set<Contract> contracts = new HashSet();

    public Soft(String name, String description, String technology, String owner) {
        this.name = name;
        this.description = description;
        this.technology = technology;
        this.owner = owner;
    }

    public Soft() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }
}
