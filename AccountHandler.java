import java.util.ArrayList;

public class AccountHandler {
    static ArrayList<String> accountStorage = new ArrayList<String>();
    static ArrayList<Account> accountStorageObjects = new ArrayList<Account>();
    
    public static void AccountHandlerAdd(String paymentTransfer){
        accountStorage.add(paymentTransfer);
    }
    public static void AccountHandlerAddAccount(Account paymentTransfer){
        accountStorageObjects.add(paymentTransfer);
    }

    public static void AccountHandlerStatement(){
        for (String i : accountStorage) {
            System.out.println(i);
        }
    }
}
