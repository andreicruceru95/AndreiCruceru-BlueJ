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
        
        manager.addProduct(new Product(21, "Bush Clock Radio "));
        manager.addProduct(new Product(22, "Google Pixel 4XL "));
        manager.addProduct(new Product(23, "Samsung QLED TV  "));
        manager.addProduct(new Product(24, "IKEA Malm Desk   "));
        manager.addProduct(new Product(25, "Japanese Storage "));
        manager.addProduct(new Product(26, "Samsung Microwave"));
        manager.addProduct(new Product(27, "Monda Table Lamp "));
        manager.addProduct(new Product(28, "Washing Mashine  "));
        manager.addProduct(new Product(29, "Bosch S. 4 Dryer "));
        manager.addProduct(new Product(30, "Beko Elect Cooker"));
        manager.addProduct(new Product(31, "IKEA Ektorp Sofa "));
        manager.addProduct(new Product(32, "Shower Curtain   "));
        manager.addProduct(new Product(33, "Krau Kitchen Sink"));
        
        deliverProducts();
    }
    
    /**
     * Provide a very simple demonstration of how a StockManager
     * might be used. Details of one product are shown, the
     * product is restocked, and then the details are shown again.
     */
    private void deliverProducts()
    {
        // Take delivery of 5 items of one of the products.
        manager.deliverProduct(21, 51);
        manager.deliverProduct(22, 11);
        manager.deliverProduct(23, 21);
        manager.deliverProduct(24, 91);
        manager.deliverProduct(25, 43);
        manager.deliverProduct(26, 15);
        manager.deliverProduct(27, 55);
        manager.deliverProduct(28, 17);
        manager.deliverProduct(29, 32);
        manager.deliverProduct(30, 12);
        manager.deliverProduct(31, 45);
        manager.deliverProduct(32, 52);
        manager.deliverProduct(33, 81);
        
        System.out.println("Products delivered!");
    }
    
    /**
     * @return The stock manager.
     */
    public StockManager getManager()
    {
        return manager;
    }
}
