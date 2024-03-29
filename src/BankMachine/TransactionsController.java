package BankMachine;

import java.util.*;
import java.time.*;;

public class TransactionsController {
    
    private HashMap<Integer, Transaction> transactions;

    public TransactionsController(){
        this.transactions = new HashMap<Integer, Transaction>();
    }

    public Withdraw processWithdraw(CreditCard card, int amount){
        

        Withdraw transaction = new Withdraw(transactions.size()+1, card,
                                               amount, LocalDateTime.now());

        if (amount > card.getBalance()){
            System.out.println("Your Balance is less than that amount!");
            transaction.setStatus(false);
        }

        return transaction;
       
    }

    public Deposit processDeposit(CreditCard card, int amount){

        Deposit transaction = new Deposit(transactions.size()+1, card,
                                               amount, LocalDateTime.now());
        

        
        return transaction;
    
    }

    public void saveTransaction(Transaction transaction){
        if (transaction.getStatus()){
            transaction.apply();
        }
        this.transactions.put(transaction.getID(), transaction);
    }
}
