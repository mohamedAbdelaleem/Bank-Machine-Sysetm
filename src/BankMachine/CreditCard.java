package BankMachine;

import java.util.*;

public class CreditCard {
    
    private int id;
    private Bank bankType;
    private String accountID;
    private String pin;
    private Date validThru;
    private int balance;

    public CreditCard(int id, Bank bankType, String accountID,
                      String pin, Date validThru, int balance)
    {
        this.id = id;
        this.bankType = bankType;
        this.accountID = accountID;
        this.pin = pin;
        this.validThru = validThru;
        this.balance = balance;


    }

    public int getId() {
        return this.id;
    }

    public Bank getBankType() {
        return this.bankType;
    }

    public int getBalance() {
        return this.balance;
    }

    public String getAccountID(){
        return this.accountID;
    }

    public String getPin() {
        return this.pin;
    }

    public Date getValidThru() {
        return this.validThru;
    }
}
