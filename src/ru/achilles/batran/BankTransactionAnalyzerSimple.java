package ru.achilles.batran;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class BankTransactionAnalyzerSimple {

    private static final String RESOURCES = "src/ru/achilles/resources/data01.csv";

    public static void main(String[] args) throws IOException {

        final Path path = Paths.get(RESOURCES);
        final List<String> lines = Files.readAllLines(path);
        double total = 0d;
        for (final String line: lines) {
            final String[] columns = line.split(",");
            final double amount = Double.parseDouble(columns[1]);
            total += amount;
        }

        System.out.println("The total for all transaction is " + total);
    }
}
