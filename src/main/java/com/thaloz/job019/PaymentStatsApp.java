package com.thaloz.job019;

import java.util.Map;

public class PaymentStatsApp {

    public static void main(String[] args) {

        PaymentProcessor processor = new PaymentProcessor();

        processor.addPayment(new Payment("P001", 150.50, "USD",
                PaymentStatusEnum.SUCCESS));
        processor.addPayment(new Payment("P002", 200.00, "USD", PaymentStatusEnum.FAILED));
        processor.addPayment(new Payment("P003", 50.25, "EUR", PaymentStatusEnum.SUCCESS));
        processor.addPayment(new Payment("P004", 300.75, "GBP", PaymentStatusEnum.SUCCESS));
        processor.addPayment(new Payment("P005", 10.00, "USD", PaymentStatusEnum.PENDING));

        System.out.println("---- All Payments ----");
        processor.getAllPayments().forEach(System.out::println);
        System.out.println();

        System.out.println("---- Successfull Payments ----");
        processor.getPaymentByStatus(PaymentStatusEnum.SUCCESS).forEach(System.out::println);
        System.out.println();

        System.out.println("---- Payments Stats ----");
        Map<String, Object> stats = processor.calculateStatistics();
        System.out.println("Total Payments: " + stats.get("totalCount"));
        System.out.println("Successful Count: " + stats.get("successCount"));
        System.out.printf("Total Amount: %.2f", stats.get("totalAmount"));
        System.out.println();
        System.out.printf("Average Amount: %.2f ", stats.get("averageAmount"));
        System.out.println();
        System.out.println();
        System.out.println("---- Payments sorted by amount (descending) ----");
        processor.getPaymentsSortByAmountDesc().forEach(System.out::println);
        System.out.println();

        System.out.println("---- Payments parallell processing simulation ----");
        processor.processPaymentParallel();


    }
}
