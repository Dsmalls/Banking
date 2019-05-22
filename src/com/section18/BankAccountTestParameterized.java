package com.section18;


import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BankAccountTestParameterized {

    private BankAccount account; // setting up parameters to uses
    private double amount;
    private boolean branch;
    private double expected;

    public BankAccountTestParameterized(double amount, boolean branch, double expected) {
        this.amount = amount;
        this.branch = branch;
        this.expected = expected;
    }

    @org.junit.Before
    public void setup(){
        account = new BankAccount("Carlton", "Smalls", 1500.00, BankAccount.CHECKING);
        System.out.println("Running test...");
    }

    @Parameterized.Parameters
    public static List<Object[]> testConditions(){ // junit will create a new instance of the parameterized test
        return Arrays.asList(new Object[][] {
                {100.00, true, 1600.00}, // set of parameter that is being tested with the expected value, lines 35-39
                {200.00, true, 1700.00},
                {300.00, true, 1800.00},
                {450.00, true, 1950.00},
                {1000.00, true, 2500.00}
        });
    }

    @org.junit.Test
    public void getDeposit() {
        account.deposit(amount, branch); // running 5 test lines 35-39 on the same method
        assertEquals(expected, account.getBalance(), 0);
    }
}
