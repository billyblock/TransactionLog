package banking;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Transaction {
    public static Object readFromFile;
    private String accountName;
    private String processedDate;
    private String description;
    private String checkNumber;
    private boolean isDebit;
    private double amount;

public Transaction(String name, String date, String desc, String aCheckNumber, boolean isItDebit, double anAmount) {
    accountName = name;
    processedDate = date;
    description = desc;
    checkNumber = aCheckNumber;
    isDebit = isItDebit;
    amount = anAmount;
    }

public static ObservableList<Transaction> readFromFile(String fileName) throws IOException {
    Scanner input = new Scanner(new FileInputStream("checking_transactions.csv"));
    input.useDelimiter("[,\n]|\r\n");
    ObservableList<Transaction> transactions = 
    FXCollections.observableArrayList();
    input.nextLine();
    while(input.hasNext()){
        String name = input.next();
        String date = input.next();
        String desc = input.next();
        String aCheckNumber = input.next();
        boolean isItDebit = input.next().equals("Debit");
        double anAmount = input.nextDouble();
        transactions.add(new Transaction(name, date, desc, aCheckNumber, isItDebit, anAmount));
    }
    input.close();
    return transactions; 
}

    public String toString(){
        String dateAndDesc = processedDate + " : " + description;
        return dateAndDesc;
    }

    public String detailString(){
        String newLine = System.getProperty("line.separator");
        String dateAndAmount = " Date: " + processedDate + " Amount: " + amount;
        String desc = " Description: " + description;
        return dateAndAmount + newLine + desc;
    }

    public boolean isDebit() {
        return isDebit;
    }

    public double getAmount() {
        return amount;
    }
}
