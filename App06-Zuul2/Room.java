import java.util.*;

/**
 * The player's visual field on the map.
 * The rest of the map will be hidden.
 *
 * @author Andrei Cruceru
 * @version 21112020
 */
public class Room
{
    private static final String room[][]  = new String[11][11];
    private static final String visualField[][] = new String[3][3];
    
    //commands and the representation of different items on the map/room.
    private static final String PLAYER = "P";
    private static final String UP = "w";
    private static final String DOWN = "s";
    private static final String LEFT = "a";
    private static final String RIGHT = "d";
    private static final String WALL = "#";
    private static final String BLACKSMITH = "B";
    private static final String SHOP = "S";
    private static final String CHEST = "!?";
    private static final String GOLD = "$";
    private static final String ITEM = "!^";
    private static final String MONSTER = "!M";
    private static final String BOSS = "!B";
    
    //a player object and arrays of monsters and items
    private Player player;
    private ArrayList<Monster> monsters = new ArrayList<Monster>();
    private ArrayList<Item> items = new ArrayList<Item>();
    
    //an empty square on the map/room
    private String square = "   ";
    
    //room/map variables
    private String description;
    private String name;
    private int level;
    private int playerRowCoord;
    private int playerColCoord;
    private int mapLength = 10;
    private int initialRowPCoord = 2;
    private int initialColPCoord = 2;
    
    /**
     * Contructor method for the room.
     * Room(map) has a name, a description and  a level which will define the items and monsters range of levels.
     * The room can have up to 4 exists defined at the creation. and a possible npc.
     */
    public Room(int level, String name, String description,String exit1, String exit2, String exit3, String exit4, String npc)
    {
        this.description = description;
        this.level = level;
        this.name = name;
        player = new Player();
        
        createRoom(exit1,exit2,exit3,exit4,npc);
        
        // create monsters
        monsters.add(new Monster("Black Bear", 1));
        monsters.add(new Monster("White Tiger", 5));
        monsters.add(new Monster("Ape Thrower", 10));
        monsters.add(new Monster("Ape General", 15));
        monsters.add(new Monster("Scorpion", 20));
        monsters.add(new Monster("Snake Archer", 25));
        monsters.add(new Monster("Grizly Bear", 30));
        monsters.add(new Monster("Yeti", 35));
        monsters.add(new Monster("Demon", 40));
        monsters.add(new Monster("Cursed Zombie", 45));
        monsters.add(new Monster("Bera", 4));
        monsters.add(new Monster("Tigris", 9));
        monsters.add(new Monster("Ape King", 14));
        monsters.add(new Monster("Spider Queen", 29));
        monsters.add(new Monster("Nine Tails", 34));
        monsters.add(new Monster("Death", 44));
              
    }
    
    /**
     * Visual field of the player.
     */
    public void printVisualField()
    {
        for (int i = 0; i < visualField.length; i++)
        {
            
            for (int j = 0; j < visualField.length; j++)
            {
                visualField[0][0] = room[initialRowPCoord-1][initialColPCoord-1];
                visualField[0][1] = room[initialRowPCoord-1][initialColPCoord];
                visualField[0][2] = room[initialRowPCoord-1][initialColPCoord+1];
                visualField[1][0] = room[initialRowPCoord][initialColPCoord-1];
                visualField[1][1] = " " + PLAYER + " ";
                visualField[1][2] = room[initialRowPCoord][initialColPCoord+1];
                visualField[2][0] = room[initialRowPCoord+1][initialColPCoord-1];
                visualField[2][1] = room[initialRowPCoord+1][initialColPCoord];
                visualField[2][2] = room[initialRowPCoord+1][initialColPCoord+1];
                
                System.out.print(visualField[i][j]);
            }
            System.out.println("");
        }
    }
        
    /**
     * Create the room.
     */
    private void createRoom(String e1, String e2, String e3, String e4, String npc)
    {
        for (int i = 0; i < room.length; i++)
        {
            
            for (int j = 0; j < room.length; j++)
            {
                room[i][j] = square;
                room[i][0] = " " + WALL + " ";
                room[i][mapLength] = " " + WALL + " ";
                room[0][j] = " " + WALL + " ";
                room[mapLength][j] = " " + WALL + " ";
                
            }
            
            System.out.println("");  
        }
        createDoors(e1,e2,e3,e4, npc);
    }
    
    /**
     * Create doors and objects on the map.
     */
    private  void createDoors(String e1, String e2, String e3, String e4,String npc )
    {
        for (int i = 0; i < room.length; i++)
        {
            
            for (int j = 0; j < room.length; j++)
            {
                room[0][mapLength/2] = e1;
                room[initialRowPCoord][initialColPCoord] = " " + PLAYER + " ";
                room[5][5] = npc;
                room[4][2] = " " + MONSTER;
                
                room[mapLength/2][mapLength] = e2;
                room[mapLength][mapLength/2] = e3;
                room[mapLength/2][0] = e4;
                System.out.print(room[i][j]);
            }
            
            System.out.println("");  
        }
    }
    
