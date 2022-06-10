package com.example.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private  final ProductDAO<ProductResponse> productDAO;
    @Autowired
    public ProductService(@Qualifier("FakeProductDB") ProductDAO<ProductResponse> productDAO) {
        this.productDAO = productDAO;
    }

   
    public ProductResponse newProduct(Product product) {
        return productDAO.newProduct(product);
    }

   
    public ProductResponse updateProduct(Product product) {
        return productDAO.updateProduct(product);
    }

   
    public ProductResponse deleteProduct(Integer id) {
        return productDAO.deleteProduct(id);
    }

   
    public ProductResponse getAllProducts() {
        return productDAO.getAllProducts();
    }

   
    public ProductResponse getOneProduct(Integer id) {
        return productDAO.getOneProduct(id);
    }

   
    public ProductResponse sellProduct(SellProductRequest request) {
        return productDAO.sellProduct(request);
    }
}
