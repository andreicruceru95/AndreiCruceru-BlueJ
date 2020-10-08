import java.util.Date;
/**
 * This class will provide tickets for the class ticketMachine
 * @author Andrei Cruceru
 * @version 07102020
 */

public class Ticket
{
      // fields
      public double price;
      private Date today;
      private String location;
      // Constructor method 
      public Ticket()
      {
          price=0;
      }
      
      public String getOptions()
      {
          return("Your options are: Amersham, High Wycombe or Aylesbury");
      }
      // Setting the destinations conditions
      public void setDestination(String destination)
      {
          if (destination.equals("Amersham")) {
              price=3.00;
              today = new Date();
              location="Amersham";
          }
          else if (destination.equals("Aylesbury")) {
              price=2.20;
              today = new Date();
              location="Aylesbury";
          }
          else if (destination.equals("High Wycombe")) {
               price=3.30;
               today=new Date();
               location="High Wycombe";
          }
          else{
               System.out.println("Please select a destination between Amersham, Aylesbury or High Wycombe!");
          }
              
      }
      // Return the price of the ticket
      public void printTicket()
      {
           System.out.println("##############################");
           System.out.println("  "+location+"  ");
           System.out.println("#            £"+price+"            #");
           System.out.println("#"+today+"#");
           System.out.println("##############################");      
      }
              
}
