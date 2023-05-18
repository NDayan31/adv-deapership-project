package com.yearup.dealership;

import java.io.*;

public class DealershipFileManager {

    static String fileName = "DealershipInventory.csv";

    public Dealership getDealership() {
        Dealership dealership = null;
        try {
            BufferedReader bfr = new BufferedReader(new FileReader(fileName));
            String line;
            int lineNumber = 1;

            while ((line = bfr.readLine()) != null) {
                if (lineNumber == 1) {
                    String[] getDealershipInfo = line.split("\\|");
                    String name = getDealershipInfo[0];
                    String address = getDealershipInfo[1];
                    String phoneNumber = getDealershipInfo[2];

                    dealership = new Dealership(name, address, phoneNumber);

                } else {
                    String[] getInventoryInfo = line.split("\\|");

                    // vin|year|Make|Model|Type|color|odo|price
                    int vin = Integer.parseInt(getInventoryInfo[0]);
                    int year = Integer.parseInt(getInventoryInfo[1]);
                    String make = getInventoryInfo[2];
                    String model = getInventoryInfo[3];
                    String vehicleType = getInventoryInfo[4];
                    String color = getInventoryInfo[5];
                    int odometer = Integer.parseInt(getInventoryInfo[6]);
                    double price = Double.parseDouble(getInventoryInfo[7]);

                    Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                    dealership.addVehicle(vehicle);
                }
                lineNumber++;
            }
            bfr.close();
        } catch (IOException e) {
            System.out.println("Error");
        }
        return dealership;
    }
    public void saveDealership (Dealership vehicles) {
        try {
            BufferedWriter bfw = new BufferedWriter(new FileWriter(fileName));

            bfw.write(vehicles.toString());
            bfw.newLine();

            for (int i = 0; i < vehicles.getAllVehicles().size(); i++) {
                bfw.write(String.valueOf(vehicles.getAllVehicles().get(i)));
                bfw.newLine();
            }

            bfw.close();
        } catch (IOException e){
            System.out.println("Error");
        }
    }
}
