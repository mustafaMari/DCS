package com.example.products;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SellProductRequest {
    @JsonProperty("productId") Integer id;
    @JsonProperty("quantity") Integer quantity;

    public SellProductRequest(Integer id, Integer quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "SellProductRequest{" +
                "id=" + id +
                ", quantity=" + quantity +
                '}';
    }
}
