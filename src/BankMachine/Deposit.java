package BankMachine;

import java.time.LocalDateTime;

public class Deposit extends Transaction{
    public Deposit(int id, CreditCard card, int amount, LocalDateTime date){
        super(id, card, amount, date);
    }
}
