package BankMachine;

import java.io.*; 
import java.awt.Desktop;  

public class ReceiptsManager {
    
    private File receipt;


    public void printReceipt(){
      try {   
            if(!Desktop.isDesktopSupported()) {  
                System.out.println("not supported");  
                return;  
            }  
            Desktop desktop = Desktop.getDesktop();  
            if(receipt.exists()) {   
                desktop.open(receipt);
            }              
        }  
        catch(Exception e)  {  
            e.printStackTrace();  
        }
        this.resetReceipt();;
    }

    public void createWithdrawReceipt(Withdraw withdraw){
      try {
        receipt = new File("receipts" + withdraw.getID() + ".txt");
        if (receipt.createNewFile()) {
          String content = withdrawReceiptContent(withdraw);
          FileWriter receiptWriter = new FileWriter(receipt);
          receiptWriter.write(content);
          receiptWriter.close();
        }
      } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
    }
    
    public void createDepositReceipt(Deposit deposit){
      try {
        receipt = new File("receipts" + deposit.getID() + ".txt");
        if (receipt.createNewFile()) {
          String content = depositReceiptContent(deposit);
          FileWriter receiptWriter = new FileWriter(receipt);
          receiptWriter.write(content);
          receiptWriter.close();
        }
      } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
    }

    private String depositReceiptContent(Deposit deposit){
      String massage = "\t\tDeposit Transaction";
      massage += "\nTransaction: " + deposit.getID();
      massage += "\nStatus: ";
      
      if (deposit.getStatus()){
        massage += "\nSuccessful";
      }
      else{
        massage += "\nFailed";
      }
      
      massage += "\nAmount: " + deposit.getAmount();
      massage += "\nCurrent Balance: " + deposit.getCard().getBalance();

      return massage;
    }
    
    private String withdrawReceiptContent(Withdraw withdraw){
      String massage = "\t\tWithdraw Transaction";
      massage += "\nTransaction: " + withdraw.getID();
      massage += "\nStatus: ";
      
      if (withdraw.getStatus()){
        massage += "\nSuccessful";
      }
      else{
        massage += "\nFailed";
      }
      
      massage += "\nAmount: " + withdraw.getAmount();
      massage += "\nCurrent Balance: " + withdraw.getCard().getBalance();

      return massage;
    }

    public void resetReceipt(){
      this.receipt = null;
      String directoryPath = "receipts";

      File directory = new File(directoryPath);

      if (directory.isDirectory()) {
         File[] files = directory.listFiles();
         for (File file : files) {
            file.delete();
         }
      }
    }

}
