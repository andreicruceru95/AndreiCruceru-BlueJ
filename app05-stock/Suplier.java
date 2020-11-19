import java.util.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Write a description of class Supliers here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Suplier
{
    public static final double COUNTER = 0.99;
    public static final double VAT = 0.2;
    public static final DecimalFormat DF = new DecimalFormat("0.00");
    
    private Random generator;
    private String name;
    private String address;
    private Date date;
    private double price = 0;
     
    private List<String> phones = new ArrayList<String>();
    
    public Suplier()
    {
        generator = new Random();
        
        phones.add("Google Pixel 5         ");
        phones.add("Google Pixel 4         ");
        phones.add("Google Pixel 3A        ");
        phones.add("Pixel Stand            ");
        phones.add("Google Pixel Buds      ");
        phones.add("Air Pods Pro           ");
        phones.add("Apple Watch Series 6   ");
        phones.add("Apple IPhone 12 Pro    ");
        phones.add("Apple MacBook Pro      ");
        phones.add("Apple IPad             ");
        phones.add("Samsung Galaxy S20     ");
        phones.add("Galaxy Fold 5G         ");
        phones.add("Samsung Galaxy Z Fold  ");
        phones.add("Samsung QLED 4K Smart  ");
        phones.add("Samsung 4K Ultra HD    ");
        phones.add("Huawei P40 Pro         ");
        phones.add("Huawei MateBook X      ");
        phones.add("Huawei nova 5T Dual Sim");
        phones.add("Sony Xperia 10 II      ");
        phones.add("ASUS ROG               ");
        phones.add("Razer Phone 2          ");
        phones.add("Oppo Reno 2            ");
        phones.add("Motto G8 Lite          ");
        phones.add("OnePlus 8 Pro 5G       ");
        phones.add("Motorola Edge 5g       ");
    }
    
    public String getNames(int index)
    {
        return phones.get(index);
    }
    
    public int getSize()
    {
        return phones.size();
    }
    
    /**
     * 
     */
    public double generatePrice()
    {
        // Set prices for products
        int price = 0;
        
        price = generator.nextInt(500) + 400;
        
        return price + COUNTER ;
                    
    }
    
    public double getPrice()
    {
        this.price = generatePrice();
        
        return price;
    }
    
    public void generateInvoice(int index, int amount, double price)
    {
        printHeading();
        
        System.out.println("Date     : " + date); 
        System.out.println("\n");
        System.out.println("___________________________________");
        System.out.println("|Name    | Carphone Warehouse      |");
        System.out.println("-----------------------------------|");
        System.out.println("|Address | 127 High Street, London |");
        System.out.println("|__________________________________|");
        System.out.println("\nTo\n");
        System.out.println("-----------------------------------|");
        System.out.println("|Name    |  Andrei's stock         |");
        System.out.println("|----------------------------------|");
        System.out.println("|Address |  Bucks New University   |");
        System.out.println("|__________________________________|");
        
        System.out.println("\nProduct name     :" + phones.get(index));
        System.out.println("\nProduct quantity :" + amount);
        System.out.println("\nPrice            :" + price);
        System.out.println("\nVAT              :" + DF.format(price * VAT));
        System.out.println("\nPrice with VAT   :" + price + DF.format(price * VAT));
        
    }
    
    private void printHeading()
    {
        System.out.println("*****************");
        System.out.println("     INVOICE     ");
        System.out.println("*****************");
    }
}

