import java.util.*;
import java.io.*;
import java.lang.management.*;
import java.text.*;
import java.util.*;
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
    //class field
    public Coin coin;
    //list of tickets
    public ArrayList<Ticket> tickets;
    //constructor method
    public TicketMachine()
    {
        tickets= new ArrayList<Ticket>();
    }
    //add a ticket to the list
    public void addTickets(Ticket newTicket)
    {
        tickets.add(newTicket);
    }
    //print a list of available tickets
    public void printTicket()
    {
         for(int i=0; i < tickets.size(); i++)
         {
            System.out.println(tickets.get(i));
         }
    }
    //select a ticket out of the list above
    public void selectTicket(String destination)
    {
        for(int i=0; i < tickets.size(); i++)
        {
            if (destination.equals("Amersham")) {
            System.out.println("You have selected: "+destination);
            i=0;
            System.out.println(tickets.get(i));
            break;
            }
        else if (destination.equals("High Wycombe")) {
            System.out.println("You have selected: "+destination);
            i=1;
            System.out.println(tickets.get(i));
            break;
            }
        else if(destination.equals("Aylesbury")) {
            System.out.println("You have selected: "+destination);
            i=2;
            System.out.println(tickets.get(i));
            break;
            }
        else {
            System.out.println("We do not sell any tickets except");
            System.out.println("Amersham, High Wycombe and Aylesbury");
            }
            
        }
    }

}
