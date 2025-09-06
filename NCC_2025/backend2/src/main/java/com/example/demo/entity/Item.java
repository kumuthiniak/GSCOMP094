package com.example.demo.entity;
import java.time.LocalDate;

public class Item {


    private String itemCode;

    private Double unitPrice;

    private LocalDate updatedDate;

    // Constructors
    public Item() {}

    public Item(String itemCode, Double unitPrice, LocalDate updatedDate) {
        this.itemCode = itemCode;
        this.unitPrice = unitPrice;
        this.updatedDate = updatedDate;
    }


    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
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
