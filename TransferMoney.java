import java.util.HashMap;

public class TransferMoney {
    public static void TransferMoneyStep(String accountName, HashMap<String, Account> bankAccounts){
        InputReader inputReader = new InputReader();
        double amount = 0.0;

        Account accountTransferMoneyFrom = bankAccounts.get(accountName);
        OutputPrinter.printReturn(Menu.getEnterAccountName());      // Transfer to account name
        String accountNameTransferTo = inputReader.readString();
        Account accountTransferMoneyTo = bankAccounts.get(accountNameTransferTo);
        boolean accountExistsTo = bankAccounts.containsKey(accountNameTransferTo);
        if (accountExistsTo) {
            OutputPrinter.printReturn(Menu.TransferMoney());        // Transfer amount
            amount = inputReader.readDouble();
            accountTransferMoneyFrom.transferMoney(amount, accountTransferMoneyFrom, accountTransferMoneyTo);                    
        } else {
            OutputPrinter.printReturn(Menu.accountNotExists());
        }
    }
}
