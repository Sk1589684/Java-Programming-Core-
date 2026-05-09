package com.demo.dao;

import com.demo.model.Product;
import java.util.Collection;
import java.util.HashMap;

public class ProductDao {
    
    // Our filing cabinet is a HashMap. It uses the ID Number as the label on the folder!
    private HashMap<Integer, Product> productDatabase = new HashMap<>();

    // Put a new product into the cabinet
    public void saveProduct(Product product) {
        productDatabase.put(product.getProductId(), product);
    }

    // Throw a product folder out of the cabinet
    public void deleteProduct(int productId) {
        productDatabase.remove(productId);
    }

    // Grab ALL the products from the cabinet
    public Collection<Product> getAllProducts() {
        return productDatabase.values(); // Hand over just the products, not the ID labels
    }

    // Dig through the cabinet to find one specific product using its ID
    public Product getProductById(int productId) {
        // HashMap instantly grabs the product without having to search one by one!
        return productDatabase.get(productId); 
    }
}