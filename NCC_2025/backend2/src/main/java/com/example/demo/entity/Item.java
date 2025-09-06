package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @Column(name = "item_code")
    private String itemCode;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "unit_price")
    private Double unitPrice;

    @Column(name = "update_date")
    private LocalDate updatedDate;

    public Item() {}

    public Item(String itemCode, String itemName, Double unitPrice, LocalDate updatedDate) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.unitPrice = unitPrice;
        this.updatedDate = updatedDate;
    }

    @PrePersist
    protected void onCreate() {
        if (this.updatedDate == null) {
            this.updatedDate = LocalDate.now();
        }
    }

    // Getters and Setters
    public String getItemCode() { 
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public LocalDate getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDate updatedDate) {
        this.updatedDate = updatedDate;
    }
}