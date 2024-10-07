package JavaProject;
import java.util.*;

public class InventoryManager {
    static List<Product> products = new ArrayList<>();
    
    // Method to add a new product to the inventory
    public String addProduct(String name, int quantity, double price, String category) {
        Product newProduct = new Product(name, quantity, price, category);
        products.add(newProduct);
        return "Product added successfully. " + newProduct.toString();
    }
    
 // Method to update an existing product in the inventory
    public String updateProduct(String productName, Integer quantity, Double price, String category) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(productName)) {
                if (quantity != null) {
                    product.setQuantity(quantity);
                } else {
                    // If quantity is null or not provided, retain the old value
                    quantity = product.getQuantity();
                }
                
                if (price != null) {
                    product.setPrice(price);
                } else {
                    // If price is null or not provided, retain the old value
                    price = product.getPrice();
                }
                
                // Update the category only if the new category value is not empty
                if (category != null && !category.trim().isEmpty()) {
                    product.setCategory(category);
                }

                return "Product updated successfully. " + product.toString();
            }
        }
        return "Product with name \"" + productName + "\" not found.";
    }



    // Method to check product availability
    public String checkProductAvailability(String productName, int desiredQuantity) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(productName)) {
                int availableQuantity = product.getQuantity();
                if (availableQuantity >= desiredQuantity) {
                    return "Product is available. Available quantity: " + availableQuantity;
                } else {
                    return "Insufficient quantity. Available quantity: " + availableQuantity;
                }
            }
        }
        return "Product with name \"" + productName + "\" not found.";
    }

    /// Method to list products in the inventory
    public List<String> listProducts(String category) {
        List<String> productList = new ArrayList<>();

        if (category == null) {
            // If category is null, list all products
            for (Product product : products) {
                productList.add(product.toString());
            }
        } else {
            // If a specific category is provided, list products in that category
            for (Product product : products) {
                if (product.getCategory().equalsIgnoreCase(category)) {
                    productList.add(product.toString());
                }
            }
        }

        if (productList.isEmpty()) {
            productList.add("No products found.");
        }

        return productList;
    }
    
    public int getProductQuantity(Product product) {
        for (Product p : products) {
            if (p.equals(product)) {
                return p.getQuantity();
            }
        }
        // Return 0 if the product is not found
        return 0;
    }
    
    public void updateProductQuantity(Product product, int newQuantity) {
        for (Product p : products) {
            if (p.getName().equals(product.getName())) {
                
                p.setQuantity(newQuantity);
                break;
            }
        }
    }
    
    public Product getProductByName(String productName) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(productName)) {
                return product;
            }
        }
        return null; // Product not found
    }
    
    public List<Product> getInventoryList() {
        return products;
    }
    
    public String generateInventoryReport() {
        StringBuilder report = new StringBuilder("Inventory Report:\n");
        double totalValue = 0.0;

        for (Product product : products) {
            report.append(product.toString()).append("\n");
            totalValue += product.getPrice() * product.getQuantity(); // Calculate total value for each product
        }

        report.append("Total Inventory Value: $").append(totalValue); // Append total value to the report
        return report.toString();
    }
}
