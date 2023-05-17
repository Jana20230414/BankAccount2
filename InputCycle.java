import java.util.HashMap;

public class InputCycle {
        public HashMap<String, Account> bankAccounts = new HashMap<>();

        InputReader inputReader = new InputReader();

        public void cyclusTransactions() {
            while (true)
            {   
                OutputPrinter.printReturn(Menu.getMainMenuText());
                int actionInput = inputReader.readInteger();     
                
                // while (actionInput == 0) {
                //     actionInput = inputReader.readInteger();   
                // }
                // if (actionInput == 7){
                //     AccountHandler.AccountHandlerStatement();
                //     break;
                // }

                actionInput = inputReader.readInteger();     
                MenuActions nameOfActions = MenuActions.findNameByValue(actionInput);
                if (nameOfActions.END_PROGRAM == nameOfActions){
                    AccountHandler.AccountHandlerStatement();
                    break;
                }
                
                OutputPrinter.printReturn(Menu.getEnterAccountName());
                String accountName = inputReader.readString();

                boolean accountExists = bankAccounts.containsKey(accountName);
                boolean requireExistingAccount = actionInput != 1;

                if(requireExistingAccount && !accountExists)
                {
                    OutputPrinter.printReturn(Menu.accountNotExists());
                    continue;
                }
                else if(!requireExistingAccount && accountExists)
                {
                    OutputPrinter.printReturn(Menu.accountExists());
                    continue;
                }
                
                switch (nameOfActions) {
                    case CREATE_ACCOUNT:                   
                        AccountFactory.buildAccount(accountName, bankAccounts);
                        break;       
                    case DELETE_ACCOUNT:             
                        Account accountToDeletion = bankAccounts.get(accountName);
                        if (accountToDeletion.accountDeletion()) {
                            bankAccounts.remove(accountName);
                        } 
                        break;
                    case BALANCE_ACCOUNT:               
                        Account accountBalance = bankAccounts.get(accountName);
                        accountBalance.getAccountBalance();
                        break;
                    case ACCEPT_MONEY:                
                        Account accountToAcceptMoney = bankAccounts.get(accountName);
                        accountToAcceptMoney.AcceptMoneyGlobal();
                        break;
                    case WITHDRAWAL:              
                        Account accountToSendMoney = bankAccounts.get(accountName);
                        accountToSendMoney.SendMoney();
                        break;
                    case TRANSFER_MONEY:      
                        TransferMoney.TransferMoneyStep(accountName, bankAccounts);
                        break;
                    case END_PROGRAM:      
                        AccountHandler.AccountHandlerStatement();
                        break;

                }
                
            }
        } 
 

}
