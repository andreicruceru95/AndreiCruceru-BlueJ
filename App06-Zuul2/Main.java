/**
 * Write a description of class Demo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main
{
    private Room room;
    private Input reader = new Input();
    
    public Main()
    {
        room = new Room(1, "Town", "...", "   ", " # ", " # ", " # "," Q ");
        
    }
    
    // public static void run()
    // {
        // boolean finished = true;
        // while(!finished)
        // {
            // String choice = reader.getString();
            // if (choice == "quit")
            // {
                // finished = true;
            // }
            // else
                // runMenu(choice);
        // }
    // }
    
    public void runMenu(String choice)
    {
        room.movePlayer(choice);
    }
}

