import java.time.LocalDateTime;

public class Transaction {
    private final String type;
    private final double amount;
    private final LocalDateTime timeOfTransaction;

    //Constructors
    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.timeOfTransaction = LocalDateTime.now();
    }

    //Getters
    public double getAmount() {
        return amount; //Returns the amount of the transaction (Withdrawal or Deposit)
    }

    public String getType() {
        return type; //Returns the type of the transaction (Withdrawal or Deposit)
    }

    public LocalDateTime getTimeOfTransaction() {
        return timeOfTransaction; //Returns the time of the transaction (Withdrawal or Deposit)
    }

}
