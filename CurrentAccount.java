public class CurrentAccount extends Account {
    //Current account allows for overdraft, so I included that here up to N500,000.
    //An overdraft is when your bank lets you borrow money through your current account by taking out money than you
    //have in the account.
    // Although there's usually a charge for this.

    private final double overDraft = 500000;

    @Override //Overrides the withdrawal method in the super class (Account)
    //Withdraw the specified overdraft amount from the account balance in a thread-safe manner.
    //This method allows withdrawals within the overdraft limit.
    public synchronized void withdraw(double amount) {
        if (acctBlocked()) {
            throw new IllegalStateException("This account is blocked");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Important update: Overdraft amount must be positive");
        }
        if (amount > getAcctBalance() + overDraft) {
            throw new IllegalStateException("You have insufficient funds");
        }
        double newBalance = getAcctBalance() - amount; //This gets the balance after withdrawal of overdraft
        if (newBalance < 0){
            throw new IllegalStateException("Important Update : You have used your overdraft");
        }
        else {
            super.withdraw(amount); //withdraw method of the account class does the actual withdrawal of the overdraft
        }


    }
}
