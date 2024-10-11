package com.bankingApplication.customer;

import com.bankingApplication.bank.Bank;

import java.io.*;

public class CustomerFileHandler {
    private static final String filename = "bank_db.txt";
    static CustomerFileHandler customerFileHandler;//here we are creating a one instance to use for all methods
    public static CustomerFileHandler getInstance(){
        if(customerFileHandler == null){
            customerFileHandler = new CustomerFileHandler();
        }
        return customerFileHandler;
    }
    public void initilize() throws IOException {
        Customer[] customers = new Customer[10];
        File file = new File(filename);
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader(file)
        );
        String customerInfo = bufferedReader.readLine();
        int position = 0;
        do{
            customers[position] = casteStringToCustomer(customerInfo);
            position++;
            customerInfo = bufferedReader.readLine();
        }while(customerInfo!=null);

        Bank.customers=customers;
        Bank.refCustomerId=customers[position-1].customerId;//last person account id
        Bank.refAccountNumber=customers[position-1].accountId;//last person account number
        Bank.position = position-1;//latest position is placed in here
        bufferedReader.close();
    }
    private Customer casteStringToCustomer(String customerInfo){
        String[] trimmedInfo = customerInfo.split("  ");
        Customer customer = new Customer(
                Integer.parseInt(trimmedInfo[0]),
                trimmedInfo[2],
                Double.parseDouble(trimmedInfo[3]),
                trimmedInfo[4],
                Long.parseLong(trimmedInfo[1])
        );
        return customer;
    }
    public void addCustomerToFile(Customer customer){
        File file = new File(filename);
        FileWriter fileWriter = null;
        try {
             fileWriter = new FileWriter(file,true);
            fileWriter.write("\n"+customer.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally{
            if(fileWriter!=null){
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
