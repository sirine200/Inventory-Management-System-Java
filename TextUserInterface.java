package JavaProject;
import java.util.*;
import java.text.DecimalFormat;
import java.util.List;

public class TextUserInterface {
		
	    public static void manageProducts() {
	        List<Product> products = new ArrayList<>(); 
	        Scanner scanner = new Scanner(System.in);
	        
	        while (true) {
	            System.out.println("\nChoose an option:");
	            System.out.println("1. Add Product");
	            System.out.println("2. Update a product");
	            System.out.println("3. Delete a product");
	            System.out.println("4. Product Availability");
	            System.out.println("5. Exit");

	            int choice1 = scanner.nextInt();
	            scanner.nextLine(); // Consume the newline character

	            switch (choice1) {
	                case 1:
	                    System.out.println("Enter product name:");
	                    String name = scanner.nextLine();

	                    System.out.println("Enter quantity:");
	                    int quantity = scanner.nextInt();

	                    System.out.println("Enter price:");
	                    double price = scanner.nextDouble();
	                    scanner.nextLine(); // Consume the newline character

	                    System.out.println("Enter category:");
	                    String category = scanner.nextLine();

	                    // Creating a product using user input
	                    Product newProduct = new Product(name, quantity, price, category);
	                    products.add(newProduct);
	                    break;

	                case 2:
	                	// Get product details from the user
                        System.out.print("Enter product name: ");
                        String ProductToBeUpdatedname = scanner.nextLine();
                        

                        boolean productExists = false;

                        for (Product product : products) {
                            if (product.getName().equalsIgnoreCase(ProductToBeUpdatedname)) {
                                productExists = true;

                                // Display current product details
                                System.out.println("Current Product Details:");
                                product.displayProductInfo();

                                // Get updated product details from the user
                                System.out.println("Enter updated product details:");

                                System.out.print("Enter updated quantity: ");
                                int updatedQuantity = scanner.nextInt();
                                product.setQuantity(updatedQuantity);

                                System.out.print("Enter updated price: ");
                                double updatedPrice = scanner.nextDouble();
                                product.setPrice(updatedPrice);

                                scanner.nextLine(); // Consume newline character

                                System.out.print("Enter updated category: ");
                                String updatedCategory = scanner.nextLine();
                                product.setCategory(updatedCategory);

                                System.out.println("Product updated successfully:");
                                product.displayProductInfo();

                                break;
                            }
                        }

                        if (!productExists) {
                            System.out.println("Product with name '" + ProductToBeUpdatedname + "' does not exist.");
                        }
                        break;


	                case 3:
	                	// Get product details from the user
                        System.out.print("Enter product name to be deleted: ");
                        String ProductToBeDeletedName = scanner.nextLine();
                        boolean productFound = false;
                        for (Product product : products) {
                            if (product.getName().equalsIgnoreCase(ProductToBeDeletedName)) {
                                productFound = true;
                                product.deleteProduct();
                                System.out.println("Product '" + ProductToBeDeletedName + "' has been deleted.");
                                break;
                            }
                        }

                        if (!productFound) {
                            System.out.println("Product with name '" + ProductToBeDeletedName + "' does not exist.");
                        }
                        break;
	                    

	                case 4:
	                	System.out.print("Enter the name of the product to check stock: ");
                    	String productName = scanner.nextLine();

                    	boolean ProductFound = false;
                    	for (Product product : products) {
                    	    if (product.getName().equalsIgnoreCase(productName)) {
                    	    	ProductFound = true;
                    	        if (product.isInStock()) {
                    	            System.out.println("Product '" + productName + "' is in stock.");
                    	        } else {
                    	            System.out.println("Product '" + productName + "' is out of stock.");
                    	        }
                    	        break;
                    	    }
                    	}

                    	if (!ProductFound) {
                    	    System.out.println("Product with name '" + productName + "' does not exist.");
                    	}
	                    break;

	                case 5:
	                	 System.out.println("Exiting...");
	                    return;

	                default:
	                    System.out.println("Invalid option. Please try again.");
	            }
	        }
	    }

