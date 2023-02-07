package BankMachine;

public interface Bank {
    
    CustomersController getCustomersController();
    CreditCardsController getCreditCardsController();
    TransactionsController getTransactionsController();

}
