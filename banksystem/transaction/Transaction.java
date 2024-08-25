package transaction;

import java.time.LocalDateTime;

public class Transaction {
    private int transactionId;
    private int accountID;
    private String type;
    private double amount;
    private LocalDateTime timestamp;

    public Transaction(int transactionId, int accountID, String type, double amount, LocalDateTime timestamp){
        this.transactionId = transactionId;
        this.accountID = accountID;
        this.type = type;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Transaction [transactionId=" + transactionId + ", accountID=" + accountID + ", type=" + type
                + ", amount=" + amount + ", timestamp=" + timestamp + "]";
    }

    
}
