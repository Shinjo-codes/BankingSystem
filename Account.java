import java.util.ArrayList;
import java.util.List;

        public abstract class Account {
    //Declares an abstract class named Account, meaning this class cannot be instantiated
        // directly and is intended to be subclassed
        private static int acctCounter  = 10000; //A static counter that generates unique account numbers starting from 10000.
            //The account has to be five digits minimum.
            //AccountCounter is a static field while the other fields are instance fields.
        private final int acctNumber; //A unique account number assigned to each account.
            // The final keyword indicates that this value cannot be changed once assigned.
        private double acctBalance;
        private boolean acctBlocked;
        private List<Transaction> transactionHistory; //A list that stores the transaction history of the account.

            //Constructors
        public Account() {
            this.acctNumber = acctCounter++;
            this.acctBalance = 0.0;
            this.acctBlocked = false;
            this.transactionHistory = new ArrayList<>();
        }
            //Getters
            public static int getAcctCounter() {
                return acctCounter;
            }

            public int getAcctNumber() {
                return acctNumber;
            }

            public double getAcctBalance() {
                return acctBalance;
            }

            public boolean isAcctBlocked() {
                return acctBlocked;
            }

            public List<Transaction> getTransactionHistory() {
                return transactionHistory;
            }

                //Add the specified amount to the account balance in a thread-safe manner.
        public synchronized void deposit(double amount) {
            if (acctBlocked) {
                throw new IllegalStateException("This account is blocked");
            }
            if (amount <= 0) {
                throw new IllegalArgumentException("Important update: Deposit amount must be positive");
            }
            acctBalance += amount; //Increments the account balance with the amount deposited

            transactionHistory.add(new Transaction("Deposit", amount)); //adds a new transaction to the list of transactions
        }
            //Withdraw the specified amount to the account balance in a thread-safe manner.
        public synchronized void withdraw(double amount) {
            if (acctBlocked) {
                throw new IllegalStateException("This account is blocked");
            }
            if (amount <= 0) {
                throw new IllegalArgumentException("Important update: Withdrawal amount must be positive");
            }
            if (amount > acctBalance) {
                throw new IllegalStateException("You have insufficient funds");
            }
            acctBalance -= amount; //Decrements the account balance with the amount withdrawn
            transactionHistory.add(new Transaction("Withdrawal", amount));
        }
            //Transfers the specified amount from one account to another a thread-safe manner.
        public synchronized void transfer(Account toAccount, double amount) {
            if (acctBlocked || toAccount.acctBlocked()) {
                throw new IllegalStateException("One or both accounts are blocked");
                // Throws an exception if either the source or destination account is blocked.
            }
            withdraw(amount);
            toAccount.deposit(amount);
            transactionHistory.add(new Transaction("Transfer to " + toAccount.getAcctNumber(), amount));
            //Records the withdrawal and deposits transaction (during transfer) in the transaction history.
        }

            boolean acctBlocked() {
                return false;
            }

            //Block and Unblock account methods
        public void blockAccount() {
            acctBlocked = true; //sets acctIsBlocked to 'true'
        }

        public void unblockAccount() {
            acctBlocked = false; //sets acctIsBlocked to 'false'
        }
    }