	    public static void manageInventory() {
	        Scanner scanner = new Scanner(System.in);
	        InventoryManager inventoryManager = new InventoryManager(); // Assuming InventoryManager instance is available

	        while (true) {
	            System.out.println("\nInventory Management:");
	            System.out.println("1. Add Product");
	            System.out.println("2. Update Product");
	            System.out.println("3. Product Availability");
	            System.out.println("4. List Products");
	            System.out.println("5. Inventory Report");
	            System.out.println("6. Exit");

	            int inventoryChoice = scanner.nextInt();
	            scanner.nextLine(); // Consume newline character

	            switch (inventoryChoice) {
	                case 1:
	                    // Add Product
	                    System.out.print("Enter product name: ");
	                    String addProductName = scanner.nextLine();

	                    System.out.print("Enter quantity: ");
	                    int addProductQuantity = scanner.nextInt();
	                    scanner.nextLine(); // Consume newline character

	                    System.out.print("Enter price: ");
	                    double addProductPrice = scanner.nextDouble();
	                    scanner.nextLine(); // Consume newline character

	                    System.out.print("Enter category: ");
	                    String addProductCategory = scanner.nextLine();

	                    System.out.println(inventoryManager.addProduct(addProductName, addProductQuantity, addProductPrice, addProductCategory));
	                    break;

	                case 2:
	                	// Update Product
                        System.out.print("Enter product name to update: ");
                        String updateProductName = scanner.nextLine();

                        // Get new product details from the user
                        System.out.print("Enter updated quantity (or press Enter to skip): ");
                        String updateQuantityInput = scanner.nextLine();
                        Integer updateProductQuantity = updateQuantityInput.isEmpty() ? null : Integer.parseInt(updateQuantityInput);

                        System.out.print("Enter updated price (or press Enter to skip): ");
                        String updatePriceInput = scanner.nextLine();
                        Double updateProductPrice = updatePriceInput.isEmpty() ? null : Double.parseDouble(updatePriceInput);

                        System.out.print("Enter updated category (or press Enter to skip): ");
                        String updateProductCategory = scanner.nextLine();

                        System.out.println(inventoryManager.updateProduct(updateProductName, updateProductQuantity, updateProductPrice, updateProductCategory));
                        
	                    break;

	                case 3:
	                	// Product Availability
                        System.out.print("Enter product name: ");
                        String availabilityProductName = scanner.nextLine();

                        System.out.print("Enter desired quantity: ");
                        int desiredQuantity = scanner.nextInt();
                        scanner.nextLine(); // Consume newline character

                        System.out.println(inventoryManager.checkProductAvailability(availabilityProductName, desiredQuantity));
	                    break;

	                case 4:
	                	 // List Products
                        System.out.print("Enter category (or press Enter to list all): ");
                        String listProductCategory = scanner.nextLine();

                        List<String> productList = inventoryManager.listProducts(listProductCategory);
                        for (String productInfo : productList) {
                            System.out.println(productInfo);
                        }
	                    break;

	                case 5:
	                	System.out.println(inventoryManager.generateInventoryReport());
	                    break;

	                case 6:
	                    System.out.println("Exiting...");
	                    return;

	                default:
	                    System.out.println("Invalid option. Please try again.");
	            }
	        }
	       }

