import java.util.HashMap;

public class AccountFactory {

    public static void buildAccount(String accountName, HashMap<String, Account> bankAccounts){
        InputReader inputReader = new InputReader();

        OutputPrinter.printReturn(Menu.accountEnterCurrency());
        String currencyNew = inputReader.readString();
        CurrencyArray currencyCheck = CurrencyArray.findByName(currencyNew);    // kontrola existence měny v seznamu
        if(currencyCheck != CurrencyArray.Invalid){
            Account newAccount = new Account(accountName);
            bankAccounts.put(accountName, newAccount);  
            newAccount.NewAccount(currencyNew);  
        }  else { 
            System.out.println(Menu.getIncorrectEntry()) ;                        
        }
        
    };

}