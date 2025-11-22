//********************************************************************
//
//  Author:       Afaq Ahmad
//
//  Program #:    Eight
//
//  File Name:    Program8.java
//
//  Course:       ITSE 2321 Object-Oriented Programming
//
//  Due Date:     11-21-2025
//
//  Instructor:   Prof. Fred Kumi
//
//  Chapter:       Chapters 1 - 8 Objects, Classes, and Methods
//
//  Description:  Demonstrates the SavingsAccount class by creating two accounts,
//                applying monthly interest for 12 months at 4%, performing deposit and withdrawal operations,
//                then recalculating the next month at 5% interest.
//
//********************************************************************

public class Program8 {
    //***************************************************************
    //
    //  Method:       main
    //
    //  Description:  The main method of the program
    //
    //  Parameters:   String array
    //
    //  Returns:      N/A
    //
    //**************************************************************
    public static void main(String[] args) {

        Program8 obj = new Program8();
        developerInfo();
        obj.runProgram();

    } // End of the main method

    //***************************************************************
    //
    //  Method:       developerInfo
    //
    //  Description:  The developer information method of the program
    //
    //  Parameters:   None
    //
    //  Returns:      N/A
    //
    //**************************************************************
    public static void developerInfo() {
        System.out.println("Name:     Afaq Ahmad");
        System.out.println("Course:   ITSE 2321 Object-Oriented Programming");
        System.out.println("Program:  Eight");
        System.out.println("Due Date: 11-21-2025\n");
    } // End of the developerInfo method

    public void runProgram() {
        // Create two SavingsAccount objects with initial balances
        SavingsAccount saver1 = new SavingsAccount(2000.00);
        SavingsAccount saver2 = new SavingsAccount(3000.00);

        // Set annual interest rate to 4%
        SavingsAccount.modifyInterestRate(4.0);

        // Calculate and display 12 months of interest
        displayTwelveMonths(saver1, saver2);

        // Perform deposit and withdrawal transactions
        performTransactions(saver1, saver2);

        // Change interest rate to 5% and calculate next month
        changeRateAndCalculate(saver1, saver2);
    }

    public void displayTwelveMonths(SavingsAccount saver1, SavingsAccount saver2) {
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        System.out.println("Monthly balances at 4% annual interest rate:");
        System.out.println();
        printTableHeader();

        for (int i = 0; i < 12; i++) {
            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();
            printMonthlyBalance(months[i], saver1, saver2);
        }

        System.out.println();
    }

    public void printTableHeader() {
        System.out.printf("%-12s %20s %20s%n", "Month", "Saver1 Balance", "Saver2 Balance");
        System.out.println("-------------------------------------------------------");
    }

    public void printMonthlyBalance(String month, SavingsAccount saver1, SavingsAccount saver2) {
        System.out.printf("%-12s $%14s $%14s%n", month, saver1.toString(), saver2.toString());
    }

    public void performTransactions(SavingsAccount saver1, SavingsAccount saver2) {
        System.out.println("Performing transactions...");
        saver1.depositAmount(1500.00);

        System.out.println("Deposited $1500.00 to Saver1's account");
        saver2.withdrawAmount(550.00);

        System.out.println("Withdrew $550.00 from Saver2's account");
        System.out.println();
    }

    public void changeRateAndCalculate(SavingsAccount saver1, SavingsAccount saver2) {
        SavingsAccount.modifyInterestRate(5.0);
        System.out.println("Changed annual interest rate to 5%");
        System.out.println("Next month's balances:");
        System.out.println();

        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();

        System.out.printf("Saver1: $%s%n", saver1.toString());
        System.out.printf("Saver2: $%s%n", saver2.toString());
    }

}
