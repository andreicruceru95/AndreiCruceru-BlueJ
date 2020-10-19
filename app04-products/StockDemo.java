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
    public StockDemo(StockManager manager)
    {
        this.manager = manager;
        
        manager.addProduct(new Product(21, "Bush Clock Radio"));
        manager.addProduct(new Product(22, "Google Pixel 4XL"));
        manager.addProduct(new Product(23, "Samsung QLED 4K TV"));
        manager.addProduct(new Product(24, "IKEA Malm Desk"));
        manager.addProduct(new Product(25, "Japanese Storage Bed"));
        manager.addProduct(new Product(26, "Samsung CE1041DSB2/TL Smart Microwave"));
        manager.addProduct(new Product(27, "Monda Black Adjustable Table Lamp"));
        manager.addProduct(new Product(28, "Electrolux EFLS627UTT Washing Mashine"));
        manager.addProduct(new Product(29, "Bosch Serie 4 WTN85251GB Tumble Dryer"));
        manager.addProduct(new Product(30, "Beko ADC5422AW Electric Cooker"));
        manager.addProduct(new Product(31, "IKEA Ektorp Sofa"));
        manager.addProduct(new Product(32, "Shower Curtain"));
        manager.addProduct(new Product(33, "Kraus KHU100-30 Kitchen Sink"));
    }
    
    /**
     * Provide a very simple demonstration of how a StockManager
     * might be used. Details of one product are shown, the
     * product is restocked, and then the details are shown again.
     */
    public void deliverProducts()
    {
        // Show details of all of the products.
        manager.printProductDetails();
        // Take delivery of 5 items of one of the products.
        manager.delivery(21, 5);
        manager.delivery(22, 11);
        manager.delivery(23, 2);
        manager.delivery(24, 3);
        manager.delivery(25, 4);
        manager.delivery(26, 1);
        manager.delivery(27, 5);
        manager.delivery(28, 5);
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
