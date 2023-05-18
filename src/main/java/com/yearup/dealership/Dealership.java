package com.yearup.dealership;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dealership {
    private String name;
    private String address;
    private String phone;

    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();

    }
    public List<Vehicle> getVehicleByPrice (double min, double max) {
        List<Vehicle> byPrice = new ArrayList<>();
        int i = 0;
        for (Vehicle vehicle : inventory) {
            if (vehicle.getPrice() >= min && vehicle.getPrice() <= max){
                byPrice.add(inventory.get(i));
            }
            i++;
        }
        return byPrice;
    }
    public List<Vehicle> getVehicleByMakeModel (String make, String model) {
        List<Vehicle> byMakeModel = new ArrayList<>();
        int i = 0;
        for (Vehicle vehicle : inventory) {
            if (vehicle.getMake().equalsIgnoreCase(make) || vehicle.getModel().equalsIgnoreCase(model)) {
                byMakeModel.add(inventory.get(i));
            }
            i++;
        }
        return byMakeModel;
    }
    public List<Vehicle> getVehicleByYear (int min, int max) {
        List<Vehicle> byYear = new ArrayList<>();
        int i = 0;
        for (Vehicle vehicle : inventory) {
            if (vehicle.getYear() >= min && vehicle.getYear() <= max){
                byYear.add(inventory.get(i));
            }
            i++;
        }
        return byYear;
    }
    public List<Vehicle> getVehicleByColor (String color) {
        List<Vehicle> byColor = new ArrayList<>();
        int i = 0;
        for (Vehicle vehicle : inventory) {
            if (vehicle.getColor().equalsIgnoreCase(color)){
                byColor.add(inventory.get(i));
            }
            i++;
        }
        return byColor;
    }
    public List<Vehicle> getVehicleByMiles (int min, int max) {
        List<Vehicle> byMiles = new ArrayList<>();
        int i = 0;
        for (Vehicle vehicle : inventory) {
            if (vehicle.getOdometer() >= min && vehicle.getOdometer() <= max){
                byMiles.add(inventory.get(i));
            }
            i++;
        }
        return byMiles;
    }
    public List<Vehicle> getVehiclesByType (String vehicleType) {
        List<Vehicle> byVehicleType = new ArrayList<>();
        int i = 0;
        for (Vehicle vehicle : inventory) {
            if (vehicle.getVehicleType().equalsIgnoreCase(vehicleType)){
                byVehicleType.add(inventory.get(i));
            }
            i++;
        }
        return byVehicleType;
    }
    public List<Vehicle> getAllVehicles () {
        return inventory;
    }
    public void addVehicle (Vehicle vehicle){
        inventory.add(vehicle);
    }
    public void removeVehicle (Vehicle vehicle){
        inventory.remove(vehicle);
    }
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return name +
                "|" + address +
                "|" + phone;
    }
}
