package BankMachine;

public class ATM {
    
    private int id;
    private Bank bankType;
    private int cashamount;
    private CreditCard currCard;

    public ATM(Bank bankType){
        this.bankType = bankType;
    }
    

}
