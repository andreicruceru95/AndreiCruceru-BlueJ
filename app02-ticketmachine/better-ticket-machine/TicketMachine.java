import java.util.*;
import java.io.*;
/**
 * TicketMachine models a ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * Instances will check to ensure that a user only enters
 * sensible amounts of money, and will only print a ticket
 * if enough money has been input.
 * 
 * @author Andrei Cruceru 
 * @version 07102020
 */
public class TicketMachine
{
    // 
    private double price;
    // The amount of money inside this machine
    private double balance;
    // The total amount of money collected by this machine.
    private double total;
    // 
    private Ticket ticket;
    private ArrayList<Ticket> aListTicket = new ArrayList<Ticket>();
    public Coin coin;

    /**
     * Create a machine that issues tickets
     */
    public TicketMachine(Coin coin)
    {
        this.coin=coin;
        balance = 0;
        total = 0;
    }
    
        public ArrayList getTickets()
    {
        return aListTicket;
    }
    
    /**
     * Return The amount of money already inserted for the
     * next ticket.
     */
    public double getBalance()
    {
        return balance;
    }

    /**
     * Receive an amount of money from a customer.
     * 
     */
    public void insertMoney(Coin coin)
    {
        price = this.ticket.getPrice();
        if (coin == Coin.P10) {
            
            System.out.println("You just inserted £" + coin.P10 + "!");
            balance = balance + coin;
            System.out.println("You need another £" + price - balance + "!");
        }
        else if (coin == Coin.P20) {
            //similar condition
        }
        else if (coin == Coin.P100) {
            //condition
        }
        else if (coin == Coin.P200) {
            //condition
        }
        else {
            System.out.println ("You can only insert £0.10, £0.20, £1.00 and £2.00 coins");
        }
    }
    
    /**
     * Print a ticket if enough money has been inserted, and
     * reduce the current balance by the ticket price. Print
     * an error message if more money is required.
     */
    public void printTicket()
    {
        if(balance >= price) {
            // Simulate the printing of a ticket.
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("# " + price + " cents.");
            System.out.println("##################");
            System.out.println();

            // Update the total collected with the price.
            total = total + price;
            // Reduce the balance by the prince.
            balance = balance - price;
        }
        else {
            System.out.println("You must insert at least: " +
                               (price - balance) + " more cents.");
                    
        }
    }

    /**
     * Return the money in the balance.
     * The balance is cleared.
     */
    public int refundBalance()
    {
        int amountToRefund;
        amountToRefund = balance;
        balance = 0;
        return amountToRefund;
    }
}
