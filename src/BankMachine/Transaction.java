package BankMachine;

import java.time.LocalDateTime;

public class Transaction {
    
    private int id;
    private CreditCard card;
    private int amount;
    private LocalDateTime date;

    public Transaction(int id, CreditCard card, int amount, LocalDateTime date){
        this.id = id;
        this.card = card;
        this.amount = amount;
        this.date = date;
    }

    public int getID(){
        return this.id;
    }

    public CreditCard getCard() {
        return this.card;
    }

    public int getAmount() {
        return this.amount;
    }

    public LocalDateTime getDate() {
        return this.date;
    }

}
