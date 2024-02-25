package src;

public class AccountDatabase {
    private src.Account[] accounts;

    public AccountDatabase() {
        // Sample accounts (replace with your account system)
        accounts = new src.Account[2];
        accounts[0] = new src.Account("user123", "1234");
        accounts[1] = new src.Account("recipientUser", "4321");
    }

    public src.Account getAccount(String userId, String pin) {
        for (src.Account account : accounts) {
            if (userId.equals(account.getUserId()) && pin.equals(account.getPin())) {
                return account;
            }
        }
        return null;
    }

    public src.Account getAccount(String userId) {
        for (src.Account account : accounts) {
            if (userId.equals(account.getUserId())) {
                return account;
            }
        }
        return null;
    }
}