    /**
     * Get the coordinates ot the player.
     */
    private void getCoordinates()
    {
        for (int i = 0; i < room.length; i++)
        {
            for (int j = 0; j < room.length; j++)
            {
                if (room[i][j].equals(PLAYER))
                {
                    playerRowCoord = i;
                    playerColCoord = j;
                }
            }
        }
    }
    
    /**
     * Set values in the 2D map.
     */
    public void setObject(int row, int col, String obj)
    {
        for (int i = 0; i < room.length; i++)
        {
            for (int j = 0; j < room.length; j++)
            {
                room[row][col] = obj;
            }
        }
    }
    
    /**
     * Print the room. Will be hidden to the player.
     */
    public void printRoom()
    {
        for (int i = 0; i < room.length; i++)
        {
            for (int j = 0; j < room.length; j++)
            {
                room[initialRowPCoord][initialColPCoord] = " " + PLAYER + " ";
                System.out.print(room[i][j]);
            }
            System.out.println("");
        }
    }
    
    /**
     * get the column coordinates of the player.
     */
    public int getColCoordinate()
    {
        getCoordinates();
        
        return playerColCoord;
    }
    
    /**
     * get the row coordinates of the player.
     */ 
    public int getRowCoordinate()
    {
        getCoordinates();
        
        return playerRowCoord;
    }
    
    /**
     * move player in a direction
     */
    public void movePlayer(String direction)
    {
        int row = getRowCoordinate();
        int col = getColCoordinate();
        
        
        if(direction.equals(UP))
        {
            int rowUp = initialRowPCoord -= 1;
            int check = checkNextSquare(rowUp, col);
            
            if(check == 1)
            {
                setObject(initialRowPCoord,initialColPCoord,"   ");
                room[rowUp][col] = square;
            }
                       
        }
        else if(direction.equals(DOWN))
        {
            int rowDown = initialRowPCoord += 1;
            int check = checkNextSquare(rowDown, col);
            
            if(check == 1)
            {
                room[initialRowPCoord][initialColPCoord] = "   ";
                room[rowDown][col] = square;
                
            }
            
        }
        else if(direction.equals(LEFT))
        {
            int colLeft = initialColPCoord -= 1;
            int check = checkNextSquare(row, colLeft);
            
            if(check == 1)
            {
                setObject(initialRowPCoord,initialColPCoord,"   ");
                room[row][colLeft] = square;
                
            }
            
        }
        else if(direction.equals(RIGHT))
        {
            int colRight = initialColPCoord += 1;
            int check = checkNextSquare(row, colRight);
            
            if(check == 1)
            {
                setObject(initialRowPCoord,initialColPCoord,"   ");
                room[row][colRight] = square;
                
            }
            
        }
        else
            System.out.println("\n\tNot a direction");
            
        printVisualField();
        printRoom();
    }
    
    /**
     * check the next square.
     * @return 1 if the next square can be walked uppon/modified,
     * @return 0 if it cannot.
     */
    public int checkNextSquare(int row, int col)
    {
        if (room[row][col] == "   ")
        {
            return 1;
        }
        else if(room[row][col].equals(WALL))
        {
            System.out.println("Cannot go through walls");
            return 0;
        }
        else if(room[row][col].contains(SHOP))
        {
            //see shop
            return 0;
        }
        else if(room[row][col].contains(BLACKSMITH))
        {
            //SEE BLACKSMITH
            return 0;
        }
        else if(room[row][col].contains(CHEST))
        {
            //SEE CHEST
            return 1;
        }
        else if(room[row][col].contains(GOLD))
        {
            //take gold
            return 1;
        }
        else if(room[row][col].contains(ITEM))
        {
            //take random item
            return 1;
        }
        else if(room[row][col].contains(MONSTER) || room[row][col].equals(BOSS))
        {
            int result = action();
            
            if(result > 0)
            {
                return 1;
            }
        }
        else
            return 0;
            
        return 0;    
    }
    
    /**
     * Get the room/map description.
     */
    public void getDescription()
    {
        System.out.println(description);
    }
    
    /**
     * return the map level.
     */
    public int getLevel()
    {
        return level;
    }
    
    /**
     * return the map name.
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Skip-forward in a fight.
     */
    public int action()
    {
        Monster monster = findMonster(level);
        Monster boss = findMonster(level - 1);
        
        if (monster != null || boss!= null)
        {
            int playerAtackForce = player.atack();
            int monsterAtackForce = monster.atack();
            
            do
            {
                monster.recieveDamage(playerAtackForce);
                player.recieveDamage(monsterAtackForce);
                
            }
            while(player.checkHealth() == true || monster.checkHealth() == true);
            
        }
        
        return player.getHitPoints();
    }
    
    /**
     * Find a monster's level. (Monster level will be in the same range as the map).
     */
    private Monster findMonster(int level)
    {
        for (Monster monster : monsters)
        {
            if (monster.getLevel() == level)
            {
                return monster;
            }
        }
        return null;
    }
}    