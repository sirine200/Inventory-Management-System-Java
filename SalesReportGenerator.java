package JavaProject;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class SalesReportGenerator {

    public static void generateSalesReport(List<SalesTransaction> salesTransactions) {
        if (salesTransactions.isEmpty()) {
            System.out.println("No sales transactions to generate a report.");
            return;
        }

        double totalSalesValue = 0;
        int totalQuantity = 0;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        System.out.println("----- Sales Report -----");
        System.out.println("Date          | Product Name        | Quantity | Price Per Unit | Total Value");

        for (SalesTransaction transaction : salesTransactions) {
            Date date = transaction.getDate();
            String productName = transaction.getProduct().getName();
            int quantity = transaction.getQuantity();
            double price = transaction.getPrice();
            double totalValue = quantity * price;

            totalSalesValue += totalValue;
            totalQuantity += quantity;

            System.out.printf("%s | %-20s | %-8d | $%-14.2f | $%-11.2f%n",
                    dateFormat.format(date), productName, quantity, price, totalValue);
        }

        double averagePricePerUnit = totalSalesValue / totalQuantity;

        System.out.println("------------------------------------------------------");
        System.out.printf("Total Sales Value: $%.2f%n", totalSalesValue);
        System.out.printf("Total Quantity Sold: %d units%n", totalQuantity);
        System.out.printf("Average Price Per Unit: $%.2f%n", averagePricePerUnit);
        System.out.println("------------------------------------------------------");
    }

    public static void generatePurchaseReport(List<PurchaseTransaction> purchaseTransactions) {
        if (purchaseTransactions.isEmpty()) {
            System.out.println("No purchase transactions to generate a report.");
            return;
        }

        double totalPurchaseValue = 0;
        int totalQuantity = 0;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        System.out.println("----- Purchase Report -----");
        System.out.println("Date          | Product Name        | Quantity | Price Per Unit | Total Value");

        for (PurchaseTransaction transaction : purchaseTransactions) {
            Date date = transaction.getDate();
            String productName = transaction.getProduct().getName();
            int quantity = transaction.getQuantity();
            double price = transaction.getPrice();
            double totalValue = quantity * price;

            totalPurchaseValue += totalValue;
            totalQuantity += quantity;

            System.out.printf("%s | %-20s | %-8d | $%-14.2f | $%-11.2f%n",
                    dateFormat.format(date), productName, quantity, price, totalValue);
        }

        System.out.println("------------------------------------------------------");
        System.out.printf("Total Purchase Value: $%.2f%n", totalPurchaseValue);
        System.out.printf("Total Quantity Purchased: %d units%n", totalQuantity);
        System.out.println("------------------------------------------------------");
    }

    public void displayBasicSalesStatistics(List<SalesTransaction> salesTransactions) {
        displayTotalSales(salesTransactions);
        displayBestSellingProducts(salesTransactions);
        displaySalesTrendsOverTime(salesTransactions);
    }

    public void displayTotalSales(List<SalesTransaction> salesTransactions) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        double totalSales = calculateTotalSales(salesTransactions);

        System.out.println("=== Total Sales ===");
        System.out.println("Total Sales: $" + decimalFormat.format(totalSales));
    }

    public double calculateTotalSales(List<SalesTransaction> salesTransactions) {
        double totalSales = 0;
        for (SalesTransaction transaction : salesTransactions) {
            totalSales += transaction.getProduct().getPrice() * transaction.getQuantity();
        }
        return totalSales;
    }

    public void displayBestSellingProducts(List<SalesTransaction> salesTransactions) {
        Map<Product, Integer> popularProducts = getPopularProducts(salesTransactions, 3);

        System.out.println("\nBest Selling Products:");
        for (Map.Entry<Product, Integer> entry : popularProducts.entrySet()) {
            System.out.println(entry.getKey().getName() + ": " + entry.getValue() + " units");
        }
    }

    private Map<Product, Integer> getPopularProducts(List<SalesTransaction> salesTransactions, int count) {
        Map<Product, Double> productSalesMap = new HashMap<>();

        // Calculate total sales for each product
        for (SalesTransaction transaction : salesTransactions) {
            Product product = transaction.getProduct();
            double totalSalesValue = product.getPrice() * transaction.getQuantity();

            // Accumulate total sales value for each product
            if (productSalesMap.containsKey(product)) {
                double currentSales = productSalesMap.get(product);
                productSalesMap.put(product, currentSales + totalSalesValue);
            } else {
                productSalesMap.put(product, totalSalesValue);
            }
        }

        // Sort products by total sales value
        List<Map.Entry<Product, Double>> sortedProducts = new ArrayList<>(productSalesMap.entrySet());
        sortedProducts.sort((p1, p2) -> Double.compare(p2.getValue(), p1.getValue()));

        // Retrieve top 'count' products based on sales value
        Map<Product, Integer> popularProducts = new LinkedHashMap<>();
        for (int i = 0; i < count && i < sortedProducts.size(); i++) {
            Map.Entry<Product, Double> entry = sortedProducts.get(i);
            popularProducts.put(entry.getKey(), (int) (entry.getValue() / entry.getKey().getPrice()));
        }

        return popularProducts;
    }

    public void displaySalesTrendsOverTime(List<SalesTransaction> salesTransactions) {
        // Create a map to store sales totals by month or year
        Map<String, Double> salesByTime = new HashMap<>();

        // Group sales transactions by month or year
        for (SalesTransaction transaction : salesTransactions) {
            // Extract month or year from the transaction date (modify this based on your date format)
            String timePeriod = extractMonthOrYear(transaction.getDate());

            // Calculate total sales for each time period
            double totalSales = transaction.getProduct().getPrice() * transaction.getQuantity();
            salesByTime.put(timePeriod, salesByTime.getOrDefault(timePeriod, 0.0) + totalSales);
        }

        // Display sales totals by month or year
        for (Map.Entry<String, Double> entry : salesByTime.entrySet()) {
            System.out.println("Time Period: " + entry.getKey() + ", Total Sales: $" + entry.getValue());
        }
    }

    // Helper method to extract month or year from date (modify based on date format)
    private String extractMonthOrYear(Date date) {
        // Example: Extract year (modify this based on your date format)
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        return String.valueOf(year);
    }
    
    public String generateReport(List<SalesTransaction> salesTransactions) {
        StringBuilder report = new StringBuilder();

        // Generating total sales report
        report.append("=== Total Sales ===\n");
        double totalSales = calculateTotalSales(salesTransactions);
        report.append("Total Sales: $").append(String.format("%.2f", totalSales)).append("\n\n");

        // Generating best-selling products report
        Map<Product, Integer> popularProducts = getPopularProducts(salesTransactions, 3);
        report.append("Best Selling Products:\n");
        for (Map.Entry<Product, Integer> entry : popularProducts.entrySet()) {
            report.append(entry.getKey().getName()).append(": ").append(entry.getValue()).append(" units\n");
        }
        report.append("\n");

        // Generating sales trends over time report
        Map<String, Double> salesByTime = new HashMap<>();
        for (SalesTransaction transaction : salesTransactions) {
            String timePeriod = extractMonthOrYear(transaction.getDate());
            double totalSalesForPeriod = transaction.getProduct().getPrice() * transaction.getQuantity();
            salesByTime.put(timePeriod, salesByTime.getOrDefault(timePeriod, 0.0) + totalSalesForPeriod);
        }
        report.append("Sales Trends Over Time:\n");
        for (Map.Entry<String, Double> entry : salesByTime.entrySet()) {
            report.append("Time Period: ").append(entry.getKey()).append(", Total Sales: $").append(entry.getValue()).append("\n");
        }

        return report.toString();
    }

}
