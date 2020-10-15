/**
 * Demonstrate the StockManager and Product classes.
 * The demonstration becomes properly functional as
 * the StockManager class is completed.
 * 
 * @author Andrei Cruceru.
 * @version 15102020
 */
public class StockDemo
{
    // The stock manager.
    private StockManager manager;

    /**
     * Create a StockManager and populate it with a few
     * sample products.
     */
    public StockDemo()
    {
        manager = new StockManager();
        manager.addProduct(new Product(21, "Clock Radio"));
        manager.addProduct(new Product(22,  "Mobile Phone"));
        manager.addProduct(new Product(23,  "TV"));
        manager.addProduct(new Product(24,  "Desk"));
        manager.addProduct(new Product(25,  "Bed"));
        manager.addProduct(new Product(26,  "Microwave Oven"));
        manager.addProduct(new Product(27,  "Lamp"));
        manager.addProduct(new Product(28,  "Washing Mashine"));
        manager.addProduct(new Product(29,  "Tumble Dryer"));
        manager.addProduct(new Product(30,  "Cooker"));
        manager.addProduct(new Product(31,  "Sofa"));
        manager.addProduct(new Product(32,  "Curtains"));
        manager.addProduct(new Product(33,  "Sink"));
        
    }
    
    /**
     * Provide a very simple demonstration of how a StockManager
     * might be used. Details of one product are shown, the
     * product is restocked, and then the details are shown again.
     */
    public void demo()
    {
        // Show details of all of the products.
        manager.printProductDetails();
        // Take delivery of 5 items of one of the products.
        manager.delivery(21, 5);
        manager.delivery(22, 15);
        manager.delivery(23, 53);
        manager.delivery(24, 51);
        manager.delivery(25, 51);
        manager.delivery(26, 215);
        manager.delivery(27, 4);
        manager.delivery(28, 64);
        manager.delivery(29, 5);
        manager.delivery(30, 5);
        manager.delivery(31, 5);
        manager.delivery(32, 5);
        manager.delivery(33, 5);
        manager.printProductDetails();
    }
    
    /**
     * Show details of the given product. If found,
     * its name and stock quantity will be shown.
     * @param id The ID of the product to look for.
     */
    public void showDetails(int id)
    {
        Product product = getProduct(id);
        
        if(product != null) 
        {
            System.out.println(product.toString());
        }
    }
    
    /**
     * Sell one of the given item.
     * Show the before and after status of the product.
     * @param id The ID of the product being sold.
     */
    public void sellProduct(int id)
    {
        Product product = getProduct(id);
        
        if(product != null) 
        {
            showDetails(id);
            product.sellOne();
            showDetails(id);
        }
    }
    
    /**
     * Get the product with the given id from the manager.
     * An error message is printed if there is no match.
     * @param id The ID of the product.
     * @return The Product, or null if no matching one is found.
     */
    public Product getProduct(int id)
    {
        Product product = manager.findProduct(id);
        
        if(product == null) 
        {
            System.out.println("Product with ID: " + id +
                               " is not recognised.");
        }
        return product;
    }

    /**
     * @return The stock manager.
     */
    public StockManager getManager()
    {
        return manager;
    }
}
