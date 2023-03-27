package BankMachine;

import java.util.*;;

public class App {
    public static void main(String[] args){

        System.out.println("\t\t\tWelcome to Bank Masr");
        Bank bankSystem = BankMasr.getBankSystem();
        ATM bankMachine = new ATM(bankSystem);
        bankSystem.addATM(bankMachine);

        Scanner input = new Scanner(System.in);
        
        outer:
        while(true){
            mainMenu();
            System.out.print("Choose an option: ");
            int option = input.nextInt();
            String nationalID, name,accountID, pin;
            int cardID;
            switch(option){
                case 1:

                    System.out.print("Enter your national ID:");
                    nationalID = input.next();
                    System.out.print("Enter your name:");
                    name = input.next();
                    System.out.println();

                    if(bankSystem.getCustomersController().addCustomer(nationalID, name)){
                        System.out.println("Done!");
                        bankSystem.getCustomersController().customerDetails(nationalID);
                    }
                    break;
                case 2:
                    System.out.print("Enter your Account ID: ");
                    accountID = input.next();
                    
                    System.out.print("Enter Pin: ");
                    pin = input.next();
                    System.out.println();

                    bankSystem.getCreditCardsController().createCreditCard(accountID, pin);
                    break;
                
                case 3:
                    System.out.print("Enter your Account ID: ");
                    accountID = input.next();
                    
                    System.out.print("Enter Card ID: ");
                    cardID = input.nextInt();
                    System.out.println();

                    bankSystem.getCreditCardsController().closeCreditCard(accountID, cardID);
                    break;

                
                case 4:
                    System.out.print("Enter Card ID: ");
                    cardID = input.nextInt();

                    if(!bankMachine.scan(cardID)){
                        System.out.println("\nInvalid cardID!");
                        break;
                    }

                    System.out.print("Enter Pin: ");
                    pin = input.next();

                    if(!bankMachine.authenticate(pin)){
                        System.out.println("Invalid Try!");
                        break;
                    }

                    atmOptionsloop:
                    while (true) {
                        AtmOptions();
                        System.out.print("Choose an option: ");
                        option = input.nextInt();
                        int amount;
                        switch(option){
                            case 1:
                                System.out.print("Enter amount (between 20 and 5000): ");
                                amount = input.nextInt();
                                System.out.println(amount);
                                if(bankMachine.withdraw(amount)){
                                    if(needReceipt()){
                                        bankMachine.printReceipt();
                                    }
                                }
                                break;
                            
                            case 2:
                                System.out.print("Enter amount (between 20 and 5000): ");
                                amount = input.nextInt();
                                System.out.println(amount);
                                if(bankMachine.deposit(amount)){
                                    if(needReceipt()){
                                        bankMachine.printReceipt();
                                    }
                                }
                                break;
                            
                            case 3:
                                bankMachine.printBalance();
                                break;

                            case 4:
                                break atmOptionsloop;
                        }

                        System.out.println("Do you want to perform another transaction?");
                        System.out.println("1-Yes");
                        System.out.println("2-NO");
                        option = input.nextInt();
                        if(option == 2){
                            break;
                        }

                    }
                    
                    break;
                case 5:
                    break outer;
                    
            }
        }
        
    }

    private static void mainMenu(){
        System.out.println("\n\tMain Menu");
        System.out.println("1-Open new bank account");
        System.out.println("2-Open new credit card");
        System.out.println("3-Close credit card");
        System.out.println("4-ATM section");
        System.out.println("5-Exit");
    }

    private static void AtmOptions(){
        System.out.println("\n1-Withdraw");
        System.out.println("2-Deposit");
        System.out.println("3-Check Balance");
        System.out.println("3-Exit");
        
    }

    private static boolean needReceipt(){
        System.out.println("\nDo you want a receipt?");
        System.out.println("1-Yes");
        System.out.println("2-NO");

        Scanner input = new Scanner(System.in);

        return input.nextInt() == 1;

    }

}
