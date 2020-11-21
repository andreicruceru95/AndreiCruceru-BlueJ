/**
 * The attributes of our items.
 *
 * @author Andrei Cruceru
 * @version 21112020
 */
public class Item
{
    //The item attributes
    private int id;
    private String name;
    private int atk;
    private int def;
    private int heal;
    private int hp;
    private int quantity;

    /**
     * Initialising attributes.
     * @param id is the item's id.
     * @param name is the item name.
     * @param atk is the weapon atk.
     * @param def is the armour def.
     * @param heal is the potion restore health amount.
     * @param hp is the armour health bonus.
     * @param quantity is the item's qunatity.
     */
    public Item(int id,String name,int atk,int def,int heal,int hp,int quantity)
    {
        this.id = id;
        this.name = name;
        this.atk = atk;
        this.def = def;
        this.heal = heal;
        this.hp = hp;
        this.quantity = quantity;
    }
    
    /**
     * See a weapon item.
     */
    public void seeWeapon()
    {
        System.out.println("\n    " + name + ":\n");
        System.out.println("Atk: " + atk);
    }
    
    /**
     * @return a weapon's attributes.
     */
    public String returnWeaponAttr()
    {
        return "\n    Name +" + name + "\nAtk: " + atk;
    }
    
    /**
     * Enchance a weapon.
     * @return the new atk.
     */
    public int enchanceWeapon()
    {
        atk += 10;
        
        return atk;
    }
    
    /**
     * See an armour item.
     */
    public void seeArmour()
    {
        System.out.println("\n    " + name + ":\n");
        System.out.println("Def :" + def);
        System.out.println("HP: "+ hp);
    }
    
    /**
     * @return an armour attributes.
     */
    public String returnArmourAttr()
    {
        return "\n    Name +" + name + "\nAtk: " + def + "\nHP: " + hp;
    }
    
    /**
     * Enchance an armour defense.
     * @return the new defense value;
     */
    public int enchanceArmourDef()
    {
        def += 10;
        
        return def;
    }
    
    /**
     * Enchance an armour hit points bonus.
     * @return the new hp value.
     */
    public int enchanceArmourHp()
    {
        hp += 10;
        
        return hp ;
    }
    
    /**
     * See a potion item.
     */
    public void seePotion()
    {
        System.out.println("\n    " + name + ":\n");
        System.out.println("Restore HP: " + heal);
        System.out.println("Quantity: " + quantity);
    }
    
    /**
     * @return a potion attributes.
     */
    public String returnPotionAttr()
    {
        return "\n    Name +" + name + "\nHeal: " + heal + "\n" + quantity;
    }
    
    /**
     * @return the item's id.
     */
    public int getID()
    {
        return id;
    }
    
    /**
     * @return the item's name.
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * @return the item's def.
     */
    public int getDef()
    {
        return def;
    }
    
    /**
     * @return the item's hp.
     */
    public int getHp()
    {
        return hp;
    }
    
    /**
     * @return the heal value of an item.
     */
    public int getHeal()
    {
        return heal;
    }
    
    /**
     * @return the quantity of an item.
     */
    public int getQuantity()
    {
        return quantity;
    }
    
    /**
     * @return an item's atk value.
     */
    public int getAtk()
    {
        return atk;
    }
}
