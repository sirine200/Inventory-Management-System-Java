package JavaProject;

import java.util.Objects;

class Product {
    private String name;
    private int quantity;
    private double price;
    private String category;

    public Product(String name, int quantity, double price, String category) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.category = category;
    }

    // Getters and setters for attributes
    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int newQuantity) {
        this.quantity = newQuantity;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double newPrice) {
        this.price = newPrice;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String newCategory) {
        this.category = newCategory;
    }

    // Method for updating quantities
    public void updateQuantity(int newQuantity) {
        this.quantity = newQuantity;
    }

    public void deleteProduct() {
        this.name = "Deleted Product";
        this.quantity = 0;
        this.price = 0.0;
        this.category = "incategorized";
    }

    // Method to check if the product is in stock
    public boolean isInStock() {
        return this.quantity > 0;
    }

    // Method to display product information
    public void displayProductInfo() {
        System.out.println("Product: " + this.name);
        System.out.println("Category: " + this.category);
        System.out.println("Quantity: " + this.quantity);
        System.out.println("Price: " + this.price);
    }

    // Override toString() method to represent the object as a string
    @Override
    public String toString() {
        return "Product: " + this.name + ", Category: " + this.category + ", Quantity: " + this.quantity + ", Price: " + this.price;
    }

    // Override equals() and hashCode() methods for object comparison
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return quantity == product.quantity &&
                Double.compare(product.price, price) == 0 &&
                Objects.equals(name, product.name) &&
                Objects.equals(category, product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, quantity, price, category);
    }
}
