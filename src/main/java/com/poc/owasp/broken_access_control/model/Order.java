package com.poc.owasp.broken_access_control.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    private Long id;

    // CWE-862
    // Authorization-sensitive attribute
    private String createdBy;

    public Order() {}

    public Order(Long id, String createdBy) {
        this.id = id;
        this.createdBy = createdBy;
    }

    public Long getId() {
        return id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}