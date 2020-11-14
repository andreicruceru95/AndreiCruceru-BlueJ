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
        String inputLine = reader.nextLine();

        return inputLine;
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
        int inputLine = reader.nextInt();
        
        return inputLine;
    }
    
    // public int scan()
    // {
        // Scanner sc = new Scanner(System.in);
        // System.out.println("Please enter product id!");
        // while (!sc.hasNextInt()) {
            // System.out.println("Cannot leave blank");
            // sc.next();
        // }
        // int id = sc.nextInt();
        // System.out.println("id accepted");
        // return id;
    // }
}
    

