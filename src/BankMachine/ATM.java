package BankMachine;

public class ATM {
    
    private int id;
    private Bank bankType;
    private int cashAmount;
    private CreditCard currCard;
    private ReceiptCreator receiptCreator;

    public ATM(Bank bankType){
        this.bankType = bankType;
    }
    
    public boolean scan(int cardID){
        CardsScanner scanner = new CardsScanner();
        if (!scanner.checkCard(cardID, this.bankType)){
            return false;
        }
        this.currCard = scanner.getCard(cardID, this.bankType);
        return true;

    }

    public boolean authenticate(String pin){
        if(this.currCard == null){
            return false;
        }

        if(!currCard.getBankType().getCreditCardsController().authenticateCard(currCard, pin)){
            this.out();
            return false;
        }

        return true;
    }

    public boolean withdraw(int amount){
        if(this.currCard == null){
            return false;
        }

        if (!this.validateAmount(amount)){
            System.out.println("Invalid Entry!\nMin is $20\tMax is $5000");
            return false;
        }


        Withdraw transaction = currCard.getBankType().getTransactionsController()
                                    .processWithdraw(currCard, amount);
        
        if (cashAmount < amount){
            transaction.setStatus(false);
            this.requestCash();
        }
        else{
            transaction.setStatus(true);
        }

        currCard.getBankType().getTransactionsController().saveTransaction(transaction);
        this.receiptCreator.createWithdrawReceipt(transaction);;
        return true;
    }

    public boolean deposit(int amount){
        if(this.currCard == null){
            return false;
        }
        
        if (!this.validateAmount(amount)){
            System.out.println("Invalid Entry!\nMin is $20\tMax is $5000");
            return false;
        }
        
        Deposit transaction = currCard.getBankType().getTransactionsController()
        .processDeposit(currCard, amount);
        
        transaction.setStatus(true);
        currCard.getBankType().getTransactionsController().saveTransaction(transaction);
        this.receiptCreator.createDepositReceipt(transaction);
        return true;
    }
    
    public void printReceipt(){
        this.receiptCreator.printReceipt();
    }

    public void out(){
        System.out.println("Get Your Card..");
        this.currCard = null;
        this.receiptCreator.resetReceipt();
    }

    private void requestCash(){
        this.bankType.sendCashFiller(this.id);
    }

    private boolean validateAmount(int amount){
        return amount > 5000 || amount < 20;
    }

    public void setID(int id){
        this.id = id;
    }

    public void setCash(int amount){
        this.cashAmount = amount;
    }

}
