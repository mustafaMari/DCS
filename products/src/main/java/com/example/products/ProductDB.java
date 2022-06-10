package com.example.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository("FakeProductDB")
public class ProductDB implements ProductDAO<ProductResponse> {
    static List<Product> products = new ArrayList<>();

    @Autowired
    public ProductDB() {
        products.add(new Product("iPhone", 20, 200.0, true, 1, false));
        products.add(new Product("Mac", 10, 250.0, true, 2, false));
        products.add(new Product("iPhone", 20, 200.0, true, 3, true));
        products.add(new Product("iPhone", 20, 200.0, true, 4, false));
        products.add(new Product("iPhone", 20, 200.0, true, 5, true));
        products.add(new Product("iPhone", 20, 200.0, true, 6, false));
    }

    @Override
    public ProductResponse newProduct(Product product) {
        System.out.println("new product" + product);
        try {
            if (product == null) {
                return new ProductResponse(
                        204,
                        "Product's values are missing"
                );
            }
            if (duplicateId(product.getId())) {
                return new ProductResponse(
                        205,
                        "Provided Id already Exists"
                );
            }
            if (invalidInputs(product)) {
                return new ProductResponse(
                        205,
                        "Provided inputs are invalid"
                );
            }
            products.add(product);
            return new ProductResponse(
                    201,
                    "product created successfully"
            );
        } catch (Exception e) {
            return new ProductResponse(
                    306,
                    e.getMessage()
            );
        }

    }

    private boolean duplicateId(Integer id) {
        return getProduct(id) != -1;
    }

    private int getProduct(Integer id) {
        for (int i = 0; i < products.size(); i++) {
            if (Objects.equals(products.get(i).id, id)) {
                return i;
            }
        }
        return -1;
    }

    private boolean invalidInputs(Product product) {
        return product.getPrice() < 1.0 || product.getId() < 1 || product.getQuantity() < 1;
    }

    @Override
    public ProductResponse updateProduct(Product product) {
        try {
            int index = getProduct(product.id);
            if (index != -1) {
                products.set(index, product);
                return new ProductResponse(
                        200,
                        "product updated successfully"
                );
            } else {
                return new ProductResponse(
                        205,
                        "Product Id does not exists"
                );
            }
        } catch (Exception e) {
            return new ProductResponse(
                    306,
                    e.getMessage()
            );
        }
    }

    @Override
    public ProductResponse deleteProduct(Integer id) {
        try {
            int index = getProduct(id);
            if (index != -1) {
                products.remove(index);
                return new ProductResponse(
                        200,
                        "product deleted successfully"
                );
            } else {
                return new ProductResponse(
                        205,
                        "Product Id does not exists"
                );
            }
        } catch (Exception e) {
            return new ProductResponse(
                    306,
                    e.getMessage()
            );
        }
    }

    @Override
    public ProductResponse getAllProducts() {
        try {
            return new GetAll(
                    200,
                    "products retrieved",
                    products
            );
        } catch (Exception e) {
            return new ProductResponse(
                    306,
                    e.getMessage()
            );
        }

    }

    @Override
    public ProductResponse getOneProduct(Integer id) {
        try {
            int index = getProduct(id);
            if (index != -1) {
                return new getOne(
                        200,
                        "product retrieved",
                        products.get(index)
                );
            } else {
                return new ProductResponse(
                        205,
                        "Product Id does not exists"
                );
            }
        } catch (Exception e) {
            return new ProductResponse(
                    306,
                    e.getMessage()
            );
        }
    }

    @Override
    public ProductResponse sellProduct(SellProductRequest request) {
        try{
            int index = getProduct(request.id);
            if(index != -1){
                Product product = products.get(index);
                if (product.getQuantity() < request.quantity){
                    return new ProductResponse(
                            204,
                            "requested quantity is larger than provided"
                    );
                }else{
                    int sold = product.getQuantity() - request.quantity;
                    product.setQuantity(sold);
                    if (sold == 0){
                        product.setSold(true);
                    }
                    products.set(index, product);
                    return new ProductResponse(
                            200,
                            "product sold"
                    );
                }
            }else {
                return new ProductResponse(
                        205,
                        "Product Id does not exists"
                );
            }
        }catch (Exception e){
            return new ProductResponse(
                    306,
                    e.getMessage()
            );
        }

    }
}
