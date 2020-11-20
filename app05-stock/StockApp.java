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
    public static final String DELIVER = "deliver";
    public static final String RENAME = "rename";
    public static final String QUANTITY = "quantity";
    public static final String ADD_TO_CART = "add";
    public static final String DELETE = "delete";
    public static final String PRINT_CART = "print";
    public static final String PROCEED = "proceed";
    public static final String BASKET_MENU = "basket";
    public static final String SEARCH = "search";
    public static final String YES = "yes";
    public static final String NO = "no";
    public static final String SORT_ID = "sortid";
    public static final String SORT_NAME = "sortname";
    public static final String SORT_QUANTITY = "sortquantity";
    
    
    //Use to get user input
    private final InputReader reader = new InputReader();
    
    // Use of the previous app features.
    private final ShoppingCart shoppingCart = new ShoppingCart();
    private final StockManager manager = new StockManager(shoppingCart);
    private final StockDemo demo = new StockDemo(manager);
    
    // Different menus we can use.
    private String[] menuChoices;
    private String[] basketMenu;
    private String[] searchMenu;
    private String[] sortOptions;
    private String[] binary;
    
    public StockApp()
    {
        menuChoices = new String[] 
        {
            ADD      + "             Add new product",
            REMOVE      + "          Remove product ",
            SELL      + "            Sell Products  ",
            PRINT_ALL     + "        Print all products",
            RENAME      + "          Rename product  ",
            PRINT_LOW  +    "        Print products with low quantity",
            RE_STOCK   +    "        Add new product",
            DELIVER      + "         Deliver Products",
            QUANTITY      + "        Check the quantity of a product",
            BASKET_MENU + "          See basket menu",
            SEARCH      + "          See search menu",
            QUIT    +   "            Quit           "            
        };
                                    
        basketMenu = new String[] 
        {
            ADD_TO_CART + "             Add to cart",
            PRINT_CART    + "           Print cart",
            PROCEED         + "         Proceed with cart",
            DELETE         + "          Delete from cart",
            QUIT         + "            Quit"
        };
          
        searchMenu = new String[] 
        {
            SEARCH_ID + "        Search by id",
            SEARCH_NAME + "      Search by name",
            QUIT  + "            Quit"
        };
        
        sortOptions = new String[] 
        {
            SORT_ID + "          Sort by ID",
            SORT_NAME + "        Sort by name",
            SORT_QUANTITY + "    Sort by quantity"
        };
        
        binary = new String[] {YES, NO};
    }
    
    /**
     * Print main menu.
     */
    private void printMenu(String [] option)
    {
        Menu.display(option);
    }
    
    /**
     * Run the program for the main menu.
     */
    public void run()
    {
        boolean finished = false;
        
        printHeading("*         Main menu          *");
               
        while(!finished)
        {
            printMenu(menuChoices);
            
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
        
        printHeading("*       Shopping Cart        *");
        
        while(!finished)
        {
            printMenu(basketMenu);
            
            String choice = reader.getString().toLowerCase();
            
            if (choice.equals(QUIT))
                finished = true;
            else
                executeBasketMenu(choice);
        }
    }
    
    /**
     * Run the program for the search menu.
     */
    private void runSearch()
    {
        boolean finished = false;
        
        printHeading("*           Search           *");
        
        while(!finished)
        {
            printMenu(searchMenu);
            
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
        System.out.println("One product found\n");
        
        manager.getProductByID(id);
        
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
        System.out.println("\nID available\n");
                
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
        System.out.println("\nName accepted\n");
        
        return name;
    }
    
    /**
     * Create and add a new product after validating the id and name of it.
     */
    private void addProduct()
    {
        int id = 0;
        
        System.out.println("\n    Adding a new product...\n");
        
        System.out.println("\n    Do you want the system to set up a new ID?\n");
        
        printMenu(binary);
        
        String idOption = reader.getString();
        
        if(idOption.toLowerCase().equals(YES))
        {
            id = manager.getNextId();
        }
        else
        {
            System.out.println("\n    Please enter the product ID\n");
        
            id = reader.getInteger();
        
            id = findNewID(id);
        }
    
        System.out.println("\n    Please enter the product name\n");
        
        String name = reader.getString();
        
        Product product = new Product(id, name);
        manager.addProduct(product);
        
        System.out.println("\n    Do you want to order a delivery now?\n");
        
        printMenu(binary);
        
        String deliveryOption = reader.getString();
        
        if(deliveryOption.toLowerCase().equals(YES))
        {
            System.out.println("\n    Please enter the amount");
            
            int amount = reader.getInteger();
            
            manager.deliverProduct(id, amount);
        }
        
        System.out.println("\n    Product  with ID " + id + ",Name " + name + " added\n");
        
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
    private void sell()
    {
        System.out.println("\n    Please enter the product ID\n");
        
        int id = reader.getInteger();
          
        id = findUsedID(id);
        
        System.out.println("    Please enter the amount\n");
        
        int amount = reader.getInteger();
                   
        manager.sellMultiple(id, amount);
       
        System.out.println("\nDo you want to buy more products?\n");
        
        printMenu(binary);
        
        String add = reader.getString();
        
        while (add.equals(YES))
        {
            System.out.println("\n    Please enter the product ID\n");
        
            id = reader.getInteger();
          
            id = findUsedID(id);
        
            System.out.println("    Please enter the amount\n");
        
            amount = reader.getInteger();
        
            manager.sellMultiple(id, amount);
       
            System.out.println("\nDo you want to buy more products?\n");
            
            printMenu(binary);
        
            add = reader.getString();
        }
        
        System.out.println("Thank you for shopping with us");
    }
    
    /**
     * Print the list in three different ways.
     */
    public void getSortOptions()
    {
        System.out.println("\nHow do you want to see the list?\n");
        
        printMenu(sortOptions);
        
        String choice = reader.getString();
        
        if (choice.equals(SORT_ID))
        {
            manager.sortByID();
        }
        else if (choice.equals(SORT_NAME))
        {
            manager.sortByName();
        }
        else if (choice.equals(SORT_QUANTITY))
        {
            manager.sortByQuantity();
        }
        else
            System.out.println("\n    Not an option!\n");
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
            getSortOptions();
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
            sell();
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
        else if (choice.equals(QUANTITY))
        {
            System.out.println("    Please enter the product ID\n");
        
            int id = reader.getInteger();
            id = findUsedID(id);
        }
        else if (choice.equals(BASKET_MENU))
        {
            printMenu(basketMenu);
        }
    }
    
    /**
     * The menu for the basket methods. 
     * @param choice is the choice we input.
     */
    private void executeBasketMenu(String choice)
    {
       if (choice.equals(ADD_TO_CART))
        {
            System.out.println("    Please enter the product ID\n");
        
            int id = reader.getInteger();
            id = findUsedID(id);
            
            System.out.println("\n    Please enter the amount\n");
        
            int amount = reader.getInteger();
                        
            while (manager.addToCart(id, amount) == false)
            {
                System.out.println("\nDo you want to add a lesser amount?\n");
                
                printMenu(binary);
        
                String add = reader.getString();
                if (add.equals(YES))
                {
                    System.out.println("    Please enter the amount\n");
        
                    amount = reader.getInteger();
                                                        
                }
                else
                    break;
            }
            
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
     * Print the title of the program and the authors name. 
     */
    private void printHeading(String menu)
    {
        System.out.println("\n******************************");
        System.out.println(" Stock Management Application ");
        System.out.println("    App05: by Andrei Cruceru  ");
        System.out.println("******************************");
        System.out.println(menu);
        System.out.println("******************************\n");
    }
        
}
