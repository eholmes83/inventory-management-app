package org.example.service;

import org.example.domain.Product;

import java.util.ArrayList;

public class ReportGenerator {

    private static ReportGenerator reportGenerator = null;

    public static ReportGenerator getInstance() {
        if (reportGenerator == null) {
            reportGenerator = new ReportGenerator();
        }
        return reportGenerator;
    }

    public void generateLowInventoryReport(ArrayList<Product> products) {
        products.forEach(product -> {
            if (product.getPrice() >= 0.99 && product.getPrice() <= 100.00) {
                if (product.getQuantity() <= 20) {
                    System.out.println("Low Qty!!! Reorder the following product -> " + "{ ID: " + product.getId() +
                            " Name : " + product.getName() + " Current Qty : " + product.getQuantity() + " }");
                }
            }
            if (product.getPrice() > 101.00 && product.getQuantity() < 10) {
                System.out.println("Low Qty!!! Reorder the following product -> " + "{ ID: " + product.getId() +
                        " Name : " + product.getName() + " Current Qty : " + product.getQuantity() + " }");
            }
        });
    }
}
