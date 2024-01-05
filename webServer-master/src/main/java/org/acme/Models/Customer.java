package org.acme.Models;

public class Customer {
    private  int id;
    private  String name;
    private  String cpr;
    private  Double balance;
    private  String bankAccount;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Customer(){}

    public Customer(int id,String name,String cpr, Double balance, String bankAccount){
        this.id = id;
        this.cpr = cpr;
        this.name = name;
        this.balance = balance;
        this.bankAccount = bankAccount;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getCpr() {
        return cpr;
    }

    public void setCpr(String cpr) {
        this.cpr = cpr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
