/**
 * This app provides a user interface to the
 * stock manager so that users can add, edit,
 * print and remove stock products
 *
 * @author Andrei Cruceru
 * @version 13112020
 */
public class StockApp
{
    // The variety of choices we can use.
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
    public static final String DELETE = "delete";
    public static final String PRINT_CART = "printcart";
    public static final String PROCEED = "proceed";
    public static final String BASKET_MENU = "seebasket";
    public static final String SEARCH = "search";
    
    //Use to get user input
    private InputReader reader = new InputReader();
    
    // Use of the previous app features.
    private Invoice invoice = new Invoice();
    private ShoppingCart shoppingCart = new ShoppingCart();
    private StockManager manager = new StockManager(shoppingCart, invoice);
    private StockDemo demo = new StockDemo(manager);
           
    /**
     * Run the program for the main menu.
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
     * Run the program for the basket menu.
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
    
    /**
     * Run the program for the search menu.
     */
    private void runSearch()
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
     * This is a form of validation when we are looking for product based on an id. 
     * It will make sure that id we need exists. 
     * @param id is the id of the product. 
     * @return the id when found.
     */
    private Integer findUsedID(int id)
    {
        while (manager.findProduct(id) == null)
        {
            System.out.println("\n The product id doesn't exist! Please try using a different id!");
                
            id = reader.getInteger();
        }
        System.out.println("One product found");
        
        manager.printDetailsWithID(id);
        
        return id;
    }
    
    /**
     * This is a form of validation for a new product. 
     * This method will check an id is available to use. 
     * @param id is the id of the product. 
     * @return the id when found.
     */
    private Integer findNewID(int id)
    {
        while (manager.findProduct(id) != null)
        {
            System.out.println("\n The product id entered already exists! Please try using a different id!");
                
            id = reader.getInteger();
        }
        System.out.println("ID available");
                
        return id;
    }
    
    /**
     * This is a form of validation for a string. 
     * We use this to make sure we are not leaving a blank space where required. 
     * @param name is the name we verify. 
     * @return the name when verified.
     */
    private String validateName(String name)
    {
        while (name.length() == 0)
        { 
            System.out.println("\n    Cannot leave blank!\n");
                    
            name = reader.getString();
        }
        System.out.println("Name accepted");
        
        return name;
    }
    
    /**
     * Create and add a new product after validating the id and name of it.
     */
    private void addProduct()
    {
        System.out.println("\n    Adding a new product...\n");
         
        System.out.println("\n    Please enter the product ID\n");
        
        int id = reader.getInteger();
        
        id = findNewID(id);               
    
        System.out.println("\n    Please enter the product name\n");
        
        String name = reader.getString();
        
        // in case we need local validation.
        // if (name.length() == 0)
        // {
            // name = validateName(name);
        // }           
        
        System.out.println("\n Product  with ID " + id + ",Name " + name + " added\n");
        
        Product product = new Product(id, name);
        manager.addProduct(product);
        manager.getProductByID(id);
        
    } 
                
    /**    
    * Rename a product based on an id. 
    * @param id is the id of the product we are renaming. 
    */
    private void rename(int id)
    {
        id = findUsedID(id);
               
        System.out.println("\n    Please enter the new product name\n");
        
        String name = reader.getString();
        
        manager.renameProduct(id, name);
    }
    
    /**
     * 
     */
    private void setDetails()
    {
        System.out.println("Please enter customer/business name!");
        
        String customer = reader.getString();
        
        manager.setCustomer(customer);
        
        
        System.out.println("Please enter the type of customer - domestic / commercial");
        
        String type = reader.getString();
        
        manager.setCustomerType(type);
        
        System.out.println("Please enter customer's address");
        
        String address = reader.getString();
        
        manager.setCustomerAddress(address);
        
        sell();
        
    }
    
