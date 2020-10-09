import java.util.Date;
/**
 * This class will provide tickets for the class ticketMachine
 * @author Andrei Cruceru
 * @version 07102020
 */

public class Ticket
{
      // Every ticket has a destination, price and time stamp of purchase
      private String destination;
      public int price;
      private Date timeStamp;
      
      
      // Constructor method
      public Ticket(String destination, int price)
      {
          this.destination=destination;
          this.price = price;
          timeStamp = new Date();
      }
      //print ticket method
      public void printTicket()
      {
           System.out.println("##############################");
           System.out.println("Destination:  " + destination + "  ");
           System.out.println("#Price:        " + price + "pence        #");
           System.out.println("#" + timeStamp + "#");
           System.out.println("##############################");      
      }
      
} 