import java.util.*;

/**
 * A player for our game.
 * Each new player recieves a basic armour, weapon and 5 health potions.
 * 
 * @author Andrei Cruceru
 * @version 21112020
 */
public class Player
{
    private final static int MIN_HEALTH = 0;
    
    private int atk;
    private int def;
    private int maxHp;
    private int currentHp;
    
    private Random random;
        
    private ArrayList<Item> inventory;
    
    private String name;
    private int score = 0;
    
    /**
     * Add a name for the player.
     * @param name is the input name.
     */
    public Player(String name)
    {
        random = new Random();
        this.name = name;
        inventory = new ArrayList<Item>();
        inventory.add(new Item(10,"Steel Sword ", 5, 0,0,0,0));
        inventory.add(new Item(20,"Steel Armour", 0, 10,0,10,0));
        inventory.add(new Item(30,"Steel Sword", 5, 0,0,0,5));
    }
    
    /**
     * Print the inventory.
     */
    public void seeInventory()
    {
        for (Item item : inventory)
        {
            System.out.println("\n" + item.getName());
        }
    }
    
    /**
     * See an item.
     * @param name is the input name of the item we want to see.
     */
    public void seeItem(String name)
    {
        Item item = findItem(name);
        
        if (item != null)
        {
            int id = item.getID();
            
            if(id < 20)
            {
                item.seeWeapon();
            }
            else if(id < 30)
            {
                item.seeArmour();
            }
            else if(id == 30)
            {
                item.seePotion();
            }
            else
                System.out.println("error");
        }
        else
            System.out.println("Don't be ridiculous..");
    }
    
    /**
     * Equip an item.
     * @param name is th input name of the item we want to equip.
     */
    public void equip(String name)
    {
        Item item = findItem(name);
        
        if (item != null)
        {
            int id = item.getID();
            
            if(id < 20)
            {
                atk += item.getAtk();
            }
            else if(id < 30)
            {
                def += item.getDef();
                maxHp += item.getHp();
            }
            else if(id == 30)
            {
                currentHp += item.getHeal();
            }
            else
                System.out.println("error");
        }
        else
            System.out.println("Don't be ridiculous..");
    }
    
    /**
     * Discard an item.
     * @param name is the input name of the item we want to discard.
     */
    public void discard(String name)
    {
        Item item = findItem(name);
        
        if (item != null)
        {
            int id = item.getID();
            
            if(id < 20)
            {
                atk -= item.getAtk();
            }
            else if(id < 30)
            {
                def -= item.getDef();
                maxHp -= item.getHp();
            }
            else
                System.out.println("error");
        }
        else
            System.out.println("Don't be ridiculous..");
    }
    
    /**
     * Find an item in the inventory.
     * @param name is the name of the item we are looking for.
     */
    private Item findItem(String name)
    {
        for (Item item : inventory)
        {
            if (item.getName().equals((name)))
            {
                return item;
            }
        }
        
        return null;
    }
    
    /**
     * Pick an item.
     * @param name is the name of the item we want to pick.
     */
    public void pickItem(Item item)
    {
        inventory.add(item);
        
        score += 10;
    }
    
    /**
     * Distroy an item from the inventory.
     * @param name is the name of the item we want to destroy.
     */
    public void throwItem(String name)
    {
        Item item = findItem(name);
        
        if (item != null)
        {   
            inventory.remove(item);
        }
        else
            System.out.println("error");
    }
    
    /**
     * @return the score.
     */
    public int getScore()
    {
        return score;
    }
    
    /**
     * Send an atack.
     * @param value is the a random value.
     */
    public int atack()
    {
        int minAtk = atk - 3;
        int maxAtk = atk + 3;
        
        int value = random.nextInt(maxAtk) + minAtk;
         
        return value;
    }
    
    /**
     * Recieve an atack.
     * @param value is the value we recieve.
     * @return the value we recieved.
     */
    public int getAtacked(int value)
    {
        int recieved = 0;
        
        if (def >= value)
        {
            recieved = -1;
            currentHp -= 1;
        }
        else
        { 
            recieved = value - def;
            currentHp -= (value - def);
        }
        
        return recieved;   
    }
    
    /**
     * Check the health status.
     * @return false if player died.
     * @return true if player is still alive.
     */
    public boolean checkHealth()
    {
        if (currentHp <= 0)
        {
            return false;
        }
        else
            return true;
    }
    
}
