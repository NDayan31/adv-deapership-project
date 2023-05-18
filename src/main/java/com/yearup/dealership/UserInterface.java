package com.yearup.dealership;

import java.io.IOException;
import java.util.*;

public class UserInterface {
    private Dealership dealership;

    public UserInterface() {
    }

    static Scanner input = new Scanner(System.in);
    private void init () {
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        dealership = dealershipFileManager.getDealership();
    }
    private void displayListHeader () {
        System.out.printf("%-8s ||%-6s ||%-12s ||%-15s ||%-10s ||%-10s ||%-8s ||%-12s\n",
                "VIN#", "Year", "Make", "Model", "Type", "Color", "Miles", "Price");
    }
    private void displayVehicle (List<Vehicle> inventory) {
        //String format vin[10]|year[6]|Make[15]|Model[15]|Type[10]|color[10]|odo[8]|price[12]
        for (Vehicle vehicle : inventory) {
            //System.out.println(inventory.get(i));
            System.out.printf("%-8s ||%-6s ||%-12s ||%-15s ||%-10s ||%-10s ||%-8s ||$%-12s\n",
                    vehicle.getVin(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(), vehicle.getVehicleType(), vehicle.getColor(), vehicle.getOdometer(), vehicle.getPrice());
        }
    }
    public void display (){
        init();
        boolean exit = false;
        while (!exit) {

            System.out.println("=================================");
            System.out.println("\t1. Search by Price");
            System.out.println("\t2. Search by Make and Model");
            System.out.println("\t3. Search by Year");
            System.out.println("\t4. Search by Color");
            System.out.println("\t5. Search by Odometer Reading");
            System.out.println("\t6. Search by Vehicle Type");
            System.out.println("\t7. Search All Vehicles");
            System.out.println("\t8. Add a vehicle");
            System.out.println("\t9. Remove Vehicle");
            System.out.println("\t99. Exit");

            System.out.print("Please select an option: ");
            int command = input.nextInt();

            switch (command) {
                case 1: //Search by price
                    processGetByPriceRequest();
                    break;
                case 2: //Search by make/model
                    processGetByMakeModelRequest();
                    break;
                case 3: // Search by year
                    processGetByYearRequest();
                    break;
                case 4: // search by color
                    processGetByColorRequest();
                    break;
                case 5: // search by odo
                    processGetByMileageRequest();
                    break;
                case 6: // search by vehicle type
                    processGetByVehicleTypeRequest();
                    break;
                case 7: // search all vehicles
                    processGetAllVehicleRequest();
                    break;
                case 8: // Add a vehicle
                    processAddVehicleRequest();
                    break;
                case 9: // remove a vehicle
                    processRemoveVehicleRequest();
                    break;
                case 99: // Exit
                    System.out.println("Thank you! Goodbye.");
                    exit = true;
                    break;
                default: // User Error
                    System.out.println("Input is incorrect, try again.\n");
                    break;
            }
        }
    }
    public void processGetByPriceRequest () {
        System.out.print("Enter minimum amount: ");
        double min = input.nextDouble();
        System.out.print("Enter maximum amount: ");
        double max = input.nextDouble();
        displayListHeader();
        displayVehicle(dealership.getVehicleByPrice(min, max));
    }
    public void processGetByMakeModelRequest () {
        System.out.print("Enter a Make: ");
        input.nextLine();
        String make = input.nextLine();
        System.out.print("Enter a Model: ");
        String model = input.nextLine();
        displayListHeader();
        displayVehicle(dealership.getVehicleByMakeModel(make, model));
    }
    public void processGetByYearRequest () {
        System.out.print("Enter oldest year: ");
        int min = input.nextInt();
        System.out.print("Enter newest year: ");
        int max = input.nextInt();
        displayListHeader();
        displayVehicle(dealership.getVehicleByYear(min, max));
    }
    public void processGetByColorRequest () {
        System.out.print("Enter color: ");
        input.nextLine();
        String color = input.nextLine();
        displayListHeader();
        displayVehicle(dealership.getVehicleByColor(color));
    }
    public void processGetByMileageRequest () {
        System.out.print("Enter minimum mileage: ");
        int min = input.nextInt();
        System.out.print("Enter maximum mileage: ");
        int max = input.nextInt();
        displayListHeader();
        displayVehicle(dealership.getVehicleByMiles(min, max));
    }
    public void processGetByVehicleTypeRequest () {
        System.out.print("Enter vehicle type: ");
        input.nextLine();
        String vehicleType = input.nextLine();
        displayListHeader();
        displayVehicle(dealership.getVehiclesByType(vehicleType));
    }
    public void processGetAllVehicleRequest () {
        displayListHeader();
        displayVehicle(dealership.getAllVehicles());

    }
    public void processAddVehicleRequest () {
        //String format vin|year|Make|Model|Type|color|odo|price
        System.out.print("Enter the last 6 of the VIN: ");
        int vin = input.nextInt();
        input.nextLine();
        System.out.print("Enter the year: ");
        int year = input.nextInt();
        input.nextLine();
        System.out.print("Enter vehicle make: ");
        String make = input.nextLine();
        System.out.print("Enter vehicle model: ");
        String model = input.nextLine();
        System.out.print("Enter vehicle type: ");
        String vehicleType = input.nextLine();
        System.out.print("Enter vehicle color: ");
        String color = input.nextLine();
        System.out.print("Enter Odometer reading (miles): ");
        int odometer = input.nextInt();
        System.out.print("Enter vehicle price: $");
        double price = input.nextDouble();
        System.out.println("\n\tNew vehicle has been added to the inventory!");

        Vehicle vehicle = new Vehicle(vin,year,make,model,vehicleType,color,odometer,price);
        dealership.addVehicle(vehicle);
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        dealershipFileManager.saveDealership(dealership);
    }
    public void processRemoveVehicleRequest () {
        System.out.print("Which vehicle would you like to remove?\nEnter the last 6 of the VIN: ");
        int vin = input.nextInt();
        input.nextLine();
        for (Vehicle vehicle : dealership.getAllVehicles()){
            if (vehicle.getVin() == vin){
                System.out.printf("%d: %d %s %s had been removed.",
                        vehicle.getVin(),vehicle.getYear(),vehicle.getMake(),vehicle.getModel());
                dealership.removeVehicle(vehicle);
                break;
            }
        }
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        dealershipFileManager.saveDealership(dealership);

    }

}
