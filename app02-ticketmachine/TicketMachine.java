import java.util.*;
import java.io.*;
import java.lang.management.*;
import java.text.*;
import java.util.*;
/**
 * TicketMachine models a ticket machine that issues
 * flat-fare tickets.
 * @author Andrei Cruceru 
 * @version 11102020
 */
public class TicketMachine
{
    // We create three tickets with three different prices in pences
    public Ticket aylesburyTicket=new Ticket("Aylesbury", 220);
    public Ticket amershamTicket = new Ticket("Amersham", 300);
    public Ticket highWycombeTicket = new Ticket("High Wycombe", 330);
    // Enum coin instance
    public Coin coin;
    // Initial balance
    private int balance;
    
    /**
     * Constructor method for this class
     */
    public TicketMachine()
    {
        balance = 0;
    }
        
    /**
     * Please insert 10p, 20p, 100p or 200p!
     */
    public void insertCoin(Coin coin)
    {
        System.out.println("You have inserted: " + coin + " pences");
        balance = balance + coin.getValue();
        System.out.println("Your balance is "+ balance + " pences");
    }
    
    /**
     * Print all the tickets that are availeble for purchase
     */
    public void showAvailableTickets()
    {
        System.out.println("Our avaiblable tickets are: ");
        amershamTicket.printTicket();
        aylesburyTicket.printTicket();
        highWycombeTicket.printTicket();
    }
    
    /**
     * Please select your destination between Aylesbury, Amersham
     * and High Wycombe!
     * The ticket will be printed once you inserted enough coins!
     */
    public void buyTicket(String destination)
    {
        if (destination.equals("Aylesbury")) 
        {
            if (balance<220)
            {
                System.out.println("Insert " + (220 - balance) + " more pences!");
            }
            else
            {
                System.out.println("Transaction aproved");
                System.out.println("Here is your ticket");
                aylesburyTicket.printTicket();
                balance = balance - 220;             
                System.out.println("Your can get a refund of " + balance + "pences!");
            }
            
        }
        else if(destination.equals("Amersham")) 
        {
            if (balance < 300) 
            {
                System.out.println("Insert " + (300 - balance) + "pences!");
            }
            else 
            {
                System.out.println("Transaction aproved");
                System.out.println("Here is your ticket");
                amershamTicket.printTicket();
                balance = balance - 300;
                System.out.println("Your can get a refund of " + balance + "pences!");
            }
            
        }
        else if(destination.equals("High Wycombe"))
        {
            if (balance<330) 
            {
                System.out.println("Insert more £" + (330 - balance) + " pences!");
            }
            else 
            {
                System.out.println("Transaction aproved");
                System.out.println("Here is your ticket");
                highWycombeTicket.printTicket();
                balance = balance - 330;
                System.out.println("Your can get a refund of " + balance + "pences!");
            }
            
        }
        else 
        {
            System.out.println("We only offer ticket to:");
            System.out.println("#Aylesbury, #Amersham or #High Wycombe!");
            System.out.println("Please select a destination between:");
            System.out.println("Aylesbury, Amersham or High Wycombe");
        }
    }
    
    /**
     * This will allow you to check your balance at any time.
     */
    public int checkBalance()
    {
        return balance;
    }
    
    /**
     * Request a refund for any outstanding balance.
     */ 
    public void askForRefund()
    {
       System.out.println("You have been refunded: " + balance + " pences!");
       balance = 0;
    }
    
}