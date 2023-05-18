package com.yearup.dealerships;

public class SalesContract extends com.dealerships.Contract {
    private final double salesTax;
    private final double recordingFee;
    private double processingFee;
    private boolean financing;
    private double monthlyPlan;

    public SalesContract(String contractDate, String customerName, String customerEmail, boolean vehicleSold, double salePrice, double totalPrice, double monthlyPayment, double salesTax, double recordingFee, double processingFee, boolean financing, double monthlyPlan) {
        super(contractDate, customerName, customerEmail, vehicleSold, salePrice, totalPrice, monthlyPayment);
        this.salesTax = 0.95;
        this.recordingFee = 100;
        this.processingFee = processingFee;
        this.financing = financing;
        this.monthlyPlan = monthlyPlan;
    }

    public double getSalesTax() {
        return salesTax;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public boolean isFinancing() {
        return financing;
    }

    public void setFinancing(boolean financing) {
        this.financing = financing;
    }

    public double getMonthlyPlan() {
        return monthlyPlan;
    }

    public void setMonthlyPlan(double monthlyPlan) {
        this.monthlyPlan = monthlyPlan;
    }

    @Override
    public double getTotalPrice() {
        if (getSalePrice() < 10000){
            double totalPrice = (getSalePrice() * getSalesTax()) + getRecordingFee() + 295;
        }
        return 0;
    }

    @Override
    public double getMonthlyPayment() {
        return 0;
    }
}
