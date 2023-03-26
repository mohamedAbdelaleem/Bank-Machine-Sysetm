package BankMachine;

import java.util.*;;

public class App {
    public static void main(String[] args){

        System.out.println("\t\t\tWelcome to Bank Masr");
        Bank bankSystem = BankMasr.getBankSystem();
        
        Scanner input = new Scanner(System.in);
        
        outer:
        while(true){
            mainMenu();
            System.out.print("Choose an option: ");
            int option = input.nextInt();
            switch(option){
                case 1:
                    System.out.print("Enter your national ID: ");
                    String nationalID = input.next();
                    System.out.print("Enter your name: ");
                    String name = input.nextLine();
                    if(bankSystem.getCustomersController().addCustomer(nationalID, name)){
                        System.out.println("Done!");
                        bankSystem.getCustomersController().customerDetails(nationalID);
                    }
                    break;
                case 2:
                    
            }
        }
        
    }

    public static void mainMenu(){
        System.out.println("\tMain Menu");
        System.out.println("1-Open new bank account");
        System.out.println("2-Open new credit card");
        System.out.println("3-Close credit card");
        System.out.println("4-ATM section");
        System.out.println("5-Exit");
    }
}
