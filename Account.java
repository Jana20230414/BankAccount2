public class Account {
    String accountName = "";
    String accountCurrencyCZK = "CZK";       // pomocná vztažná měna
    String accountCurrencyMain = "CZK";   // požadovaná měna klientem
    double accountAmount = 0;
    double accountAmountMain = 0;
    Boolean deletion = false;
    double amount = 0.0;
    InputReader inputReader = new InputReader();

    public Account(String AccountName) {
      accountName = AccountName;
    }
      
    public String getAccountName() {     
      return accountName;  
    }
    
    public static double roundAmount(double value, int places) {
      if (places < 0) throw new IllegalArgumentException();
      long factor = (long) Math.pow(10, places);
      value = value * factor;
      long tmp = Math.round(value);
      return (double) tmp / factor;
    }

    public String getAccountBalance() {
      double roundAmount = roundAmount (accountAmountMain, 2);
      OutputPrinter.printReturn(Menu.getBalance() + roundAmount + "  " + accountCurrencyMain); 
      return (roundAmount + " " + accountCurrencyMain);
    }

    public void NewAccount(String currencyNew){
      currencyNew = currencyNew.toUpperCase();
      this.accountCurrencyMain = currencyNew;   
      OutputPrinter.printReturn("New Account is : " + this.accountName + " , Currency is " + this.accountCurrencyMain);                       
      LoggingTester.logger.info("New Account is : " + "  Account: " + this.accountName + ", Amount: " + accountAmountMain + " " + accountCurrencyMain);     
    }

    public void AcceptMoneyGlobal(){
      OutputPrinter.printReturn(Menu.acceptMoney());
      amount = inputReader.readDouble();
      if (amount > 0.0) {
          OutputPrinter.printReturn(Menu.accountEnterCurrency());
          String currency = inputReader.readString();
          CurrencyArray currencyExRate = CurrencyArray.findByName(currency); 
          if(currencyExRate != CurrencyArray.Invalid)  {
              double valueExchangeRate = currencyExRate.getValue();
              amount = amount * valueExchangeRate;
              AcceptMoney(amount); 
          } else {
              System.out.println(Menu.getIncorrectEntry());    
          }
      } else {
          System.out.println(Menu.getIncorrectEntry());
      }
    }

    public void AcceptMoney(double amount) {
      accountAmount += amount;
      CurrencyArray currencyExRate = CurrencyArray.valueOf(this.accountCurrencyMain);
      double valueExchangeRate = currencyExRate.getValue();
      accountAmountMain = accountAmount / valueExchangeRate;
      //OutputPrinter.printReturn(Menu.getBalance() + this.getAccountBalance());
      this.getAccountBalance();
      LoggingTester.logger.info("Accept money:  " + "  Account: " + this.accountName + ", Amount: " + accountAmountMain + " " + accountCurrencyMain);   
      AccountHandler.AccountHandlerAdd("Income: " + this.accountName + ", Amount: " + accountAmountMain + " " + accountCurrencyMain);
      //AccountHandler.AccountHandlerAddAccount(this.accountName);
    }

    public void SendMoney() {
      OutputPrinter.printReturn(Menu.sendMoney());
      amount = inputReader.readDouble();
      if (amount > accountAmount) {
        System.out.println(Menu.accountLackOfMoney());
      }
      else {
        accountAmount -= amount;
        CurrencyArray currencyExRate = CurrencyArray.valueOf(this.accountCurrencyMain);
        double valueExchangeRate = currencyExRate.getValue();
        accountAmountMain = accountAmount / valueExchangeRate;
        OutputPrinter.printReturn(Menu.getBalance() + this.getAccountBalance());
        LoggingTester.logger.info("Send money:  " + "  Account: " + this.accountName + ", Amount: " + accountAmountMain + " " + accountCurrencyMain); 
        AccountHandler.AccountHandlerAdd("Outcome: " + this.accountName + ", Amount: " + accountAmountMain + " " + accountCurrencyMain);
      }
    }
    
    public void transferMoney(double amount, Account accountFrom, Account accountTo) {
      if (amount > accountFrom.accountAmount) {
          System.out.println(Menu.accountLackOfMoney()); 
          LoggingTester.logger.severe("Lack of money in the account!  " + "  Account: " + this.accountName + ", Amount: " + accountAmountMain + " " + accountCurrencyMain); 
      } else {
          accountFrom.SendMoney();
          accountTo.AcceptMoney(amount);
      }
    }

    public boolean accountDeletion() {
      if (accountAmount > 0) {
          System.out.println(Menu.accountDeletionNot());
          LoggingTester.logger.severe("Cannot be deleted!  " + "  Account: " + this.accountName + ", Amount: " + accountAmountMain + " " + accountCurrencyMain); 
          return false;
      } else {
          OutputPrinter.printReturn(Menu.accountDeletion() + this.getAccountName());
          LoggingTester.logger.info("Account DELETED!  " + "  Account: " + this.accountName + ", Amount: " + accountAmountMain + " " + accountCurrencyMain); 
          return true; 
      }

    }


}