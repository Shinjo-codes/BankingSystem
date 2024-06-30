import java.util.HashMap;
import java.util.Map;

public class User {
    private String name;
    private final int userId;
    private Map<Integer, Account> accounts;

    //Initialize a new User
    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
        this.accounts = new HashMap<>();
    }
    //Getters
    public String getName() {
        return name;
    }

    public int getUserId() {
        return userId;
    }

    public Map<Integer, Account> getAccounts() {
        return accounts;
    }
    //Method to add user account
    public void addAccount(Account account){ //Adds an account to the user's accounts map
        accounts.put(account.getAcctNumber(), account);//Gets the specific account number for the account specified
    }
    //Method to check user balance
    public double checkBalance(int acctNumber){
       Account account = accounts.get(acctNumber);
       if(account == null){
           throw new IllegalStateException("This account cannot be found");
       }
       else {
           return account.getAcctBalance();
       }
    }
    //Method to block a user using a unique account number
    public void blockUser(int acctNumber){
        Account account = accounts.get(acctNumber);
        if (account != null){
            account.blockAccount();
        }
        else {
            throw new IllegalStateException("This account cannot be found");
        }
    }
    //Method to unblock a user using a unique account number
    public void unblockUser (int acctNumber){
        Account account = accounts.get(acctNumber);
        if (account != null){
            account.unblockAccount();
        }
        else {
            throw new IllegalStateException("This account cannot be found");
        }
    }
}
