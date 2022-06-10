package com.example.products;

import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.annotation.WebFilter;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("product-service/products")
@RestController
@WebFilter
public class ProductAPI  {
    private final ProductService productService;

    @Autowired
    public ProductAPI(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(
            path = "new-product",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ProductResponse newProduct(@RequestBody Product product) {
        return productService.newProduct(product);
    }

    @PostMapping (
            path = "update-product",
            consumes = {"application/json"},
            produces = {"application/json"}
    )
    public ProductResponse updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

//   @DeleteMapping(
//           path = "{product-id}",
//           produces = {MediaType.APPLICATION_JSON_VALUE}
//   )
    @GetMapping(
            path = "delete/{product-id}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ProductResponse deleteProduct(@PathVariable("product-id") Integer id) {
        return productService.deleteProduct(id);
    }

    @GetMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ProductResponse getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping(
            path = "{product-id}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ProductResponse getOneProduct(@PathVariable("product-id") Integer id) {
        return productService.getOneProduct(id);
    }

   @PostMapping(
           path = "sell-product",
           consumes = {MediaType.APPLICATION_JSON_VALUE},
           produces = {MediaType.APPLICATION_JSON_VALUE}
   )
    public ProductResponse sellProduct(@RequestBody SellProductRequest request) {
       System.out.println("sekk: " + request);
        return productService.sellProduct(request);
    }
}
