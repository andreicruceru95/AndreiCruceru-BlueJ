import java.util.*;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author Andrei Cruceru 
 * @version 15102020
 */
public class StockManager
{
    // A list of the products.
    private ArrayList<Product> stock;
    List <Product> listClone = new ArrayList<Product>();
       
    /**
     * Initialise the stock manager.
     */
    public StockManager()
    {
        stock = new ArrayList<>();
    }

    /**
     * Add a product to the list.
     * @param item The item to be added.
     */
    public void addProduct(Product item)
    {
        stock.add(item);
    }
    
    /**
     * Rename a product based on it's id.
     */
    public void renameProduct(int id, String replacement)
    {
        Product product = findProduct(id);
        
        if (product != null)
        {
            product.replaceName(replacement);
        }
        else
        {
            System.out.println("Product not found!");
        }
    }
       
    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void deliverProduct(int id, int amount)
    {
        Product product = findProduct(id);
        
        if (product != null)
        {
            product.increaseQuantity(amount);
        }
        else
        {
            System.out.println("Product not found!");
        }
    }
    
    /**
     * Try to find a product in the stock with the given id.
     * @return The identified product, or null if there is none
     *         with a matching ID.
     */
    public Product findProduct(int id)
    {
        for(Product product : stock)
        { 
            if(product.getID() == id) 
            {
                return product;
            }
        }
        return null;
    }
    
    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public void getQuantity(int id)
    {
        Product product = findProduct(id);
        
        if (product != null)
        {
            System.out.println(product.getQuantity());        
        }
        else
        {
            System.out.println("Product not found!");
        }
    }
 
    /**
     * Print details of all the products.
     */
    public void printProductDetails()
    {
        stock.forEach(product->
        {
            System.out.println(product.toString());
        });
    }
    
    /**
     * Search for a product
     */
    public void searchProduct(String word)
    {
        listClone.clear();
        
        for(Product product : stock) 
        { 
            if(product.getName().contains(word))  
            { 
                listClone.add(product);
            }
                
        }
        
        printClone();
    }
    
    /**
     * Remove a product out of the stock
     */
    public void removeProduct(int id)
    {
        Product product = findProduct(id);
        
        if (product != null)
        {
            stock.remove(product);        
        }
        
        else
        {
            System.out.println("Product not found!");
        }
    } 
    
    /**
     * Print a list of the products with a quantity lower than 5.
     */
    public void printLowStock()
    {
        listClone.clear();
        
        for (Product product : stock)
        {
            if (product.getQuantity() < 5)
            {
                listClone.add(product);
            }
        }
        
        printClone();
    }
    
    /**
     * Get delivery for products with low quantity.
     */
    public void refillStock()
    {
        listClone.clear();
        printLowStock();
        
        listClone.forEach(product ->
        {
            product.increaseQuantity(5);    
        });
        
        printClone();
    }
    
    /**
     * Print listClone.
     */
    private void printClone()
    {
        listClone.forEach(product ->
        {
            System.out.println(product);
        });
    }
}
