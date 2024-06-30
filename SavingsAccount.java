public class SavingsAccount extends Account{
    private static final double interestRate = 0.2275; //sets interest rate at 22.75% per annum

    //method to apply interest rate to savings account
    public void applyInterest(){
        double interest = getAcctBalance() * interestRate; //Calculates the interest based on the current balance.
        deposit(interest); // Deposits the calculated interest into the account.

    }
}
