package BankMachine;

public class Customer {
    private String nationalID;
    private String name;
    private String accountID;

    public Customer(String nationalID, String name, String accountID){
        this.nationalID = nationalID;
        this.name = name;
        this.accountID = accountID;
    }

    public String getName() {
        return this.name;
    }

    public String getAccountID() {
        return this.accountID;
    }

    public String getNationalID() {
        return this.nationalID;
    }

}
