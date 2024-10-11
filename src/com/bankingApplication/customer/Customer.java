package com.bankingApplication.customer;

public class Customer {
    public int customerId;
    public String name;
    public Double balance;
    public String password;
    public long accountId;

    public static final String SPACE = "  ";//if you use final then use variable name as full caps
    public Customer(int customerId , String name , Double balance , String password , long accountId){
        this.customerId = customerId;
        this.name = name ;
        this.balance = balance;
        this.password = password;
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return customerId+SPACE+accountId+SPACE+name+SPACE+balance+SPACE+password;//" " this space would need to change for some instance so manually no need to change rather than use variable
    }
}
