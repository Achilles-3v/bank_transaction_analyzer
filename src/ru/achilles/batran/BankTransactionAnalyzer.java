package ru.achilles.batran;

import java.io.IOException;
import java.nio.file.*;
import java.time.Month;
import java.util.*;

public class BankTransactionAnalyzer {

    private static final String RESOURCES = "src/ru/achilles/resources/data01.csv";

    public static void main(String[] args) throws IOException {

        final BankStatementCSVParser bankStatementParser = new BankStatementCSVParser();

        final Path path = Paths.get(RESOURCES);
        final List<String> lines = Files.readAllLines(path);

        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFromCSV(lines);

        System.out.println("The total for all transaction is " );
        System.out.println("Transactions in January " );
    }
}
