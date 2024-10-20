package banking;
import java.io.IOException;
import javafx.collections.ObservableList;

public class Account {
    private ObservableList<Transaction> transactions;

    public Account(String filename) throws IOException {
        transactions = Transaction.readFromFile(filename);
    }

    public ObservableList<Transaction> getTransactions(){
        return transactions;
    }

    public double currentBalance() {
        double currentBalance = 0;
        for( Transaction eachTransaction : transactions){
            if (eachTransaction.isDebit() == false) {
                currentBalance -= eachTransaction.getAmount();
            } else {
                currentBalance += eachTransaction.getAmount();
            }
        } return currentBalance;
    }
    public double currentCredits() {

        double currentCredits = 0;
        for (Transaction eachTransaction : transactions) {
            if (eachTransaction.isDebit() == false) {
                currentCredits -= eachTransaction.getAmount();
            }
        }
        return currentCredits;
    }

    public double currentDebits() {

        double currentDebits = 0;
        for (Transaction eachTransaction : transactions) {
            if (eachTransaction.isDebit() == true) {
                currentDebits += eachTransaction.getAmount();
            }
        }
        return currentDebits;
    }

    }