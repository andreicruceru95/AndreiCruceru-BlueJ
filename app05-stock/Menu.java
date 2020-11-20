import java.util.ArrayList;

/**
 * A list of operations that the user can apply on our program.
 *
 * @author Andrei Cruceru
 * @version 20112020
 */
public class Menu
{
     
    public static void display(String [] choices)
    {
        for(int index = 0; index < choices.length; index ++)
        {
            System.out.println("       -" + choices[index]);
        }
    }
    
    public static String getChoice(String choice, String [] choices)
    {
        for (int index = 0; index < choices.length; index ++)
        {
            if (choices[index].equals(choice) == false)
            {
                System.out.println("\n    Not an option!\n");
            }
            else
                return choice;
        }
        
        return null;
    }
}
