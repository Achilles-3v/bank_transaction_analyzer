package ru.achilles.batran;

import java.io.IOException;
import java.nio.file.*;
import java.time.Month;
import java.util.*;

public class BankTransactionAnalyzer {

    private static final String RESOURCES = "src/ru/achilles/resources/data01.csv";
    private static final BankStatementCSVParser bankStatementParser = new BankStatementCSVParser();

    public static void main(String[] args) throws IOException {

        final Path path = Paths.get(RESOURCES);
        final List<String> lines = Files.readAllLines(path);

        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFromCSV(lines);
        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

        collectSummary(bankStatementProcessor);
    }

    private static void collectSummary(final BankStatementProcessor bankStatementProcessor) {
        System.out.println("The total for all transaction is " +
                bankStatementProcessor.calculateTotalAmount());
        System.out.println("The total for transaction in January is " +
                bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
        System.out.println("The total for transaction in February is " +
                bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));
        System.out.println("The total salary received is " +
                bankStatementProcessor.calculateTotalForCategory("Salary"));
    }
}
