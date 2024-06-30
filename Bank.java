import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<Integer, Account> accounts;
    private Map<Integer, User> users;

    //Initialize both accounts and users field
    public Bank() {
        this.accounts = new HashMap<>();
        this.users = new HashMap<>();
    }

    //Getters for the fields
    public Map<Integer, Account> getAccounts() {
        return accounts;
    }

    public Map<Integer, User> getUsers() {
        return users;
    }

    //Method to create a new user
    public User newUser(int userId, String name) { //Creates a new user and adds them to the users map.
        User userDefault = new User(userId, name);//Creates a new User object
        users.put(userId, userDefault);//Adds the user to the users map.
        return userDefault;//Returns the created User
    }

    //Method to create a new savings account
    public Account newSavingsAcct(User user) { //Creates a savings account for the specified user.
        Account account = new SavingsAccount(); //Creates a new SavingsAccount object.
        user.addAccount(account); //Adds the account to the user's accounts.
        accounts.put(account.getAcctNumber(), account);//Adds the account to the accounts map.
        return account;
    }

    //Method to create a new current account
    public Account newCurrentAcct(User user) { //Creates a current account for the specified user.
        Account account = new CurrentAccount(); //Creates a new CurrentAccount object.
        user.addAccount(account); //Adds the account to the user's accounts.
        accounts.put(account.getAcctNumber(), account); //Adds the account to the accounts map.
        return account;
    }
    //Method to block an account
    public void blockAccount(int acctNumber){ //Blocks the specified account using its account number
        Account account = accounts.get(acctNumber); //Retrieves the account with the given account number.
        if (account != null){ //Blocks the account if it exists.
            account.blockAccount();
        }
        else {
            throw new IllegalStateException("This account cannot be found");
            //Throws an exception if the account is not found.
        }
    }
    //Method to unblock an account
    public void unblockAccount (int acctNumber){ //Unblocks the specified account.
        Account account = accounts.get(acctNumber);
        if (account != null){ //Unblocks the account if it exists.
            account.unblockAccount();
        }
        else {
            throw new IllegalStateException("This account cannot be found");
        }
    }
}
