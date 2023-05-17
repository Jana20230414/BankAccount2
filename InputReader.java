import java.util.Scanner;
public class InputReader {
    int scanInt = 0;
    Double scanDouble = 0.0;
    Scanner scanner = new Scanner(System.in);
    String newString = "";
    
    public Integer readInteger() {
        if(scanner.hasNextInt()) {
            scanInt = scanner.nextInt();
        } else {
            System.out.println(Menu.getIncorrectEntry());
            return 0;
        }  
        if ((scanInt < 1) || (scanInt > 7)) {
            System.out.println(Menu.getIncorrectEntry());
            return 0;
        }
        return scanInt;
    }

    public String readString() {
        return scanner.next();
    }

    public Double readDouble() {  
        if (scanner.hasNextDouble() ){
            scanDouble = scanner.nextDouble();
            return scanDouble;
        } else{
            return 0.0;
        }  
        
    }

}
