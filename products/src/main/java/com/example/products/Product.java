package com.example.products;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {
    @JsonProperty("name") String productName;
    @JsonProperty("quantity") Integer quantity;
    @JsonProperty("price") Double price;
    @JsonProperty("new") Boolean newP;
    @JsonProperty("id") Integer id;
    @JsonProperty("sold") Boolean sold;

    public Product(String productName, Integer quantity, Double price, Boolean newP, Integer id, Boolean sold) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.newP = newP;
        this.id = id;
        this.sold = sold;
    }

    public String getProductName() {
        return productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }

    public Boolean getNewP() {
        return newP;
    }

    public Integer getId() {
        return id;
    }

    public Boolean getSold() {
        return sold;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setNewP(Boolean newP) {
        this.newP = newP;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSold(Boolean sold) {
        this.sold = sold;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", newP=" + newP +
                ", id=" + id +
                ", sold=" + sold +
                '}';
    }
}
