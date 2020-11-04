/**
* Model some details of a product sold by a company.
*
* @author Andrei Cruceru
* @version 15102020
*/
public class Product
{
    // Name and id of the product.
    private int id;
    private String name;
    // The quantity of this product in stock.
    private int quantity;

    /**
    * Constructor for objects of class Product.
    * The initial stock quantity is zero.
    * @param id The product's identifying number.
    * @param name The product's name.
    */
    public Product(int id, String name)
    {
        this.id = id;
        this.name = name;
        quantity = 0;
    }

    /**
     * @return The product's id.
     */
    public int getID()
    {
        return id;
    }

    /**
     * @return The product's name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * @return The quantity in stock.
     */
    public int getQuantity()
    {
        return quantity;
    }

    /**
     * @return The id, name and quantity in stock.
     */
    public String toString()
    {
        return "|Product ID: " + id + " |Product Name: " + name + " |Stock Level: " + quantity + " |";
    }

    /**
     * Restock with the given amount of this product.
     * The current quantity is incremented by the given amount.
     * @param amount The number of new items added to the stock.
     * This must be greater than zero.
     */
    public void increaseQuantity(int amount)
    {
        if(amount > 0)
        {
            quantity += amount;
        }
        else
        {
            System.out.println("Attempt to restock " + name + " with a non-positive amount: " + amount);
        }
    }
    
    /**
     * Sell a quantity of a product
     */
    public void sellMultiple(int amount)
    {
        if (amount < quantity)
        {
            quantity = quantity - amount;
        }
        else
        {
            System.out.println("The quantity is lower than the required amount!");
        }
        
    }
    

    /**
     * Sell one of these products.
     * An error is reported if there appears to be no stock.
     */
    public void sellOne()
    {
        if(quantity > 0)
        {
            quantity = quantity - 1;

            System.out.println("One " + name + " has been sold");

            getLow();
        }
        else
        {
            System.out.println("Attempt to sell an out of stock item: " + name + ". Quantity in stock: " + getQuantity());
        }
    }

    /**
     * Replace the name of this product.
     */
    public void replaceName(String replacement)
    {
        name = replacement;
    }

    /**
     * Check if the stock of a product is low.
     * Print a warning message if true.
     */
    private void getLow()
    {
        if(checkLow() == true)
        {
            System.out.println("WARNING: " + getQuantity() + " " + getName() + " in stock. Please order more!");
        }
    }

    /**
     * @return weather or not the quantity of a product is low.
     */
    public boolean checkLow()
    {
        int low = 5;

        if(getQuantity() <= low)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