	    public static void manageSalesEntry(InventoryManager inventoryManager, SalesEntry salesEntry, TransactionManager transactionManager) {
	        Scanner scanner = new Scanner(System.in);
	        while (true) {
	            System.out.println("\nSales Entry:");
	            System.out.println("1. Record Sale");
	            System.out.println("2. Record Purchase");
	            System.out.println("3. Exit");

	            int salesEntryChoice = scanner.nextInt();
	            scanner.nextLine(); // Consume newline character

	            switch (salesEntryChoice) {
	                case 1:
	                    // Record Sale
	                    System.out.print("Enter product name: ");
	                    String saleProductName = scanner.nextLine();

	                    System.out.print("Enter quantity sold: ");
	                    int saleQuantity = scanner.nextInt();
	                    scanner.nextLine(); // Consume newline character

	                    System.out.print("Enter sale price: ");
	                    double salePrice = scanner.nextDouble();
	                    scanner.nextLine(); // Consume newline character

	                    System.out.print("Enter sale category In-Store Sale// Online Sale: ");
	                    String saleCategory = scanner.nextLine();

	                    // Assuming you have a getProductByName method in your InventoryManager class
	                    Product saleProduct = inventoryManager.getProductByName(saleProductName);

	                    if (saleProduct != null && saleProduct.isInStock()) {
	                        // Record sale in SalesEntry
	                        salesEntry.recordSale(saleProduct, saleQuantity, salePrice, saleCategory, new Date());
	                        // Update inventory
	                        transactionManager.updateInventory(saleProduct, saleQuantity);
	                        System.out.println("Sale recorded successfully!");
	                    } else {
	                        System.out.println("Product not found or out of stock.");
	                    }
	                    break;

	                case 2:
	                    // Record Purchase
	                    System.out.print("Enter product name: ");
	                    String purchaseProductName = scanner.nextLine();

	                    System.out.print("Enter quantity purchased: ");
	                    int purchaseQuantity = scanner.nextInt();
	                    scanner.nextLine(); // Consume newline character

	                    System.out.print("Enter purchase price: ");
	                    double purchasePrice = scanner.nextDouble();
	                    scanner.nextLine(); // Consume newline character

	         

	                    // Assuming you have a getProductByName method in your InventoryManager class
	                    Product purchaseProduct = inventoryManager.getProductByName(purchaseProductName);

	                    if (purchaseProduct != null) {
	                        // Record purchase in SalesEntry
	                        salesEntry.recordPurchase(purchaseProduct, purchaseQuantity, purchasePrice, new Date());
	                        // Update inventory
	                        transactionManager.updateInventory(purchaseProduct, -(purchaseQuantity));
	                        System.out.println("Purchase recorded successfully!");
	                    } else {
	                        System.out.println("Product not found.");
	                    }
	                    break;

	                case 3:
	                    System.out.println("Exiting...");
	                    return;

	                default:
	                    System.out.println("Invalid option. Please try again.");
	            }
	        }
	    }
        
	    public static void manageSalesReporting(SalesReportGenerator salesReportGenerator, TransactionManager transactionManager) {
	        Scanner scanner = new Scanner(System.in);
	        
	        while (true) {
	            System.out.println("\nSales Reporting:");
	            System.out.println("1. Generate Sales Report");
	            System.out.println("2. Generate Purchase Report");
	            System.out.println("3. Display Basic Sales Statistics");
	            System.out.println("4. Display Total Sales");
	            System.out.println("5. Display Best Selling Products");
	            System.out.println("6. Display Sales Trends Over Time");
	            System.out.println("7. Exit");

	            int reportingChoice = scanner.nextInt();
	            scanner.nextLine(); // Consume newline character

	            switch (reportingChoice) {
	                case 1:
	                    // Generate Sales Report
	                	SalesReportGenerator.generateSalesReport(transactionManager.getSalesHistory());

	                    break;

	                case 2:
	                    // Generate Purchase Report
	                
	                    SalesReportGenerator.generatePurchaseReport(transactionManager.getPurchaseHistory());

	                    break;

	                case 3:
	                    // Display Basic Sales Statistics
	                    salesReportGenerator.displayBasicSalesStatistics(transactionManager.getSalesHistory());
	                    break;

	                case 4:
	                    // Display Total Sales
	                    DecimalFormat decimalFormat = new DecimalFormat("#.##");
	                    double totalSales = salesReportGenerator.calculateTotalSales(transactionManager.getSalesHistory());
	                    System.out.println("=== Total Sales ===");
	                    System.out.println("Total Sales: $" + decimalFormat.format(totalSales));
	                    break;

	                case 5:
	                    // Display Best Selling Products
	                    salesReportGenerator.displayBestSellingProducts(transactionManager.getSalesHistory());
	                    break;

	                case 6:
	                    // Display Sales Trends Over Time
	                    salesReportGenerator.displaySalesTrendsOverTime(transactionManager.getSalesHistory());
	                    break;

	                case 7:
	                    System.out.println("Exiting...");
	                    return;

	                default:
	                    System.out.println("Invalid option. Please try again.");
	            }
	        }
	    }

