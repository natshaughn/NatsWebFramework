package utility;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class CSVReader {

    public Map<String, String> readCSV(String filePath) {
        Map<String, String> productPrices = new HashMap<>();

        try (Reader reader = new FileReader(filePath)) {
            Iterable<CSVRecord> records = CSVFormat.DEFAULT
                    .withFirstRecordAsHeader()
                    .parse(reader);

            for (CSVRecord record : records) {
                String product = record.get("product");
                String price = record.get("price");
                productPrices.put(product, price);
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to read CSV file");
        }

        return productPrices;
    }
}
