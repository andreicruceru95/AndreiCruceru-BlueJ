import java.util.Random;

/**
 * The player's visual field on the map.
 * The rest of the map will be hidden.
 *
 * @author Andrei Cruceru
 * @version 21112020
 */
public class VisualField
{
    private static final String QUIT = "quit";
    private static final String vField[][]  = new String[3][3];
    
    private Input reader = new Input();
    
    private String move;
    boolean validInput = true;

    public static void main()
    {
        print();
    }
    
    /**
     * Print the visual field.
     */
    private static void print()
    {
        for (int i = 0; i < vField.length; i++)
        {
            
            for (int j = 0; j < vField.length; j++)
            {
                vField[i][j] = "|_|";
                vField[1][1] = "|P|";
                System.out.print(vField[i][j]);
            }
            
            System.out.println("");  
        }
    }   
    
    /**
     * Run the program for the main menu.
     */
    public void run()
    {
        boolean finished = false;
        
        while(!finished)
        {
            String choice = reader.getString().toLowerCase();
            
            if (choice.equals(QUIT))
                finished = true;
            
        }
        
    }
}
