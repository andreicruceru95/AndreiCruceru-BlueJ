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
        return id + ": " +  name + " stock level: " + quantity;
    }

    /**
     * Restock with the given amount of this product.
     * The current quantity is incremented by the given amount.
     * @param amount The number of new items added to the stock.
     *               This must be greater than zero.
     */
    public void increaseQuantity(int amount)
    {
        if(amount > 0) 
        {
            quantity += amount;
        }
        else 
        {
            System.out.println("Attempt to restock " + name +
                               " with a non-positive amount: " + amount);
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
        }
        else 
        {
            System.out.println(
                "Attempt to sell an out of stock item: " + name);
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
     * Get product details
     */
    public void printProduct()
    {
        System.out.println("Product name: " + name + " Product ID: " + id + " Stock Level: " + quantity); 
    }
}
