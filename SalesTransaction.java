package JavaProject;

import java.text.SimpleDateFormat;
import java.util.Date;

class SalesTransaction {
    private Product product;
    private int quantity;
    private double price;
    private String category;
    private Date date;

    // Format for date: yyyy-MM-dd
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public SalesTransaction(Product product, int quantity, double price, String category, Date date) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.category = category;
        this.date = date;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public Date getDate() {
        return date;
    }
    public String getFormattedDate() {
        return dateFormat.format(date);
    }
    
    @Override
    public String toString() {
        return "SalesTransaction{" +
                "product=" + product.getName() + // Assuming Product has a 'getName()' method
                ", quantity=" + quantity +
                ", price=" + price +
                ", sale category='" + category + '\'' +
                ", date=" + getFormattedDate() + // Using the formatted date
                '}';
    }
    
   
}