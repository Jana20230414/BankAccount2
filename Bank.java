public class Bank {
    
  public static void main(String[] args) {

    LoggingTester.open();

    InputCycle cycle = new InputCycle();    
    cycle.cyclusTransactions();    
    
    System.out.println(Menu.getMainFinalText());

    LoggingTester.closeLog();
}


}