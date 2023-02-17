package BankMachine;

import java.util.*;
import java.time.*;;

public class TransactionsController {
    
    private HashMap<Integer, Transaction> transactions;

    public TransactionsController(){
        this.transactions = new HashMap<Integer, Transaction>();
    }

    public boolean processWithdraw(CreditCard card, int amount){
        
        if (amount > 5000 || amount < 20){
            System.out.println("Invalid Entry!\nMin is $20\tMax is $5000");
            return false;
        }

        Transaction transaction = new Withdraw(transactions.size(), card,
                                               amount, LocalDateTime.now());

        card.decreaseBalance(amount);
        this.transactions.put(transaction.getID(), transaction);
        return true;
    }

    public boolean processDeposit(CreditCard card, int amount){

        if (amount > 5000 || amount < 20){
            System.out.println("Invalid Entry!\nMin is $20\tMax is $5000");
            return false;
        }

        Transaction transaction = new Deposit(transactions.size(), card,
                                               amount, LocalDateTime.now());

        card.increaseBalance(amount);
        this.transactions.put(transaction.getID(), transaction);
        return true;
    }
}
