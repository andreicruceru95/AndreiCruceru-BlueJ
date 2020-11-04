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
        // Take delivery of 5 items of one of the products.
        manager.deliverProduct(21, 5);
        manager.deliverProduct(22, 11);
        manager.deliverProduct(23, 2);
        manager.deliverProduct(24, 3);
        manager.deliverProduct(25, 4);
        manager.deliverProduct(26, 1);
        manager.deliverProduct(27, 5);
        manager.deliverProduct(28, 5);
        manager.deliverProduct(29, 5);
        manager.deliverProduct(30, 5);
        manager.deliverProduct(31, 5);
        manager.deliverProduct(32, 5);
        manager.deliverProduct(33, 5);
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
