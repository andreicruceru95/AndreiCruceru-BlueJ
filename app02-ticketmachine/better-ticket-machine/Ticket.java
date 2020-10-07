 /**
 * This class will provide destinations for the class ticketMachine
 * @author Andrei Cruceru
 * @version 07102020
 */

public class Ticket
{
      // Declaring a field 'price'
      public double price; 
      // Constructor method 
      public Ticket()
      {
          price=0;
      }
      // Setting the destinations conditions
      public void setDestination(String destination, String date)
      {
          if (destination.equals("Amersham")) {
              price=3.00;
          }
          else if (destination.equals("Aylesbury")) {
              price=2.20;
          }
          else if (destination.equals("High Wycombe")) {
               price=3.30;
          }
          else{
               System.out.println("Please select a destination between Amersham, Aylesbury or High Wycombe!");
          }
              
      }
      // Return the price of the ticket
      public double getPrice()
      {
           return price ;
      }
              
}
