package org.example;

import org.example.service.CSVReader;

import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {

        CSVReader csvReader = CSVReader.getInstance();
        csvReader.readProductsFromFile(Path.of("product-inventory.txt"));

    }
}
