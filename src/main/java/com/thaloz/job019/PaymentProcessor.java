package com.thaloz.job019;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PaymentProcessor {

    private final List<Payment> payments;

    public PaymentProcessor() {
        this.payments = new ArrayList<Payment>();
    }

    public boolean addPayment(Payment payment) {
        return this.payments.add(payment);
    }

    public List<Payment> getPayments() {
        return new ArrayList<>(this.payments);
    }

    public List<Payment> getPayment(PaymentStatusEnum status) {
        return payments.stream().filter(p -> p.getStatus().equals(status))
                .collect(Collectors.toList());
    }

    public Integer getNumberOfPayments() {
        return this.payments.size();
    }

    public Double getTotalAmountPayments() {
        return payments.stream().map(Payment::getAmount).reduce(0.0, Double::sum);
    }

    public Double totalAmountSuccessfulPayments() {
        return payments.stream().filter(p -> PaymentStatusEnum.SUCCESS.equals(p.getStatus())).
                map(Payment::getAmount).reduce(0.0, Double::sum);
    }

    public Double averageAmountOfSuccessfulPayments() {
        Double total = payments.stream().filter(p -> PaymentStatusEnum.SUCCESS.equals(p.getStatus())).
                map(Payment::getAmount).reduce(0.0, Double::sum);

        return total / this.payments.size();
    }


    public static void main(String[] args) {

        PaymentProcessor paymentProcessor = new PaymentProcessor();
        paymentProcessor.addPayment(new Payment("1", 100.0, "R$", PaymentStatusEnum.SUCCESS));
        paymentProcessor.addPayment(new Payment("2", 100.0, "R$", PaymentStatusEnum.SUCCESS));
        paymentProcessor.addPayment(new Payment("1", 100.0, "R$", PaymentStatusEnum.SUCCESS));
        System.out.println(paymentProcessor.getNumberOfPayments());
        System.out.println(paymentProcessor.getTotalAmountPayments());
        System.out.println(paymentProcessor.totalAmountSuccessfulPayments());
        System.out.println(paymentProcessor.averageAmountOfSuccessfulPayments());

    }

}
