import java.util.*;
import java.io.*;
import java.lang.management.*;
import java.text.*;
import java.util.*;
/**
 * TicketMachine models a ticket machine that issues
 * flat-fare tickets.
 * @author Andrei Cruceru 
 * @version 09102020
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
    
    //constructor method. Any new TicketMachine has a initial balance of 0
    public TicketMachine()
    {
        balance = 0;
    }
    // Insert coin method. After every coin inserted, you will see the balance on screen
    public void insertCoin(Coin coin)
    {
        System.out.println("You have inserted: " + coin + " pences");
        balance = balance + coin.getValue();
        System.out.println("Your balance is "+ balance + " pences");
    } 
    // Select your destination and print the ticket at the same time
    public void buyTicket(String destination)
    {
        if (destination.equals("Aylesbury")){
             if (balance<220){
                System.out.println("Insert " + (220 - balance) + " more pences!");
             }
             else{
             aylesburyTicket.printTicket();
             balance = balance - 220;             
             System.out.println("Your can get a refund of " + balance + "pences!");
             }
        }
        else if(destination.equals("Amersham")) {
             if (balance < 300) {
                System.out.println("Insert " + (300 - balance) + "pences!");
             }
             else {
                amershamTicket.printTicket();
                balance = balance - 300;
                System.out.println("Your can get a refund of " + balance + "pences!");
             }
        }
        else if(destination.equals("High Wycombe")) {
             if (balance<330) {
                System.out.println("Insert more £" + (330 - balance) + " pences!");
             }
             else {
                highWycombeTicket.printTicket();
                balance = balance - 330;
                System.out.println("Your can get a refund of " + balance + "pences!");
             }
        }
        else {
            System.out.println("We only offer ticket to:");
            System.out.println("#Aylesbury, #Amersham or #High Wycombe!");
            System.out.println("Please select a destination between:");
            System.out.println("Aylesbury, Amersham or High Wycombe");
        }
    }
    // Check your balance
    public int checkBalance()
    {
        return balance;
    }
    // Ask for a refund and clear the balance
    public void askForRefund()
    {
       System.out.println("You have been refunded: " + balance + " pences!");
       balance = 0;
    }
    
}