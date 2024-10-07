package JavaProject;
import java.io.*;
import java.util.List;

public class FileManager {

    public static void writeInventoryToFile(List<Product> inventory, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Name,Quantity,Price,Category\n"); // Header with newline
            for (Product product : inventory) {
                String line = String.format("%s,%d,%.2f,%s\n",
                        product.getName(), product.getQuantity(), product.getPrice(), product.getCategory());
                writer.write(line);
            }
            System.out.println("Inventory data has been written to the file successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }

    public static void writeSalesToFile(TransactionManager transactionManager, List<SalesTransaction> salesTransactions, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (SalesTransaction transaction : salesTransactions) {
                writer.write(transaction.toString());  // Assuming SalesTransaction has a toString() method
                writer.newLine();  // Add a newline after each transaction
            }

            System.out.println("Sales Transactions written to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void writePurchasesToFile(TransactionManager transactionManager, List<PurchaseTransaction> purchaseTransactions, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (PurchaseTransaction transaction : purchaseTransactions) {
                writer.write(transaction.toString() + "\n"); // Assuming proper toString() method
                writer.newLine();
            }
            System.out.println("Purchases Transactions written to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readSalesFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Process each line or output as needed
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readPurchasesFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Process each line or output as needed
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readInventoryFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Process each line or output as needed
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
