import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class LoggingTester {  

        static Logger logger = Logger.getLogger(LoggingTester.class.getName());  
        static private FileHandler fh = null;  
    
        public static void open() {
            //just to make our log file nicer :)
            SimpleDateFormat format = new SimpleDateFormat("YYYY-M-d_HHmmss");
            try {
                fh = new FileHandler("logs/LogFile_BankAccount_"
                    + format.format(Calendar.getInstance().getTime()) + ".log");
            } catch (Exception e) {
                e.printStackTrace();
            }
    
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);
            logger.setUseParentHandlers(false);
        }

        public static void closeLog() {
            logger = null;
        }
    
        public static void doLogging() {
            logger.info("info msg");
            logger.severe("error message");
            logger.fine("fine message"); 
        }

        // public void errorLogging(String info, String account, double amount, String currency){
        //     logger.severe("Error message:  " + "Action: " + info + "  Account: " + account + ", Amount: " + amount + " " + currency);
        // }
       
        // public void writeLogging(String info) {
        //     logger.info("Info message general:  " + info);
        // }
        
    
    
}
