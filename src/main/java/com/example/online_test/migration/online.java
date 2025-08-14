package com.example.online_test.migration;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "data") 
public class online {
    @Id
    private int id;

    private String productID;
    private String productName;
    private double amount;
    private String customerName;
    private int status;
    private LocalDateTime transactionDate;
    private String createBy;
    private LocalDateTime createOn;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getProductID() { return productID; }
    public void setProductID(String productID) { this.productID = productID; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public int getStatus() { return status; }
    public void setStatus(int status) { this.status = status; }

    public LocalDateTime getTransactionDate() { return transactionDate; }
    public void setTransactionDate(LocalDateTime transactionDate) { this.transactionDate = transactionDate; }

    public String getCreateBy() { return createBy; }
    public void setCreateBy(String createBy) { this.createBy = createBy; }

    public LocalDateTime getCreateOn() { return createOn; }
    public void setCreateOn(LocalDateTime createOn) { this.createOn = createOn; }
}
