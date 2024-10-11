package com.bankingApplication.customer;


import com.bankingApplication.bank.Bank;

import java.util.Scanner;

public class CustomerHandler {

    public void addCustomer(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your name:");
        String name = scan.next();

        System.out.println("Enter your password: ");
        String password = scan.next();


        System.out.println("Re-type password:");
        String duplicatePassword = scan.next();

        if(!password.equals(duplicatePassword)) {//it is one of the loop way through if statement
            System.out.println("Password not matched so please retype the password:");
            return;
        }

        Bank.refCustomerId++;
        Bank.refAccountNumber++;
        Bank.position++;
        Customer c = new Customer(
                Bank.refCustomerId,
                name,
                Bank.INITIAL_BALANCE,
                duplicatePassword,
                Bank.refAccountNumber);
        Bank.customers[Bank.position]=c;
        CustomerFileHandler.getInstance().addCustomerToFile(c);
//        System.out.println(c.toString());
    }


}
