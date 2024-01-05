package org.acme.Models;

public class Merchant {
    private  String id;
    private  Double balance;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Merchant(){}

    public Merchant(String id, Double balance){
        this.id=id;
        this.balance = balance;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
