package com.yearup.dealership;

import com.yearup.dealership.Vehicle;

public class SalesContract extends Contract {
    private final double salesTaxAmount;
    private final double recordingFee;
    private double processingFee;
    private boolean financeOption;

    public SalesContract(String contractDate, String customerName, String customerEmail, Vehicle vehicleSold, boolean financeOption) {
        super(contractDate, customerName, customerEmail,vehicleSold);
        this.salesTaxAmount = 0.05;
        this.recordingFee = 100;
        this.processingFee = processingFee;
        this.financeOption = financeOption;
    }

    public double getSalesTaxAmount() {
        return salesTaxAmount;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public double getProcessingFee() {
        if (getVehicleSold().getPrice() < 10000){
            processingFee = 295;
        } else {
            processingFee = 495;
        }
        return processingFee;
    }

    public boolean isFinanceOption() {
        return financeOption;
    }

    public void setFinanceOption(boolean financeOption) {
        this.financeOption = financeOption;
    }

    @Override
    public double getTotalPrice() {
        return getVehicleSold().getPrice() + salesTaxAmount + recordingFee + processingFee;
    }

    @Override
    public double getMonthlyPayment() {
        int numberOfPayments = 0;
        double interestRate = 0;
        if (financeOption) {
            if (getVehicleSold().getPrice() >= 10000) {
                numberOfPayments = 48;
                interestRate = 4.25 / 1200;
            } else {
                numberOfPayments = 24;
                interestRate = 5.25 / 1200;
            }

            double monthlyPayment = getTotalPrice() * (interestRate * Math.pow(1 + interestRate, numberOfPayments)) / (Math.pow(1 + interestRate, numberOfPayments) - 1);
            monthlyPayment = Math.round(monthlyPayment * 100);
            monthlyPayment /= 100;
            return monthlyPayment;
        } else {
            return 0.0;
        }
    }
}