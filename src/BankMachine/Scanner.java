package BankMachine;

public class Scanner {
    
    public boolean checkCard(int cardID, Bank bank){
        return bank.getCreditCardsController().searchCreditCard(cardID);
    }

    public CreditCard getCard(int cardID, Bank bank){
        return bank.getCreditCardsController().getCreditCard(cardID);
    }
}
