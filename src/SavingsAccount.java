//********************************************************************
//
//  Author:       Afaq Ahmad
//
//  File Name:    SavingsAccount.java
//
//  Course:       ITSE 2321 Object-Oriented Programming
//
//  Due Date:     11-21-2025
//
//  Instructor:   Prof. Fred Kumi
//
//  Description:  This class models a savings account with a shared
//                annual interest rate and supports deposits,
//                withdrawals, and monthly interest calculation.
//
//********************************************************************
public class SavingsAccount {
    // Static variable to store annual interest rate for all accounts
    private static double annualInterestRate;
    // Instance variable to store the balance for this account
    private double savingsBalance;

    public SavingsAccount(double balance) {
        this.savingsBalance = balance;
    }

    public void calculateMonthlyInterest() {
        double monthlyInterest = (savingsBalance * annualInterestRate) / 12.0;
        savingsBalance += monthlyInterest;
    }

    public void depositAmount(double amount) {
        if (amount > 0) {
            savingsBalance += amount;
        }
    }

    public void withdrawAmount(double amount) {
        if (amount > 0) {
            savingsBalance -= amount;
        }
    }

    public static void modifyInterestRate(double newRate) {
        if (newRate >= 2.0 && newRate <= 5.0) {
            annualInterestRate = newRate / 100.0;
        }
    }

    @Override
    public String toString() {
        return String.format("%.2f", savingsBalance);
    }

}