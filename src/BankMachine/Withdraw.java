package BankMachine;

import java.time.LocalDateTime;

public class Withdraw extends Transaction{
    
    public Withdraw(int id, CreditCard card, int amount, LocalDateTime date){
        super(id, card, amount, date);
    }
}
