/** 
 *  This is a enum class that will allow us to select some coins
 *  to buy tickets.
 *  @author Andrei Cruceru
 *  @version 11102020
 */

public enum Coin
{
    // The four types of coins we are going to use
    P10 (10),
    P20 (20),
    P100 (100),
    P200 (200);

    public final int value;
    
    /**
    * constructor method
    */    
    private Coin(int value)
    {
        this.value = value;
    }
    
    /**
     * Return the value of the coin
     */
    public int getValue()
    {
        return value;
    }
}