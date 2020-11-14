/**
* Model some details of a product sold by a company.
*
* @author Andrei Cruceru
* @version 15102020
*/
public class Product
{
    public static final int LOW = 5;
    
    //Name and id of the product.
    private int id;
    private String name;
    // The quantity of this product in stock.
    private int quantity;
    // The amount of products required.
    private int amount;

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
        return "| Product ID: " + id + " | Product Name: " + name + " | Stock Level: " + quantity + " |";
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
            
            System.out.println("Delivered " + amount + " " + name);
        }
        else
        {
            System.out.println("Attempt to restock " + name + " with a non-positive amount: " + amount);
        }
    }
    
    /**
     * Sell a quantity of a product
     */
    public void sellMultiple(int number)
    {
        if (quantity >= number)
        {
            quantity = quantity - number;
            
            System.out.println(number + " of " + name + "sold!");
        }
        else if(quantity < number)
        {
            System.out.println("The quantity of the product " + name + " is lower than the required amount!");
            System.out.println(quantity + " of " + name + " sold!");
            
            quantity = 0;
        }
        else
        {
            System.out.println();
            System.out.println("The amount of " + name + " required must be a positive number!");
            System.out.println();
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
        System.out.println("Product " + id + " " + name + "has been renamed to " +
                            replacement);
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
        if(getQuantity() <= LOW)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * The quantity you want to sell.
     */
    public void amountToCart(int amount)
    {
        this.amount = amount;
    }
           
    /**
     * Return the amount of items you want to sell.
     */
    public int getAmount()
    {
        return amount;
    }
}
