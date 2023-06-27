package org.example;

import org.example.service.CSVReader;

import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {

        CSVReader csvReader = CSVReader.getInstance();
        csvReader.readProductsFromFile(Path.of("product-inventory.txt"));

        System.out.println("==============  USING BUILDER ARCHITECTURE ============");

        CSVReader csvReader1 = CSVReader.getInstance();
        csvReader1.readProductsFromFileUsingBuilder(Path.of("product-inventory.txt"));

    }
}
