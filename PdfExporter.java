package JavaProject;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class PdfExporter {

    public void exportToPdf(SalesEntry salesEntry, String filePath) {
        try {
            List<SalesTransaction> salesTransactionsList = salesEntry.getSalesTransactions();

            if (salesTransactionsList != null) {
                SalesReportGenerator reportGenerator = new SalesReportGenerator(); // Assuming SalesReportGenerator creation logic

                String salesReport = reportGenerator.generateReport(salesTransactionsList);

                FileOutputStream outputStream = new FileOutputStream(filePath);
                outputStream.write(salesReport.getBytes(StandardCharsets.UTF_8));
                outputStream.close();

                System.out.println("PDF exported successfully to: " + filePath);
            } else {
                System.out.println("No sales transactions available.");
            }
        } catch (IOException e) {
            System.err.println("Error exporting PDF: " + e.getMessage());
        }
    }
}
