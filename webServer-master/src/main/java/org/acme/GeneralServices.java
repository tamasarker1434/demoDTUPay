package org.acme;

import org.acme.Models.Customer;
import org.acme.Models.Trade;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class GeneralServices {
    List<Customer> customers = new ArrayList<>(Arrays.asList(
                new Customer(1,"Yingli","cprnoYingli",1000.00,"account_noYingli","customer"),
                new Customer(2,"Tama","cprnoTama",1000.00,"account_noTama","customer"),
                new Customer(3,"Siyuan","cprnoSiyuan",1000.00,"account_noSiyuan","customer"),
                new Customer(4,"Jiahe","cprnoJiahe",1000.00,"account_noJiahe","customer"),
                new Customer(5,"Xinyi","cprnoXinyi",1000.00,"account_noXinyi","customer")
        ));

        public List<Customer> getAllCustomers(){
            return customers;
        }
        public boolean getCustomer(String bankAcc){
            Optional<Customer> opCustomers = customers.stream().filter(t->t.getBankAccount().equals(bankAcc)).findFirst();
            if(opCustomers.isPresent()){
                return true;
            }
            else{
                return false;
            }
        }
        public int addNewDtuPayUser(Customer newCustomer) {

            if (getCustomer(newCustomer.getBankAccount())){
                int nextId = customers.size() + 1;
                newCustomer.setId(nextId);
                customers.add(newCustomer);
                return nextId;
            }
            else {
                return -1;
            }
        }
        public Double getCustomerAccountBalance(String accountNumber) {
            Optional<Customer> opCustomers = customers.stream().filter(t->t.getBankAccount().equals(accountNumber)).findFirst();
            if(opCustomers.isPresent()){
                return opCustomers.get().getBalance();
            }
            else{
                return 0.0;
            }
        }

        public void changeAccountBalance(String bankAccount, Double currentBalanceC) {
            for (Customer element: customers){
                if (element.getBankAccount().equals(bankAccount)){
                    element.setBalance(currentBalanceC);
                    customers.set(customers.indexOf(element), new Customer(element.getId(),element.getName(),element.getCpr(),element.getBalance(),element.getBankAccount(),element.getUserType()));
                }
            }
        }
        List<Trade> trades = new ArrayList<>(Arrays.asList());

        public List<Trade> addTrade(Trade trade){
            Double currentBalanceC = getCustomerAccountBalance(trade.getCustomerBankAccount()) - trade.getBalance();
            Double currentBalanceM = getCustomerAccountBalance(trade.getMerchantBankAccount())+ trade.getBalance();
            Trade newTrade = new Trade(trade.getCustomerBankAccount(),currentBalanceC,trade.getMerchantBankAccount(),currentBalanceM,trade.getBalance());
            trades.add(newTrade);
            changeAccountBalance(trade.getCustomerBankAccount(), currentBalanceC);
            changeAccountBalance(trade.getMerchantBankAccount(), currentBalanceM);
            return getAllTrades();
        }

        public List<Trade> getAllTrades(){
            return trades;
        }
}
