package BankMachine;

import java.util.HashMap;

public class BankMasr implements Bank{
    
    private static Bank bankSystem = new BankMasr();
    private HashMap<Integer, ATM> bankMachines;
    private CustomersController customersController;
    private CreditCardsController creditCardsController;
    private TransactionsController transactionsController;
    
    private BankMasr(){
        this.customersController = new CustomersController();
        this.creditCardsController = new CreditCardsController(bankSystem); 
        this.transactionsController = new TransactionsController();
    }

    public static Bank getBankSystem(){
        return BankMasr.bankSystem;
    }
    
    public void addATM(ATM atm){
        int atmID = bankMachines.size();
        atm.setID(atmID);

        CashFiller filler = new CashFiller();
        filler.fill(atm);

        bankMachines.put(atmID, atm);
    }

    @Override
    public void sendCashFiller(int atmID){
        ATM atm = bankMachines.get(atmID);

        CashFiller filler = new CashFiller();
        filler.fill(atm);
    }

    @Override
    public CustomersController getCustomersController() {
        return this.customersController;
    }

    @Override
    public CreditCardsController getCreditCardsController() {
        return this.creditCardsController;
    }

    @Override
    public TransactionsController getTransactionsController() {
        return this.transactionsController;
    }

}
