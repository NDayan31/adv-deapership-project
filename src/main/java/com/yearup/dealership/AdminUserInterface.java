package com.yearup.dealership;

import java.util.Scanner;

public class AdminUserInterface {

    static Scanner input = new Scanner(System.in);
    static ContractDataManager contractDataManager = new ContractDataManager();
    public void adminAccess () {
        contractDataManager.getContracts();
        boolean exit = false;

        while (!exit) {
            System.out.println("===============Admin Screen===============\n");
            System.out.println("\t 1. View All Contracts");
            System.out.println("\t 2. View Lease Contracts");
            System.out.println("\t 3. View All Financed Contracts");
            System.out.println("\t 4. View All Cash Contracts");
            System.out.println("\t 5. Run Customer Leads");
            System.out.println("\t 0. Exit");

            System.out.print("\nInput Command: ");
            int command = input.nextInt();

            switch (command) {
                case 1: // View all contracts
                    break;
                case 2: // View Lease Contracts
                    break;
                case 3: // View Finance
                    break;
                case 4: // View Cash
                    break;
                case 5: // Customer leads
                    break;
                case 0: // Exit
                    System.out.println("Returning to Main Menu");
                    exit = true;
                    break;
                default: // User error
                    System.out.println("Invalid, try again");
                    break;
            }
        }
    }
}
