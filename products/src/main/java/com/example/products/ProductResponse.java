package com.example.products;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ProductResponse {
    @JsonProperty("statusCode") Integer code;
    @JsonProperty("message") String message;

    public ProductResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return "ProductResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
class GetAll extends ProductResponse{
    @JsonProperty("products") List<Product> products;

    public GetAll(Integer code, String message, List<Product> products) {
        super(code, message);
        this.products = products;
    }

    @Override
    public String toString() {
        return "GetAll{" +
                "products=" + products +
                ", code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
class getOne extends ProductResponse{
    @JsonProperty("product") Product product;

    public getOne(Integer code, String message, Product product) {
        super(code, message);
        this.product = product;
    }

    @Override
    public String toString() {
        return "getOne{" +
                "product=" + product +
                ", code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
