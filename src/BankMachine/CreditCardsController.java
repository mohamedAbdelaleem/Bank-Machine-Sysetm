package BankMachine;

import java.time.LocalDateTime;
import java.util.*;

public class CreditCardsController {
    
    private Bank bankType;
    private HashMap<Integer, CreditCard> creditCards;
    private HashMap<Integer, LocalDateTime> deactivatedCards;   // mapping cards ids -> the date of activation 
    private HashMap<Integer, ArrayList<Attempt>> loginAttempts;

    public CreditCardsController(Bank bankType){
        this.creditCards = new HashMap<Integer, CreditCard>();
        this.deactivatedCards = new HashMap<Integer, LocalDateTime>();
        this.loginAttempts = new HashMap<Integer, ArrayList<Attempt>>();
        this.bankType = bankType;
    }

    private boolean validatePin(String pin){
        for(char ch: pin.toCharArray()){
            if(!Character.isDigit(ch)){
                return false;
            }
        }
        return pin.length() == 4;
    }

    public void createCreditCard(String accountID, String pin){
        if (!validatePin(pin)){
            System.out.println("Not a valid Pin!");
            return;
        }

        if(!bankType.getCustomersController().search(accountID)){
            System.out.println("Invalid Account ID!");
            return;
        }
        
        int cardID = creditCards.size() + 1;
        LocalDateTime validThru = LocalDateTime.now().plusYears(5);

        CreditCard card = new CreditCard(cardID, bankType, accountID, pin, validThru);
        creditCards.put(cardID, card);
        loginAttempts.put(cardID, new ArrayList<Attempt>());
        
        System.out.println("\nSuccessively Created New Credit Card");
        System.out.println("\nCredit Card ID is: " + cardID + "\tSave it for later usage");
        
    }
    
    public void closeCreditCard(String accountID, int cardID){
        if(!creditCards.containsKey(cardID)){
            System.out.println("Invalid card id!");
            return;
        }
        
        CreditCard card = creditCards.get(cardID);
        if(!card.getAccountID().equals(accountID)){
            System.out.println("Invalid Account id!");
            return;
        }

        int remainingBalance = card.getBalance();
        if(remainingBalance > 0){
            System.out.println("Receive The remaining balance: $" + remainingBalance);
        }
        
        creditCards.remove(cardID);
        System.out.println("Successively Closed The Credit Card");
    }


    public boolean searchCreditCard(int id){
        return creditCards.containsKey(id);
    }

    public CreditCard getCreditCard(int id){
        return creditCards.get(id);
    }

    private boolean isActive(int id){
        
        if (deactivatedCards.containsKey(id)){
            return false;
        }
        return true;
    }

    private boolean validateCard(CreditCard card){
        if (card.getValidThru().isAfter(LocalDateTime.now())){
            return true;
        }
        this.creditCards.remove(card.getId());
        return false;
    }

    private void activateCard(int id){
        this.deactivatedCards.remove(id);
    }

    private void deactivatedCard(int id, int numOfHours){
        if(deactivatedCards.containsKey(id)){
            return;
        }
        
        LocalDateTime dateOfActivation = LocalDateTime.now().plusHours(numOfHours);
        deactivatedCards.put(id, dateOfActivation);
        
    }

    public boolean authenticateCard(CreditCard card, String pin){

        if (!validateCard(card)){
            return false;
        }

        Attempt attempt = new Attempt(LocalDateTime.now());
        int cardID = card.getId();
        ArrayList<Attempt> cardAttempts = loginAttempts.get(cardID);

        if (card.getPin().equals(pin)){
            attempt.setStatus(true);

            if (!isActive(cardID)){
                LocalDateTime activationDate = deactivatedCards.get(cardID);
                if (!attempt.getDate().isBefore(activationDate)){
                    this.activateCard(cardID);
                }
                else{
                    return false;
                }
            }
            cardAttempts.clear();
            return true;
        
        }
        
        else{
            attempt.setStatus(false);
            if (!isActive(cardID)){
                return false;
            }
            if (cardAttempts.size() == 2){
                this.deactivatedCard(cardID, 24);
            }
            cardAttempts.add(attempt);
            return false;
        }
    }

}