	    public static void transactionLogging(TransactionManager transactionManager) {
	        Scanner scanner = new Scanner(System.in);

	        while (true) {
	            System.out.println("Choose an option:");
	            System.out.println("1. View Sales History");
	            System.out.println("2. View Purchase History");
	            System.out.println("3. Exit");

	            int choice = scanner.nextInt();
	            scanner.nextLine(); // Consume newline character

	            switch (choice) {
	                case 1:
	                    List<SalesTransaction> salesHistory = transactionManager.getSalesHistory();
	                    System.out.println("Sales History:");
	                    for (SalesTransaction sale : salesHistory) {
	                        System.out.println(sale.getProduct().getName() + " - Quantity: " + sale.getQuantity() + " - Price: " + sale.getPrice());
	                    }
	                    break;

	                case 2:
	                    List<PurchaseTransaction> purchaseHistory = transactionManager.getPurchaseHistory();
	                    System.out.println("Purchase History:");
	                    for (PurchaseTransaction purchase : purchaseHistory) {
	                        System.out.println(purchase.getProduct().getName() + " - Quantity: " + purchase.getQuantity() + " - Price: " + purchase.getPrice());
	                    }
	                    break;

	                case 3:
	                    System.out.println("Exiting...");
	                    return;

	                default:
	                    System.out.println("Invalid option. Please try again.");
	                    break;
	            }
	        }
	    }
	  
	    public static void executeFileManagerOptions(InventoryManager inventoryManager, SalesEntry salesEntry) {
	        Scanner scanner = new Scanner(System.in);     
	        TransactionManager transactionManager = new TransactionManager();
	        while (true) {
	            System.out.println("Choose an option:");
	            System.out.println("1. Write Inventory Data to File");
	            System.out.println("2. Write Sales Transactions to File");
	            System.out.println("3. Write Purchase Transactions to File");
	            System.out.println("4. Read Inventory Data from File");
	            System.out.println("5. Read Sales Transactions from File");
	            System.out.println("6. Read Purchase Transactions from File");
	            System.out.println("7. Exit");

	            String input = scanner.nextLine(); // Read the entire line

	            try {
	                int choice = Integer.parseInt(input);

	                switch (choice) {
	                    case 1:
	                        // Assuming you have an inventory list named 'inventoryList' and a file path
	                        List<Product> inventoryList = inventoryManager.getInventoryList();
	                        FileManager.writeInventoryToFile(inventoryList, "inventory.txt");
	                        break;

	                    case 2:
	                        // Assuming you have a way to create an instance of TransactionManager
	                        List<SalesTransaction> salesTransactions = salesEntry.getSalesTransactions();
	                        FileManager.writeSalesToFile(transactionManager, salesTransactions, "sales.txt");
	                        break;


	                    case 3:
	                        List<PurchaseTransaction> purchaseTransactions = salesEntry.getPurchaseTransactions();
	                        FileManager.writePurchasesToFile(transactionManager, purchaseTransactions, "purchases.txt");
	                        break;

	                    case 4:
	                        FileManager.readInventoryFile("inventory.txt");
	                        break;

	                    case 5:
	                        FileManager.readSalesFile("sales.txt");
	                        break;

	                    case 6:
	                        FileManager.readPurchasesFile("purchases.txt");
	                        break;

	                    case 7:
	                        System.out.println("Exiting...");
	                        return;

	                    default:
	                        System.out.println("Invalid option. Please try again.");
	                        break;
	                }
	            } catch (NumberFormatException e) {
	                System.out.println("Invalid input. Please enter a number.");
	            }
	        }
	    }

 
}

 
        
        
        
        
        
       
        

    
	
