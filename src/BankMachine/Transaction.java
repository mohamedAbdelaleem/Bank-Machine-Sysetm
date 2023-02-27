package BankMachine;

import java.time.LocalDateTime;

public class Transaction {
    
    protected int id;
    protected CreditCard card;
    protected int amount;
    protected LocalDateTime date;
    protected boolean status;

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

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean getStatus(){
        return this.status;
    }

    public void apply(){};
}
