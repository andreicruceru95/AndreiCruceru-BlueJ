
/**
 * The customers of our shop. 
 *
 * @author (Andrei Cruceru)
 * @version (18112020)
 */
public class Customers
{
    private String name;
    private String address;
    private String type;
    
    public Customers(String name, String address, String type)
    {
        this.name = name;
        this.address = address;
        this.type = type;
    }
    
    public void getDetails()
    {
        System.out.println("\n");
        System.out.println("_______________________.");
        System.out.println("|Name    | " + name );
        System.out.println("-------------------------");
        System.out.println("|Address | " + address);
        System.out.println("-------------------------");
        System.out.println("|Type    | " + type   );
        System.out.println("------------------------.");
        System.out.println("\n");
    }
}