    /**
     * 
     */
    private void sell()
    {
        System.out.println("\n    Please enter the product ID\n");
        
        int id = reader.getInteger();
          
        id = findUsedID(id);
        
        System.out.println("    Please enter the amount\n");
        
        int amount = reader.getInteger();
        
        manager.invoiceProduct(id);            
        manager.sellMultiple(id, amount);
       
        System.out.println("\nDo you want to buy more products? Yes/No\n");
        
        String add = reader.getString();
        
        while (add.equals("yes"))
        {
            System.out.println("\n    Please enter the product ID\n");
        
            id = reader.getInteger();
          
            id = findUsedID(id);
        
            System.out.println("    Please enter the amount\n");
        
            amount = reader.getInteger();
        
            manager.invoiceProduct(id);            
            manager.sellMultiple(id, amount);
       
            System.out.println("\nDo you want to buy more products? Yes/No\n");
        
            add = reader.getString();
        }
        manager.generateInvoice();
        
        System.out.println("Thank you for shopping with us");
    }
        
    /**
     * The main menu of the program. 
     * @param choice is the choice we input.
     */
    private void executeMenuChoice(String choice)
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
            value = findUsedID(value);
            
            manager.removeProduct(value);
        }
        else if (choice.equals(SELL))
        {
            setDetails();
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
            id = findUsedID(id);
            
            System.out.println("    Please enter the amount\n");
        
            int amount = reader.getInteger();
            
            manager.deliverProduct(id, amount);
        }
        else if (choice.equals(RENAME))
        {
            System.out.println("    Please enter the product ID\n");
        
            int id = reader.getInteger();
            
            rename(id);
        }
        else if (choice.equals(CHECK_QUANTITY))
        {
            System.out.println("    Please enter the product ID\n");
        
            int id = reader.getInteger();
            id = findUsedID(id);
        }
        else if (choice.equals(BASKET_MENU))
        {
            printSubMenu();
        }
    }
    
    /**
     * The menu for the basket methods. 
     * @param choice is the choice we input.
     */
    private void executeSubMenu(String choice)
    {
       if (choice.equals(ADD_TO_CART))
        {
            System.out.println("    Please enter the product ID\n");
        
            int id = reader.getInteger();
            id = findUsedID(id);
            
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
            System.out.println("\n    Please select something from the menu\n");
            
    }
    
    /**
     * The search menu. 
     * @param choice is the choice we input.
     */
    private void executeSearchMenu(String choice)
    {
        if (choice.equals(SEARCH_ID))
        {
            System.out.println("    Please enter the product ID\n");
        
            int id = reader.getInteger();
            id = findUsedID(id);
        }
        else if (choice.equals(SEARCH_NAME))
        {
            System.out.println("    Please enter the product name\n");
        
            String name = reader.getString();
            
            manager.search(name);
        }
        
    }
    
    /**
     * The options for the search menu.
     */
    private void printSearchMenu()
    {
        System.out.println();
        System.out.println("        SearchId            :   Search a product by ID");
        System.out.println("        SearchName          :   Search a product by name");
        System.out.println("        Quit                :   Exit the Search menu");
        System.out.println();
    }
    
    /**
     * The options for the basket menu.
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
     * The options for the main menu.
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
     * Print the title of the program and the authors name. 
     */
    private void printHeading()
    {
        System.out.println("\n******************************");
        System.out.println(" Stock Management Application ");
        System.out.println("    App05: by Andrei Cruceru  ");
        System.out.println("******************************\n");
    }
    
    /**
     * Print a heading for the basket menu.
     */
    private void printCartHeading()
    {
        System.out.println("\n******************************");
        System.out.println("         Shopping  Cart         ");
        System.out.println("******************************\n");
    }
    
    /**
     * Print a heading for the search menu.
     */
    private void printSearchHeading()
    {
        System.out.println("\n******************************");
        System.out.println("            Search            ");
        System.out.println("******************************\n");
    }
     
}
