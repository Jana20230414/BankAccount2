public class Menu {

    private static String mainMenuTextation = "Action: 1 - Create an account, 2 - Delete account, 3 - Current Balance Statement , 4 - Accept money, 5 - Cashout, 6 - Money transfer (between accounts), 7 - End of transactions";
    private static String mainMenuOptionalNoAccount = "No account exists!";
    private static String mainMenuAccountExists = "The specified account already exists!";
    private static String mainMenuFinalText = "Thank you for the input." ;
    private static String mainMenuIncorrectEntry = "Incorrect entry. Please try again.";
    
    private static String accountEnterName = "Enter the account name: ";
    private static String accountBalance = "Account balance is ";

    private static String accountAcceptMoney = "What amount for the deposit? ";
    private static String accountSendMoney = "What amount to cashout? ";
    private static String accountLackOfMoney = "Lack of money in the account!";
    private static String enterCurrency = "Enter the currency of the deposited amount: ";
    private static String TransferMoney = "What amount to transfer? ";
    private static String accountDeletionNot = "Cannot be deleted! There is a non-zero amount in the account. ";
    private static String accountDeletion = "Account DELETED!  ";

    public static String getMainFinalText() {
        return mainMenuFinalText;
    }
    public static String getIncorrectEntry() {
        return mainMenuIncorrectEntry;
    }
    public static String getMainMenuText() {
        return mainMenuTextation;
    }
    public static String getEnterAccountName() {
        return accountEnterName;
    }
    public static String getBalance() {
        return (accountBalance);
    }
    public static String acceptMoney() {
        return (accountAcceptMoney);
    }
    public static String sendMoney() {
        return (accountSendMoney);
    }
    public static String accountNotExists() {
        return (mainMenuOptionalNoAccount);
    }
    public static String accountExists() {
        return (mainMenuAccountExists);
    }
    public static String accountLackOfMoney() {
        return (accountLackOfMoney);
    }
    public static String accountEnterCurrency() {
        return (enterCurrency);
    }
    public static String TransferMoney() {
        return (TransferMoney);
    }
    public static String accountDeletionNot() {
        return (accountDeletionNot);
    }
    public static String accountDeletion() {
        return (accountDeletion);
    }
}
