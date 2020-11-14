import java.util.HashSet;
import java.util.Scanner;

/**
 * InputReader reads typed text input from the standard text terminal. 
 * The text typed by a user is returned.
 * 
 * @author     Andrei Cruceru
 * @version    13112020
 */
public class InputReader
{
    private Scanner reader;
    
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
        System.out.print("> ");         // print prompt
        String string = reader.nextLine();

        string = validateString(string);
        
        return string;
    }
    
    /**
     * Validate the user input.
     * @param string is the input type string. 
     * @return the string after validation.
     */
    private String validateString(String string)
    {
        while (string.length() == 0)
        { 
            System.out.println("\n    Cannot leave blank!\n");
                    
            string = getString();
        }
               
        return string;
    }
    
    /**
     * Read a line from standard input (the text terminal),
     * and return it as a Integer.
     *
     * @return  A Integer typed by the user. 
     */
    public Integer getInteger()
    {
        System.out.print("> ");
                
        while (!reader.hasNextInt()) 
        {
            System.out.println("ID not accepted");
            
            reader.next();
        }
        int id = reader.nextInt();
                
        return id;
    }
}
    

