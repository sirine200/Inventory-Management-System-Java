package JavaProject;

import java.text.SimpleDateFormat;
import java.util.Date;

class PurchaseTransaction {
    private Product product;
    private int quantity;
    private double price;
    private Date date;

    // Format for date: yyyy-MM-dd
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public PurchaseTransaction(Product product, int quantity, double price, Date date) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
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


    public Date getDate() {
        return date;
    }
    
    public String getFormattedDate() {
        return dateFormat.format(date);
    }
    
    @Override
    public String toString() {
        return "PurchaseTransaction{" +
                "product=" + product.getName() + // Assuming Product has a 'getName()' method
                ", quantity=" + quantity +
                ", price=" + price +
                ", date=" + getFormattedDate() + // Using the formatted date
                '}';
    }
}