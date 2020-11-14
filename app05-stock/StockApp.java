import java.util.*;

/**
 * This app provides a user interface to the
 * stock manager so that users can add, edit,
 * print and remove stock products
 *
 * @author Student Name
 * @version 0.1
 */
public class StockApp
{
    public static final char CLEAR_CODE = '\u000c';
    
    public static final String QUIT = "quit";
    public static final String PRINT_ALL = "printall";
    public static final String ADD = "add";
    public static final String REMOVE = "remove";
    public static final String SELL = "sell";
    public static final String SEARCH_ID = "searchid";
    public static final String SEARCH_NAME = "searchname";
    public static final String PRINT_LOW = "printlow";
    public static final String RE_STOCK = "re-stock";
    public static final String DELIVER = "deliverproducts";
    public static final String RENAME = "rename";
    public static final String CHECK_QUANTITY = "checkquantity";
    public static final String ADD_TO_CART = "addtocart";
    public static final String DELETE = "removefromcart";
    public static final String PRINT_CART = "printcart";
    public static final String PROCEED = "proceed";
    public static final String BASKET_MENU = "seebasket";
    public static final String SEARCH = "search";
    
    //Use to get user input
    private InputReader reader = new InputReader();
    
    private ShoppingCart shoppingCart = new ShoppingCart();
    
    private StockManager manager = new StockManager(shoppingCart);
    
    private StockDemo demo = new StockDemo(manager);
           
    /**
     * Constructor for objects of class StockApp
     */
    public StockApp()
    {
    }

    /**
     * 
     */
    public void run()
    {
        boolean finished = false;
        
        printHeading();
               
        while(!finished)
        {
            printMenuChoices();
            
            String choice = reader.getString().toLowerCase();
            
            if (choice.equals(QUIT))
                finished = true;
            else if(choice.equals(BASKET_MENU))
                runBasket();
            else if(choice.equals(SEARCH))
                runSearch();
            else
                executeMenuChoice(choice);
        }
    }
    
    /**
     * 
     */
    public void runBasket()
    {
        boolean finished = false;
        
        printCartHeading();
        
        while(!finished)
        {
            printSubMenu();
            
            String choice = reader.getString().toLowerCase();
            
            if (choice.equals(QUIT))
                finished = true;
            else
                executeSubMenu(choice);
        }
    }
    
    public void runSearch()
    {
        boolean finished = false;
        
        printSearchHeading();
        
        while(!finished)
        {
            printSearchMenu();
            
            String choice = reader.getString().toLowerCase();
            
            if (choice.equals(QUIT))
                finished = true;
            else
                executeSearchMenu(choice);
        }
    }
    
    /**
     * 
     */
    private void addProduct()
    {
        System.out.println("    Adding a new product...\n");
         
        System.out.println("    Please enter the product ID\n");
        
        int value = reader.getInteger();
        
        validateNewProduct(value);               
    }
    
    private void validateNewProduct(int id)
    {
        String attempt = null;
        
        while (manager.findProduct(id) != null)
        {
            System.out.println("\n The product id entered already exists! Please try using a different id!");
                
            id = reader.getInteger();
        }
        
        System.out.println("    Please enter the product name\n");
        
        String name = reader.getString();
       
        while (name.length() == 0)
        { 
            System.out.println("    Cannot leave blank!\n");
                    
            name = reader.getString();
        }
            
        System.out.println("\n Product  with ID " + id + ",Name " + name + " added\n");
        
        Product product = new Product(id, name);
        manager.addProduct(product);
        manager.getProductByID(id);
    }
                
    /**    
    *    
    *
    */
    private void rename(String value)
    {
        int id = Integer.parseInt(value);
                    
        while (manager.findProduct(id) == null)
        {
            System.out.println("\n The product id doesn't exist! Please try using a different id!");
                
            id = reader.getInteger();
        }
        
        System.out.println("\n One product found:\n");
        
        manager.getProductByID(id);
        
        System.out.println("\n    Please enter the new product name\n");
        
        String name = reader.getString();
        
        while (name.length() == 0)
        { 
            System.out.println("\n    Cannot leave blank!\n");
                    
            name = reader.getString();
        }
        
        manager.renameProduct(id, name);
    }
        
    private void validateId(String value)
    {
        if (value != null)
        {
            int id = Integer.parseInt(value);
            
            Product test = manager.findProduct(id);
            if (test == null)
            {
                System.out.println("");
            }
        }
        
    }
        
