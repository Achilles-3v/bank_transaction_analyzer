package main.java;

@FunctionalInterface
public interface Exporter {
    String export(SummaryStatistics summaryStatistics);
}
