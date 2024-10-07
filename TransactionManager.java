package JavaProject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionManager {
    private List<SalesTransaction> salesTransactions;
    private List<PurchaseTransaction> purchaseTransactions;
    private InventoryManager inventoryManager;
    
    public TransactionManager() {
        this.salesTransactions = new ArrayList<>();
        this.purchaseTransactions = new ArrayList<>();
        this.inventoryManager = new InventoryManager();
    }
    
    public List<SalesTransaction> getSalesHistory() {
        return new ArrayList<>(salesTransactions);
    }

    public List<PurchaseTransaction> getPurchaseHistory() {
        return new ArrayList<>(purchaseTransactions);
    }
    
    public void updateInventory(Product product, int quantitySold) {
        // Assuming products is a list of products in the InventoryManager class
        for (Product p : InventoryManager.products) {
            if (p.getName().equals(product.getName())) {
                int updatedQuantity = p.getQuantity() - quantitySold;
                p.setQuantity(updatedQuantity);
                // Assuming you want to store this change in transaction history
                SalesTransaction transaction = new SalesTransaction(product, quantitySold, product.getPrice(), product.getCategory(), new Date());
                salesTransactions.add(transaction); // Storing the transaction in the sales history
                return;
            }
        }
        // If the product is not found in the inventory
        System.out.println("Product not found in inventory.");
    }
    
    public void addSalesTransaction(SalesTransaction sale) {
        salesTransactions.add(sale);
    }
    public List<SalesTransaction> getSalesTransactions() {
        return salesTransactions;
    }

    public void addPurchaseTransaction(PurchaseTransaction purchase) {
        purchaseTransactions.add(purchase);
    }

    public List<PurchaseTransaction> getPurchaseTransactions() {
        return purchaseTransactions;
    }
}
