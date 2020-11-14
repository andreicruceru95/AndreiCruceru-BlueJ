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
    
    /**
     * The stock used by this shopping cart.
     */
    public ShoppingCart()
    {
        
    }
            
    /**
     * Add a product and the quantity you want to buy.
     */
    public void addToCart(Product product, int amount)
    {
        cart.add(product);
        product.amountToCart(amount);
        
        System.out.println(product.getAmount() + " " + product.getName() + " added to cart");
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
     * Delete a product from cart.
     */
    public void deleteProduct(Product product)
    {
        System.out.println("Product " + product.getName() + " removed from cart");
        
        cart.remove(product);
    }
    
    /**
     * Sell the items and empty the cart
     */
    public void proceedWithCart()
    {
        cart.forEach(product->
        {
            product.sellMultiple(product.getAmount());
        });
        
        cart.clear();
        
        System.out.println("###############################");
        System.out.println("Thank you for shopping with us!");
        System.out.println("*******************************");
    }
}