    /**
     * 
     */
    public void executeMenuChoice(String choice)
    {
        if (choice.equals(ADD))
        {
            addProduct();            
        }
        else if (choice.equals(PRINT_ALL))
        {
            manager.printAllProductDetails();
        }
        else if (choice.equals(REMOVE))
        {
            System.out.println("    Please enter the product ID\n");
        
            int value = reader.getInteger();
            
            manager.removeProduct(value);
        }
        else if (choice.equals(SELL))
        {
            System.out.println("    Please enter the amount\n");
        
            int amount = reader.getInteger();
            
            System.out.println("    Please enter the product ID\n");
        
            int id = reader.getInteger();
                        
            manager.sellMultiple(id, amount);
        }
        else if (choice.equals(PRINT_LOW))
        {
            manager.checkLowStock();
        }
        else if (choice.equals(RE_STOCK))
        {
            manager.refillStock();
        }
        else if (choice.equals(DELIVER))
        {
            System.out.println("    Please enter the product ID\n");
        
            int id = reader.getInteger();
            
            System.out.println("    Please enter the amount\n");
        
            int amount = reader.getInteger();
            
            manager.deliverProduct(id, amount);
        }
        else if (choice.equals(RENAME))
        {
            System.out.println("    Please enter the product ID\n");
        
            String value = reader.getString();
            
            rename(value);
        }
        else if (choice.equals(CHECK_QUANTITY))
        {
            System.out.println("    Please enter the product ID\n");
        
            int id = reader.getInteger();
            
            manager.getProductByID(id);
        }
        else if (choice.equals(BASKET_MENU))
        {
            printSubMenu();
        }
    }
    
    /**
     * 
     */
    private void executeSubMenu(String choice)
    {
       if (choice.equals(ADD_TO_CART))
        {
            System.out.println("    Please enter the product ID\n");
        
            int id = reader.getInteger();
            
            System.out.println("    Please enter the amount\n");
        
            int amount = reader.getInteger();
            
            manager.addToCart(id, amount);
        }
        else if (choice.equals(DELETE))
        {
            System.out.println("    Please enter the product ID\n");
        
            int id = reader.getInteger();
            
            manager.deleteFromCart(id);
        }
        else if (choice.equals(PRINT_CART))
        {
            manager.printCart();
        }
        else if (choice.equals(PROCEED))
        {
            manager.proceedWithCart();
        }
        else
            System.out.println("Please select something from the menu");
            
    }
    
    /**
     * 
     */
    private void executeSearchMenu(String choice)
    {
        if (choice.equals(SEARCH_ID))
        {
            System.out.println("    Please enter the product ID\n");
        
            int id = reader.getInteger();
            
            manager.printDetailsWithID(id);
            }
        else if (choice.equals(SEARCH_NAME))
        {
            System.out.println("    Please enter the product name\n");
        
            String name = reader.getString();
            
            manager.search(name);
        }
        
    }
    
    /**
     * 
     */
    private void printSearchMenu()
    {
        System.out.println();
        System.out.println("        SearchId            :   Add a new product to cart");
        System.out.println("        SearchName          :   Delete product from cart");
        System.out.println("        Quit                :   Exit the Search menu");
        System.out.println();
    }
    
    /**
     * 
     */
    private void printSubMenu()
    {
        System.out.println();
        System.out.println("        AddToCart            :   Add a new product to cart");
        System.out.println("        Delete               :   Delete product from cart");
        System.out.println("        PrintCart            :   See items in cart");
        System.out.println("        Proceed              :   Sell items from cart");
        System.out.println("        Quit                 :   Exit the basket menu");
        System.out.println();
        
    }
    
    /**
     * Print out a menu of operation choices
     */
    private void printMenuChoices()
    {
        System.out.println();
        System.out.println("    Add             :   Add a new product");
        System.out.println("    Remove          :   Remove an old product");
        System.out.println("    PrintAll        :   Print all products");
        System.out.println("    Sell            :   Sell an amount of products");
        System.out.println("    DeliverProducts :   Deliver products");
        System.out.println("    PrintLow        :   Print products with low stock");
        System.out.println("    Re-stock        :   Deliver products with low stock");
        System.out.println("    Rename          :   Rename a product");
        System.out.println("    CheckQuantity   :   Check quantity of a product");
        System.out.println("    Search          :   Search for a product");
        System.out.println("    SeeBasket       :   Move to basket");
        System.out.println("    Quit            :   Quit the program");
        System.out.println();        
    }
    
    /**
     * Print the title of the program and the authors name
     */
    private void printHeading()
    {
        System.out.println("\n******************************");
        System.out.println(" Stock Management Application ");
        System.out.println("    App05: by Andrei Cruceru  ");
        System.out.println("******************************\n");
    }
    
    /**
     * 
     */
    private void printCartHeading()
    {
        System.out.println("\n******************************");
        System.out.println("        Shopping cart         ");
        System.out.println("******************************\n");
    }
    
    /**
     * 
     */
    private void printSearchHeading()
    {
        System.out.println("\n******************************");
        System.out.println("            Search            ");
        System.out.println("******************************\n");
    }
}
