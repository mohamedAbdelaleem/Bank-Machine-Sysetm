package BankMachine;

import java.util.*;

public class CustomersController {

    private HashMap<String, Customer> customers;
    private HashMap<String, Customer> nationalIDsCustomersMap;


    private boolean validateNationalId(String id){
        
        for(char c: id.toCharArray()){
            if(!Character.isDigit(c)){
                return false;
            }
        }
    
        return id.length() == 6;
    }


    public void addCustomer(String nationalID, String name){

        if (! validateNationalId(nationalID)){
            System.out.println("Invalid National ID!");
            return;
        }

        if (nationalIDsCustomersMap.containsKey(nationalID)){
            System.out.println("This National ID is already exist!");
            return;
        }
        
        int customersNum = customers.size();
        String newAccountID = nationalID.substring(2) + customersNum;

        Customer customer = new Customer(nationalID, name, newAccountID);
        customers.put(newAccountID, customer);
    }

    public boolean search(String accountID){
        return this.customers.containsKey(accountID);
    }


}
