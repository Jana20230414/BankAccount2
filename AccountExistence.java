import java.util.HashMap;

public class AccountExistence {
    InputReader inputReader = new InputReader();

    public static void AccountExistenceCheck(Integer actionInput, String accountName, HashMap<String, Account>  bankAccounts){

        boolean accountExists = bankAccounts.containsKey(accountName);
        boolean requireExistingAccount = actionInput != 1;

        if(requireExistingAccount && !accountExists)
        {
            OutputPrinter.printReturn(Menu.accountNotExists());
            //continue;
            //break;
        }
        else if(!requireExistingAccount && accountExists)
        {
            OutputPrinter.printReturn(Menu.accountExists());
            //continue;
        }

    }
}
