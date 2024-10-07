package JavaProject;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestProject {
    public static void main(String args[]) {
        // Creating instances
        Scanner scanner = new Scanner(System.in);
        InventoryManager inventoryManager = new InventoryManager();
        AuthenticationSystem authSystem = new AuthenticationSystem();
        List<Product> products = new ArrayList<>();
        PdfExporter pdfExporter = new PdfExporter();
       
        TransactionManager transactionManager = new TransactionManager();
        SalesReportGenerator salesReportGenerator = new SalesReportGenerator();
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        
        SalesEntry salesEntry = new SalesEntry(transactionManager);
        
        // Adding products using the addProduct method
        inventoryManager.addProduct("Smartphone", 10, 500, "Electronics");
        inventoryManager.addProduct("Laptop", 5, 1200, "Electronics");
        inventoryManager.addProduct("Headphones", 20, 80, "Electronics");

        // Add users to authenticationSystem
        User user1 = new User("Ahmed", "123");
        authSystem.addUser(user1);

        // User Authentication
        System.out.println("Enter the username:");
        String userName = scanner.nextLine();
        System.out.println("Enter the password:");
        String password = scanner.nextLine();

        boolean isAuthenticated = authSystem.authenticate(userName, password);

        if (isAuthenticated) {
            System.out.println("Authentication successful! Access granted.");
            System.out.println("Welcome to the Sales System!");
            
         // Display the menu
            while (true) {
                System.out.println("\nChoose an option:");
                System.out.println("1. Product Management");
                System.out.println("2. Inventory Management");
                System.out.println("3. Sales Entry");
                System.out.println("4. Transaction Logging");
                System.out.println("5. Sales Reporting");
                System.out.println("6. File Manager");
                System.out.println("7. Export to PDF");
                System.out.println("8. Exit");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                    	TextUserInterface.manageProducts();
                        break;
                    case 2:
                    	TextUserInterface.manageInventory();
                        break;
                    case 3:
                    	TextUserInterface.manageSalesEntry(inventoryManager, salesEntry, transactionManager);
                        break;
                    case 4:
                    	TextUserInterface.transactionLogging(transactionManager);
                    	break;
                    case 5:
                    	TextUserInterface.manageSalesReporting(salesReportGenerator, transactionManager);
                        break;
                    case 6:
                    	TextUserInterface.executeFileManagerOptions(inventoryManager, salesEntry);
                    	break;
                    case 7:       
                        pdfExporter.exportToPdf(salesEntry, "SalesReport.pdf");
                        System.out.println("Sales report exported to SalesReport.pdf");
                        break;
                    case 8:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        } 
        
        else {
            System.out.println("Authentication failed! Access denied.");
        }
    }
}