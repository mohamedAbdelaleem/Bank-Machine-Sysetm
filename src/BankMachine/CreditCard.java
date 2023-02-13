package BankMachine;

import java.time.LocalDateTime;

public class CreditCard {
    
    private int id;
    private Bank bankType;
    private String accountID;
    private String pin;
    private LocalDateTime validThru;
    private int balance;

    public CreditCard(int id, Bank bankType, String accountID,
                      String pin, LocalDateTime validThru)
    {
        this.id = id;
        this.bankType = bankType;
        this.accountID = accountID;
        this.pin = pin;
        this.validThru = validThru;


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

    public LocalDateTime getValidThru() {
        return this.validThru;
    }
}
