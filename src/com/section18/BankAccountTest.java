package com.section18;

import static org.junit.Assert.*;

public class BankAccountTest {

    private BankAccount account;
    private static int count; // instance variable

    @org.junit.BeforeClass
    public static void beforeClass(){
        System.out.println("Executes before any test cases. Count = " + count++);
    }

    // method with @ before annotation
    // will run this setup every time a test is ran
    @org.junit.Before
    public void setup(){
        account = new BankAccount("Carlton", "Smalls", 1500.00, BankAccount.CHECKING);
        System.out.println("Running test...");
    }

    @org.junit.Test
    public void deposit() {
        // instance created
        double balance = account.deposit(200.00, true); // calling the deposit method
        assertEquals(1700.00, balance, 0);
    }

    @org.junit.Test
    public void withdraw_branch() {
        double balance = account.withdraw(600.00, true);
        assertEquals(900.00, balance, 0);
    }

    @org.junit.Test
    public void withdraw_notBranch() {
        account.withdraw(600.00, false);
    }

    @org.junit.Test
    public void getBalance_deposit() {
        account.deposit(200.00, true); // calling the deposit method
        assertEquals(1700.00, account.getBalance(), 0);
    }

    @org.junit.Test
    public void getBalance_withdraw() {
        account.withdraw(200.00, true); // calling the withdraw method
        assertEquals(1300.00, account.getBalance(), 0);
    }

    @org.junit.AfterClass
    public static void afterClass(){
        System.out.println("Executes after any test cases. Count = " + count++);
    }

    @org.junit.After
    public void teardown(){
        System.out.println("Count = " + count++);
    }

}