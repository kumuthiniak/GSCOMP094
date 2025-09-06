package com.example.demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
public class Item {

    @Id
    private String itemCode;
    private Double unitPrice;
    private LocalDate updatedDate;

    public Item() {}

    public Item(String itemCode, Double unitPrice, LocalDate updatedDate) {
        this.itemCode = itemCode;
        this.unitPrice = unitPrice;
        this.updatedDate = updatedDate;
    }

    // Getters and setters
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
