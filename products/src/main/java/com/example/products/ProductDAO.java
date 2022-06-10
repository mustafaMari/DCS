package com.example.products;

public interface ProductDAO<R> {
    R newProduct(Product product);
    R updateProduct(Product product);
    R deleteProduct(Integer id);
    R getAllProducts();
    R getOneProduct(Integer id);
    R sellProduct(SellProductRequest request);

}
