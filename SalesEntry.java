package JavaProject;
import java.util.Date;
import java.util.List;

public class SalesEntry {
    private TransactionManager transactionManager;

    public SalesEntry(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    // Record a Sale
    public void recordSale(Product product, int quantity, double price, String category, Date date) {
        SalesTransaction sale = new SalesTransaction(product, quantity, price, category, date);
        transactionManager.addSalesTransaction(sale);
    }

    // Record a Purchase
    public void recordPurchase(Product product, int quantity, double price, Date date) {
        PurchaseTransaction purchase = new PurchaseTransaction(product, quantity, price, date);
        transactionManager.addPurchaseTransaction(purchase);
    }
    
    public List<SalesTransaction> getSalesTransactions() {
        return transactionManager.getSalesTransactions();
    }

    public List<PurchaseTransaction> getPurchaseTransactions() {
        return transactionManager.getPurchaseTransactions();
    }
   
}