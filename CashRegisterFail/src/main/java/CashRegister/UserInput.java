package CashRegister;
import java.util.Scanner;
public class UserInput {
    Scanner readIn = new Scanner(System.in);
    String askUserFor; // This will be output before the user input.
    String informUserError; // This will be output if user did something wrong.


    // Constructor
    public UserInput()   {

    }

    // Constructor 2
    public UserInput(String input, String error)   {
        setStrings(input, error);
    }

    /*
    ***********************
    *       METHODS       *
    ***********************
    */

    // Returns an integer
    public int readInt(String input, String error)    {
        setStrings(input, error);
        return Integer.parseInt(getNumber());
    }

    // Returns a String
    public String readString(String askInput, String error)  {
        String userInput;
        setStrings(askInput, error);

        do {
            System.out.print(this.askUserFor);
            userInput = readIn.nextLine();
            if(userInput == null || userInput.isBlank() || userInput.isEmpty())
                System.out.println(this.informUserError);
        } while(userInput == null || userInput.isBlank() || userInput.isEmpty());
        return userInput;
    }

    // Returns a double
    public double readDouble(String input, String error) {
        setStrings(input, error);
        return Double.parseDouble(getNumber());
    }

    // Gets user input as a number
    public String getNumber()   {
        String input;
        do {
            System.out.print(this.askUserFor);
            input = readIn.nextLine();
            if(isNumber(input) == false)
                System.out.println(this.informUserError);
        } while(isNumber(input) == false);
        return input;
    }

    // Checks if input is a number
    boolean isNumber(String number)   {
        if(number == null) {
            return false;
        } // skipping else since return would stop the method.
        try {
            double stringToDouble = Double.parseDouble(number);
        }
        catch(NumberFormatException error)  {
            return false;
        }
        return true;
    }

    // Gets userInput for menu and checks if it's valid.
    public int getUserOption(int maxValue, String input, String error)  {
        int userOption;
        setStrings(input, error);
        do {
            userOption = readInt(input, error);
        } while(userOption < 0 || userOption > maxValue);
        return userOption;
    }

    // Sets inputMessage and outputError
    public void setStrings(String input, String error)  {
        this.askUserFor = input;
        this.informUserError = error;
    }
}
