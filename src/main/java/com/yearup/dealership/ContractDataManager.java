package com.yearup.dealership;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ContractDataManager {
   static String fileName = "contracts.csv";
    public void saveContract (Contract contract){
        try {
            BufferedWriter bfw = new BufferedWriter(new FileWriter(fileName,true));
            bfw.newLine();
                if(contract instanceof SalesContract){

                    // Type|contract date|name|email|car id|year|make|model|vehicle type|color|odometer|price|sales tax|recording fee|processing fee|total cost|finance|monthly payment
                    bfw.write("SALE" + "|" + contract.getContractDate() + "|" + contract.getCustomerName() + "|" + contract.getCustomerEmail() + "|" +
                            contract.getVehicleSold().getVin() + "|" + contract.getVehicleSold().getYear() + "|" + contract.getVehicleSold().getMake() + "|" + contract.getVehicleSold().getModel() + "|" +
                            contract.getVehicleSold().getVehicleType() + "|" + contract.getVehicleSold().getColor() + "|" + contract.getVehicleSold().getOdometer() + "|" + contract.getVehicleSold().getPrice()
                            + "|" + ((SalesContract) contract).getSalesTaxAmount() + "|" + ((SalesContract) contract).getRecordingFee() + "|" + ((SalesContract) contract).getProcessingFee() + "|" +
                            contract.getTotalPrice() + "|" + ((SalesContract) contract).isFinanceOption() + "|" + contract.getMonthlyPayment());
                 }
                 else if (contract instanceof LeaseContract){
                    // Type|contract date|name|email|car id|year|make|model|vehicle type|color|odometer|price|ending value|lease fee|total cost|monthly payment

                    bfw.write("LEASE" + "|" + contract.getContractDate() + "|" + contract.getCustomerName() + "|" + contract.getCustomerEmail() + "|" +
                            contract.getVehicleSold().getVin() + "|" + contract.getVehicleSold().getYear() + "|" + contract.getVehicleSold().getMake() + "|" + contract.getVehicleSold().getModel() + "|" +
                            contract.getVehicleSold().getVehicleType() + "|" + contract.getVehicleSold().getColor() + "|" + contract.getVehicleSold().getOdometer() + "|" + contract.getVehicleSold().getPrice()
                            + "|" + ((LeaseContract) contract).getExpectedEndingValue() + "|" + ((LeaseContract) contract).getLeaseFee() + "|" + contract.getTotalPrice() + "|" + contract.getMonthlyPayment());
                 }
            bfw.close();
        } catch (IOException e){
            System.out.println("System reported an error");
        }
    }
}
