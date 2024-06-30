public class Main {
    public static void main(String[] args) {
        //Create a bank
        Bank bank = new Bank();

        //Create new users
        User user1 = bank.newUser(101, "Mofe Damijo");
        User user2 = bank.newUser(102, "Gift Ojele");

        //Create new accounts
        Account mofeSavings = bank.newSavingsAcct(user1);
        Account giftCurrent = bank.newCurrentAcct(user2);

        //Deposit funds
        mofeSavings.deposit(478.22);
        giftCurrent.deposit(320.43);

        System.out.println("Mofe's savings account balance is " + mofeSavings.getAcctBalance());
        System.out.println("Gift's current account balance is " + giftCurrent.getAcctBalance());

        //Transfer funds
        mofeSavings.transfer(giftCurrent, 100.43);

        System.out.println("Mofe's savings account balance is " + mofeSavings.getAcctBalance());
        System.out.println("Gift's current account balance is " + giftCurrent.getAcctBalance());

        mofeSavings.transfer(giftCurrent, 100.43);
        System.out.println("Mofe's savings account balance is " + mofeSavings.getAcctBalance());
        System.out.println("Gift's current account balance is " + giftCurrent.getAcctBalance());

        //Print transaction history
//        String mofeTransactions = mofeSavings.getTransactionHistory().toString();
//        System.out.println(mofeTransactions);
        System.out.println("Mofe's transactions:");
        for (Transaction m : mofeSavings.getTransactionHistory()) {
            System.out.println(m.getType() + " of " + m.getAmount() + " on " + m.getTimeOfTransaction());

            System.out.println("Gift's transactions:");
            for (Transaction g : giftCurrent.getTransactionHistory()) {
                System.out.println(g.getType() + " of " + g.getAmount() + " on " + g.getTimeOfTransaction());

                //Block Account
                bank.blockAccount(mofeSavings.getAcctNumber());
//                System.out.println("Withdrawal failed: " + mofeSavings.isAcctBlocked().getMessage());
                mofeSavings.transfer(giftCurrent, 100.43);

                //Unblock Account
                bank.unblockAccount(mofeSavings.getAcctNumber());
                mofeSavings.transfer(giftCurrent, 100.43);
                System.out.println("Mofe's balance is " + user1.checkBalance(mofeSavings.getAcctNumber()));

            }
        }
    }
}
