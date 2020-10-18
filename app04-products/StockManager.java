import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
 
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
    public void delivery(int id, int amount)
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
    public void numberInStock(int id)
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
        List <Product> listClone = new ArrayList<Product>();
        stock.forEach(item->
        {
            for(Product product : stock) 
            { 
                if(product.getName().contains(word))  
                { 
                    listClone.add(product);
                }
                
            }
            
        });
        System.out.println(listClone); 
    }
    
    /**
     * Remove a product out of the stock
     */
    public void removeProduct(int id)
    {
        Product product = findProduct(id);
        if (product != null)
        {
            product = null;        
        }
        
        else
        {
            System.out.println("Product not found!");
        }
                        
    }
}
