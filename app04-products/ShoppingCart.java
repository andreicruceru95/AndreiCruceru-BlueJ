import java.util.*;

/**
 * Store multiple products until we proceed with payment.
 *
 * @author Andrei Cruceru   
 * @version 04112020
 */
public class ShoppingCart
{
    // List of products inside the cart
    List <Product> cart = new ArrayList<Product>();
    private StockManager manager;

    /**
     * The stock used by this shopping cart.
     */
    public ShoppingCart(StockManager manager)
    {
        this.manager = manager;
    }
    
    /**
     * See a list of available products.
     */
    public void seeProducts()
    {
        manager.printAllProductDetails();
    }
    
    /**
     * Add a product and the quantity you want to buy.
     */
    public void addToCart(int id, int amount)
    {
        Product product = manager.findProduct(id);
        if (product.getQuantity() >= amount)
        {
            cart.add(product);
            product.amountToCart(amount);
        }
        else
        {
            System.out.println("Quantity too high!");
        }
    }    
    
    /**
     * Return the products in the cart.
     */
    public void printCart()
    {
        if (cart.size() > 0)
        {
            cart.forEach(product->
            {
                System.out.println("| ID: " + product.getID() + " | Product: " + product.getName() + " | Amount: " + product.getAmount() + " |");
            });
            
        }
        else
        {
            System.out.println("Shopping cart is empty!");
        }
    } 
    
    /**
     * Try to find a product in the cart with the given id.
     * @return The identified product, or null if there is none
     *         with a matching ID.
     */
    private Product findProduct(int id)
    {
        for(Product product : cart)
        { 
            if(product.getID() == id) 
            {
                return product;
            }
        }
        return null;
    }
    
    /**
     * Delete a product from cart.
     */
    public void deleteProduct(int id)
    {
        Product product = findProduct(id);
        
        if (product != null)
        {
            cart.remove(product);
        }
        
        else
        {
            System.out.println("Product not found in cart!");
        }
    } 
    
    /**
     * Sell the items and empty the cart
     */
    public void proceedWithCart()
    {
        cart.forEach(product->
        {
            manager.sellMultiple(product.getID(), product.getAmount());
            
            System.out.println(product.getAmount() + " " + product.getName() + " Sold");
        });
               
        cart.clear();
        
        System.out.println("Thank you for shopping with us!");
    }
}
