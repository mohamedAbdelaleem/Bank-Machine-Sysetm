package BankMachine;

public interface Bank {
    
    CustomersController getCustomersController();
    CreditCardsController getCreditCardsController();
    TransactionsController getTransactionsController();

    void sendCashFiller(int atmID);
    void addATM(ATM atm);

}
