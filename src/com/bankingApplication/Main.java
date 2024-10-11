package com.bankingApplication;

import com.bankingApplication.bank.Bank;
import com.bankingApplication.customer.CustomerFileHandler;
import com.bankingApplication.customer.CustomerHandler;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");
        CustomerFileHandler customerFileHandler = new CustomerFileHandler();
        try {
            customerFileHandler.initilize();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        System.out.println(Bank.customers[1].name);used for view purpose
        CustomerHandler customerHandler = new CustomerHandler();
        customerHandler.addCustomer();
        System.out.println(Bank.customers[Bank.position].name);
    }
}