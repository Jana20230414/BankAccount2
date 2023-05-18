import java.util.HashMap;

public class AccountExistence {
    InputReader inputReader = new InputReader();

    public static Boolean AccountExistenceCheck(Integer actionInput, String accountName, HashMap<String, Account>  bankAccounts){

        boolean accountExists = bankAccounts.containsKey(accountName);
        boolean requireExistingAccount = actionInput != 1;

        if(requireExistingAccount && !accountExists)
        {
            OutputPrinter.printReturn(Menu.accountNotExists());
            return false;
        }
        else if(!requireExistingAccount && accountExists)
        {
            OutputPrinter.printReturn(Menu.accountExists());
            return false;
        }

        return true;

    }
}
