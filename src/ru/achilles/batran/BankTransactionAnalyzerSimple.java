package ru.achilles.batran;

import java.io.IOException;
import java.nio.file.*;
import java.time.Month;
import java.util.*;

public class BankTransactionAnalyzerSimple {

    private static final String RESOURCES = "src/ru/achilles/resources/data01.csv";

    public static void main(String[] args) throws IOException {

        final BankStatementCSVParser bankStatementParser = new BankStatementCSVParser();

        final Path path = Paths.get(RESOURCES);
        final List<String> lines = Files.readAllLines(path);

        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFromCSV(lines);

        System.out.println("The total for all transaction is " +
                calculateTotalAmount(bankTransactions));
        System.out.println("Transactions in January " +
                selectInMonth(bankTransactions, Month.JANUARY));
    }

    public static double calculateTotalAmount(final List<BankTransaction> bankTransactions) {
        double total = 0d;
        for (final BankTransaction bankTransaction : bankTransactions) {
            total += bankTransaction.getAmount();
        }
        return total;
    }

    public static List<BankTransaction> selectInMonth(
            final List<BankTransaction> bankTransactions, final Month month) {

        final List<BankTransaction> bankTransactionsMonth = new ArrayList<>();
        for (final BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.getDate().getMonth() == month) {
                bankTransactionsMonth.add(bankTransaction);
            }
        }
        return bankTransactionsMonth;
    }
}
