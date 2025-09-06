package com.example.demo.entity;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Item {


    private String itemCode;

    private String itemName;

    private Double unitPrice;

    private LocalDate updatedDate;

    // Constructors
    public Item() {}

    public Item(String itemCode, Double unitPrice, LocalDate updatedDate,String itemName) {
        this.itemCode = itemCode;
        this.unitPrice = unitPrice;
        this.updatedDate = updatedDate;
        this.itemName=itemName;
    }


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
