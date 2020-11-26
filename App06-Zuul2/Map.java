import java.util.*;

/**
 * A colection of rooms.
 * 
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Map
{
    private ArrayList<Room> map = new ArrayList<Room>();
    
    private static final String [][] fMap = new String [50][50];
    private HashMap<String, Room> MAP = new HashMap<String, Room>(); 
    
    private String name;
    
    /**
     * Constructor for the map.
     */
    public Map(String name)
    {
        print();
        this.name = name;
         
        Room home = new Room(1,"Home","\tThis is your home in Wycombe Valley town.\nThere is only few people around the town. What is going on?", "   ", " # "," # "," # ", "   ");
        Room shop = new Room(2,"Shop","\tA small shop still operating in town.\nThe owner thought he is too old to leave and start a new life..."
                                + "\nHave a look! He might sell something ussefull", " # ","   ", " # "," # ", " S ");
        Room blacksmith = new Room(3,"Blacksmith","\tYou can improve your equipment here!\nIt can't be free unfortunately, we all need some coins.", " # ", " # "," # ","   ", " B ");
        Room house1 = new Room(4,"House","\tIt seems to be an old, abandoned house.\nI can't see an entrance..", " # ", " # "," # "," # ", "   ");
        Room stable = new Room(5,"Stable","\tThis could be ussefull!.\nYou don't know how to ride a horse unfortunately!", " # ", " # "," # "," # ", " S ");
        Room market = new Room(6,"Market","\tThis was once one of the busiest towns.\nWe hope one day someone could save the world from the " +
                                "evil who caused this, and restore the peace.",  "  ","  ","  ","  ", " ? ");
        Room forest = new Room(7, "Forest", "\tThe forest around the town. \nBe carefull, the creatures are violent.","   ", " # "," # "," # ", " # "); 
    }
    
    /**
     * Add the rooms to the map.
     */
    public void add(String name, Room room1,Room room2,Room room3, Room room4, Room room5, Room room6, Room room7)
    {
        MAP.put(name, room1);
        MAP.put(name, room2);
        MAP.put(name, room3);
        MAP.put(name, room4);
        MAP.put(name, room5);
        MAP.put(name, room6);
        MAP.put(name, room7);
        
    }
    
    /**
     * Print the map. (Only for testing)
     */
    private void print()
    {
        for (int i = 0; i < fMap.length; i++)
        {
            
            for (int j = 0; j < fMap.length; j++)
            {
                fMap[i][j] = "   ";
                fMap[i][0] = " # ";
                fMap[i][99] = " # ";
                fMap[0][j] = " # ";
                fMap[99][j] = " # ";
                
            }
            System.out.println("");  
        }
        add(" M "," M "," M "," M "," M "," B ");
    }
    
    /**
     * find a room on the map. (room id = room level)
     */
    private Room findRoomID(int id)
    {
        for (Room room : map)
        {
            if (room.getLevel() == id)
            {
                return room;
            }
        }
        return null;
    }
    
    /**
     * Get the room description.
     */
    public void getRoomDescription(String name)
    {
        Room room = checkExistance(name);
        if(room != null)
        {
            room.getDescription();
        }
        else
            System.out.println("\tRoom not found!");
    }
    
    /**
     * Check if a room exists on the map.
     */
    private Room checkExistance(String name)
    {
        for (String key : MAP.keySet())     
        {
            if (key.equals(name))
            {
                Room room = MAP.get(key);
                
                return room;
            }
        }
        return null;
    }
    
    /**
     * Add values to the full map.
     */
    private void add(String a,String b, String c, String d, String f, String g)
    {
         
        for (int i = 0; i < fMap.length; i++)
        {
            
            for (int j = 0; j < fMap.length; j++)
            {
                fMap[2][4] = a;
                fMap[4][6] = b;
                fMap[6][8] = c;
                fMap[9][4] = d;
                fMap [10][7] = f;
                fMap [4][10] = g;
                
                System.out.print(fMap[i][j]);
            }
            System.out.println("");
        }
    }
    
    // I created this in case the HashMap doesn't work as intended.
    // private Room findRoomName(String name)
    // {
        // for (Room room : map)
        // {
            // if (room.getName().equals(name))
            // {
                // return room;
            // }
        // }
        // return null;
    // }
    
    // public void getRoomDescription(String name)
    // {
        // Room room = findRoomName(name);
        // if(room != null)
        // {
            // room.getDescription();
        // }
        // else
            // System.out.println("\tRoom not found!");
    // }
    
    
}