import java.util.Scanner;
import java.lang.*;

/**
 * InputReader reads typed text input from the standard text terminal. 
 * The text typed by a user is returned.
 * 
 * @author     Andrei Cruceru
 * @version    13112020
 */
public class InputReader
{
    private final Scanner reader;

    /**
     * Create a new InputReader that reads text from the text terminal.
     */
    public InputReader()
    {
        reader = new Scanner(System.in);
    }

    /**
     * Read a line of text from standard input (the text terminal),
     * and return it as a String.
     *
     * @return  A String typed by the user.
     */
    public String getString()
    {
        String string ="";
        while(string.length() == 0)
        {
            
            System.out.print("> ");         // print prompt
            string = reader.nextLine();

            if(string.length() == 0)
                System.out.println("\n        Cannot leave blank!\n");
        }

        return string;
    }
      
    /**
     * Read a line from standard input (the text terminal),
     * and return it as a Integer.
     *
     * @return  A Integer typed by the user. 
     */
    public int getInteger()
    {
        int number = 0;
        boolean valid = false;

        while(!valid)
        {
            String string = getString();
            try
            {
                number = Integer.parseInt(string);
                valid = true;
            }
            catch(Exception e)
            {
                System.out.println("\n        Not a valid number!\n");
            }
        }
        
        return number;
    }
    
    public double getDouble()
    {
        double number = 0;
        boolean valid = false;

        while(!valid)
        {
            String string = getString();
            try
            {
                number = Double.parseDouble(string);
                valid = true;
            }
            catch(Exception e)
            {
                System.out.println("\n        Not a valid price!\n");
            }
        }
        
        return number;
    }
}
    

