package com.demo.service;

import com.demo.dao.ProductDao;
import com.demo.model.ElectronicProduct;
import com.demo.model.GroceryProduct;
import com.demo.model.Product;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ProductService {
    
    // The Manager connects to the Filing Cabinet
    private ProductDao dao = new ProductDao();

    // a. Add new product
    public void addProduct(Product product) {
        dao.saveProduct(product);
        System.out.println("Success: Product added to the store!");
    }

    // b. Remove product
    public void removeProduct(int productId) {
        Product product = dao.getProductById(productId); // Look for it
        if (product != null) {
            dao.deleteProduct(productId); // Throw it away
            System.out.println("Success: Product removed!");
        } else {
            System.out.println("Error: Cannot find that product ID.");
        }
    }

    // c. Update product price and quantity
    public void updatePriceAndQuantity(int productId, double newPrice, int newQuantity) {
        Product product = dao.getProductById(productId);
        if (product != null) {
            product.setPrice(newPrice);       // Change the price
            product.setQuantity(newQuantity); // Change the stock
            System.out.println("Success: Price and Quantity updated!");
        } else {
            System.out.println("Error: Cannot find that product ID.");
        }
    }

    // d. Mark product unavailable
    public void markUnavailable(int productId) {
        Product product = dao.getProductById(productId);
        if (product != null) {
            product.setStatus("Unavailable");
            System.out.println("Success: Product is now marked as Unavailable.");
        } else {
            System.out.println("Error: Cannot find that product ID.");
        }
    }

    // e. Purchase product based on type and price range
    public void purchaseProduct(String type, double minPrice, double maxPrice) {
        boolean purchased = false;
        System.out.println("--- Looking for " + type + " products between $" + minPrice + " and $" + maxPrice + " ---");
        
        for (Product product : dao.getAllProducts()) {
            // Rule 1: Check if the product is actually available and in stock
            if (product.getStatus().equals("Available") && product.getQuantity() > 0) {
                // Rule 2: Does it fit the budget?
                if (product.getPrice() >= minPrice && product.getPrice() <= maxPrice) {
                    
                    // If they want Electronic and it is Electronic...
                    if (type.equalsIgnoreCase("Electronic") && product instanceof ElectronicProduct) {
                        product.setQuantity(product.getQuantity() - 1); // Reduce stock by 1
                        System.out.println("Successfully Purchased: " + product.getProductName());
                        purchased = true;
                    } 
                    // If they want Grocery and it is Grocery...
                    else if (type.equalsIgnoreCase("Grocery") && product instanceof GroceryProduct) {
                        product.setQuantity(product.getQuantity() - 1); // Reduce stock by 1
                        System.out.println("Successfully Purchased: " + product.getProductName());
                        purchased = true;
                    }
                }
            }
        }
        if (!purchased) System.out.println("Sorry, no available products match that type and budget.");
    }

    // f. Display all products
    public void displayAllProducts() {
        if (dao.getAllProducts().isEmpty()) {
            System.out.println("No products in the store yet.");
            return;
        }
        for (Product product : dao.getAllProducts()) {
            System.out.println(product.toString());
        }
    }

    // g. Display products by type
    public void displayByType(String type) {
        boolean found = false;
        for (Product product : dao.getAllProducts()) {
            if (type.equalsIgnoreCase("Electronic") && product instanceof ElectronicProduct) {
                System.out.println(product.toString());
                found = true;
            } else if (type.equalsIgnoreCase("Grocery") && product instanceof GroceryProduct) {
                System.out.println(product.toString());
                found = true;
            }
        }
        if (!found) System.out.println("No products found for type: " + type);
    }

    // h. Display products with quantity less than a given value
    public void displayLowStock(int minQuantity) {
        boolean found = false;
        for (Product product : dao.getAllProducts()) {
            if (product.getQuantity() < minQuantity) {
                System.out.println(product.toString());
                found = true;
            }
        }
        if (!found) System.out.println("No products have stock lower than " + minQuantity);
    }

    // i. Sort products by price
    public void sortProductsByPrice() {
        // HashMaps are completely unorganized. Put them in a temporary list so we can sort them!
        ArrayList<Product> listToSort = new ArrayList<>(dao.getAllProducts());
        
        if (listToSort.isEmpty()) {
            System.out.println("No products to sort.");
            return;
        }

        Collections.sort(listToSort, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return Double.compare(p1.getPrice(), p2.getPrice());
            }
        });

        System.out.println("--- Products Sorted by Price (Cheapest First) ---");
        for (Product product : listToSort) {
            System.out.println(product.toString());
        }
    }

    // j. Search product by name
    public void searchByName(String searchName) {
        boolean found = false;
        for (Product product : dao.getAllProducts()) {
            // Check if the typed letters are part of the product's name
            if (product.getProductName().toLowerCase().contains(searchName.toLowerCase())) {
                System.out.println("Found: " + product.toString());
                found = true;
            }
        }
        if (!found) System.out.println("Sorry, couldn't find a product with that name.");
    }
}
