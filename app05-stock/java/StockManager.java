import java.util.*;

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
    
    //Shopping cart and invoice for each transaction;
    private ShoppingCart cart;
    
    // A list with data type Product used for calculations.
    List <Product> listClone = new ArrayList<Product>();
       
    /**
     * Initialise the stock manager.
     * @param cart is an object of the ShoppingCart class.
     */
    public StockManager(ShoppingCart cart)
    {
        stock = new ArrayList<>();
        this.cart = cart;
    }
    
    /**
     * Add a product and the quantity you want to buy.
     */
    public boolean addToCart(int id, int amount)
    {
        Product product = findProduct(id);
        if (product.getQuantity() >= amount)
        {
            cart.addToCart(product, amount);
            product.setAmount(amount);
            
            return true;
        }
        else
        {
            System.out.println("    Quantity requested is too high for " + product.getName());
            
            return false;
        }
    }
    
    /**
     * Delete a product from cart.
     */
    public void deleteFromCart(int id)
    {
         Product product = findProduct(id);
         
         if (cart.findProduct(product.getID()) != null)
         {
             cart.deleteProduct(product);
         }
         else
             System.out.println("    Product not in cart");
    } 
    
    /**
     * Print the products from the cart.
     */
    public void printCart()
    {
        cart.printCart();
    }
    
    /**
     * Sell the products from the cart.
     */
    public void proceedWithCart()
    {
        cart.proceedWithCart();
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
     * @return the next available ID starting from 10.
     * @return the id found.
     */
    public int getNextId()
    {
        int id = 10;
        
        while(findProduct(id) != null)
        {
            id++;
        }
        
        return id;
    }
    
    /**
     * Rename a product based on it's id.
     * @param id is the id of the product we want to modify.
     * @param replacement is the new name of the product.
     */
    public void renameProduct(int id, String replacement)
    {
        Product product = findProduct(id);
        
        if (product != null)
        {
            product.replaceName(replacement);
        }
        
    }
       
    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void deliverProduct(int id, int amount)
    {
        Product product = findProduct(id);
        
        if (product != null)
        {
            product.increaseQuantity(amount);
            
        }
        else
        {
            System.out.println("    Product not found!");
        }
    }
    
    /**
     * Sell a quantity of a product based on the product's id.
     * @param id is the id of the product about to be sold.
     * @param amount is the amount about to be sold.
     * Print an error if no product is found.
     */
    public void sellMultiple(int id,int amount)
    {
        Product product = findProduct(id);
        
        if (product != null)
        {
            product.sellMultiple(amount);
        }
        else
        {
            System.out.println("    Product with id " + id + " not found");
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
     * Print he quantity of the given product in stock.
     */
    public void getQuantity(int id)
    {
        Product product = findProduct(id);
        
        if (product != null)
        {
            System.out.println(product.getQuantity());        
        }
        else
        {
            System.out.println("    Product not found!");
        }
    }
 
    /**
     * Print details of all the products.
     */
    public void printAllProductDetails()
    {
       printList(stock);
    }
        
    /**
     * Sell one of the given item.
     * Show the before and after status of the product.
     * @param id The ID of the product being sold.
     */
    public void sellOneProduct(int id)
    {
        Product product = findProduct(id);
        
        if(product != null) 
        {
            product.sellOne();
            
            getProductByID(id);
        }
    }
    
    /**
     * Get the product with the given id from the manager.
     * An error message is printed if there is no match.
     * @param id The ID of the product.
     * Print the Product details if one is found.
     */
    public void getProductByID(int id)
    {
        Product product = findProduct(id);
        
        if(product != null) 
        {
            System.out.println(product.toString());
        }
        else
        {
            System.out.println("    Product with ID: " + id +
                               " is not recognised.");
        }
    }
    
    /**
     * Search for a product.
     * @param word is the keyword we are looking for.
     */
    public void search(String word)
    {
        listClone.clear();
        
        for(Product product : stock) 
        { 
            if(product.getName().contains(word))  
            { 
                listClone.add(product);
            }
        }
        
        printList(listClone);
    }
    
    /**
     * Remove a product out of the stock
     * @param id is the id of the product we want to remove.
     */
    public void removeProduct(int id)
    {
        Product product = findProduct(id);
        
        if (product != null)
        {
            System.out.println("    Product " + product.getID() + " " + product.getName() +
                               " has been removed");
            stock.remove(product);        
        }
        
        else
        {
            System.out.println("    Product not found!");
        }
    } 
    
    /**
     * Search for product with low stock and add them to a list.
     */
    public void checkLowStock()
    {
        listClone.clear();
        
        for (Product product : stock)
        {
            if (product.checkLow() == true)
            {
                listClone.add(product);
            }
        }
        
        validate();
        verifyLow();
    }
    
    /**
     * Check if the list is empty or not.
     * @return true if not empty.
     * @return false if empty.
     */
    private boolean validate()
    {
        if (listClone.size() > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * Verify if there are low quantity products in the list
     */
    private void verifyLow()
    {
        if (validate() == true)
        {
            System.out.println("\n    The stock of the following products should be refilled\n");
        
            printList(listClone);
        }
        else
        {
            System.out.println("\n    The quantity of each product is at least 5\n");
        }
    }
    
    /**
     * Get delivery for products with low quantity.
     */
    public void refillStock()
    {
        checkLowStock();
        
        System.out.println("\n    Delivering products..\n");
        
        if(validate() == true)
        {
            listClone.forEach(product ->
            {
                product.increaseQuantity(5);    
            });
            System.out.println("\n    Success!\n");
                        
            printList(listClone);
        }
        else
        {
            System.out.println("    The quantity of each product is at least 5");
        }
    }
    
    /**
     * Sort a list of products by their quantity.
     */
    public void sortByQuantity()
    {
        Collections.sort(stock,new QuantitySorter());
        
        printList(stock);
    }
    
    /**
     * Sort a list of products by their name.
     */
    public void sortByName()
    {
        Collections.sort(stock,new NameSorter());
        
        printList(stock);
    }
    
    /**
     * Sort a list of products by ID.
     */
    public void sortByID()
    {
        Collections.sort(stock,new IDSorter());
        
        printList(stock);
    }
    
    /**
     * Print any given list.
     * @param list is a given ArrayList.
     */
    private void printList(List<Product> list)
    {
        list.forEach(product ->
        {
            System.out.println(product);
        }); 
    }
}
