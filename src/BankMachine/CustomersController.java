package BankMachine;

import java.util.*;

public class CustomersController {

    private HashMap<String, Customer> customers;
    private HashMap<String, Customer> nationalIDsCustomersMap;

    public CustomersController(){
        this.customers = new HashMap<String, Customer>();
        this.nationalIDsCustomersMap = new HashMap<String, Customer>();
    }

    private boolean validateNationalId(String id){
        
        for(char c: id.toCharArray()){
            if(!Character.isDigit(c)){
                return false;
            }
        }
    
        return id.length() == 6;
    }


    public boolean addCustomer(String nationalID, String name){

        if (! validateNationalId(nationalID)){
            System.out.println("\nInvalid National ID!\n");
            return false;
        }

        if (nationalIDsCustomersMap.containsKey(nationalID)){
            System.out.println("\nThis National ID is already exist!\n");
            return false;
        }
        
        int customersNum = customers.size();
        String newAccountID = nationalID.substring(2) + customersNum;

        Customer customer = new Customer(nationalID, name, newAccountID);
        customers.put(newAccountID, customer);
        this.nationalIDsCustomersMap.put(nationalID, customer);
        return true;
    }

    
    public boolean search(String accountID){
        return this.customers.containsKey(accountID);
    }

    public void customerDetails(String nationalID){
        Customer customer = nationalIDsCustomersMap.get(nationalID);
        if(customer == null){
            System.out.println("Invalid national ID!!");
            return;
        }
        System.out.println("Name: " + customer.getName() 
                            + " AccountID: " + customer.getAccountID());
    }

}
