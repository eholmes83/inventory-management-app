package org.example.service;

import org.example.domain.Product;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    private static CSVReader csvReader = null;

    private CSVReader() {}

    public static CSVReader getInstance() {
        if (csvReader == null) {
            csvReader = new CSVReader();
        }
        return csvReader;
    }

    public void readProductsFromFile(Path filePath) {

        try {
            // Read data in
            List<String> data = Files.readAllLines(filePath);
            ArrayList<Product> products = new ArrayList<Product>();

            // Do something with the data
            data
                .stream()
                .skip(1)
                .forEach((String lineOfData) -> {
                    Product product = new Product();
                    String[] productData = lineOfData.split(",");

                    product.setId(Integer.parseInt(productData[0]));
                    product.setName(productData[1]);
                    product.setQuantity(Integer.parseInt(productData[2]));
                    product.setPrice(Double.parseDouble(productData[3]));
                    products.add(product);
                });

            // Output data
            ReportGenerator reportGenerator = new ReportGenerator();
            reportGenerator.generateLowInventoryReport(products);

        } catch (IOException e) {
            System.out.println("Error reading file...");
            e.printStackTrace();
        }
    }

    public void readProductsFromFileUsingBuilder(Path filePath) {
        try {

            List<String> data = Files.readAllLines(filePath);
            ArrayList<Product> products = new ArrayList<Product>();

            data.stream()
                    .skip(1)
                    .forEach((String lines) -> {

                        String[] productData = lines.split(",");

                        products.add(Product.builder()
                                .id(Integer.parseInt(productData[0]))
                                .name(productData[1])
                                .quantity(Integer.parseInt(productData[2]))
                                .price(Double.parseDouble(productData[3]))
                                .build());
            });

            ReportGenerator reportGenerator = new ReportGenerator();
            reportGenerator.generateLowInventoryReport(products);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
