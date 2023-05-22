package com.yearup.dealership;

import java.io.*;

public class ContractDataManager {
   static String fileName = "contracts.csv";
    public void saveContract (Contract contract){
        try {
            BufferedWriter bfw = new BufferedWriter(new FileWriter(fileName,true));
            bfw.newLine();
                if(contract instanceof SalesContract){
                    String financeOption = "";
                    if (((SalesContract) contract).isFinanceOption()){
                        financeOption = "Yes";
                    } else {
                        financeOption = "No";
                    }

                    // Type|contract date|name|email|car id|year|make|model|vehicle type|color|odometer|price|sales tax|recording fee|processing fee|total cost|finance|monthly payment
                    bfw.write("SALE" + "|" + contract.getContractDate() + "|" + contract.getCustomerName() + "|" + contract.getCustomerEmail() + "|" +
                            contract.getVehicleSold().getVin() + "|" + contract.getVehicleSold().getYear() + "|" + contract.getVehicleSold().getMake() + "|" + contract.getVehicleSold().getModel() + "|" +
                            contract.getVehicleSold().getVehicleType() + "|" + contract.getVehicleSold().getColor() + "|" + contract.getVehicleSold().getOdometer() + "|" + contract.getVehicleSold().getPrice()
                            + "|" + ((SalesContract) contract).getSalesTaxAmount() + "|" + ((SalesContract) contract).getRecordingFee() + "|" + ((SalesContract) contract).getProcessingFee() + "|" +
                            contract.getTotalPrice() + "|" + financeOption + "|" + contract.getMonthlyPayment());
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
    public Contract getContracts () {
        try {
            Contract contract = null;
            BufferedReader bfr = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = bfr.readLine()) != null) {
                String[] getDealershipData = line.split("\\|");
            }


            bfr.close();
        } catch (IOException e) {
            System.out.println("System reported an error.");
        }
    return null;
    }
}
