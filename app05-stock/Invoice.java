import java.util.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Write a description of class Invoice here.
 *
 * @author (Andrei Cruceru)
 * @version (18112020)
 */
public class Invoice
{
    private final Date date;
    public static final double VAT = 0.2;
    private static final DecimalFormat df = new DecimalFormat("0.00");
    
    List <Product> products = new ArrayList<Product>();
    
    private final Random generator;
    private int invoiceNo;
    private String customer;
    private String customerType;
    private String address;
    private double vat;
    private double total;
    private double finalTotal;
    private int amount;
    
    public Invoice ()
    {
        generator = new Random();
        invoiceNo = 0;
        customer = null;
        customerType = null;
        date = new Date();
    }
    
    /**
     * 
     */
    public void addProduct(Product product)
    {
        products.add(product);
    }
    
    /**
     * 
     */
    private void getPrice()
    {
        System.out.println("\nProducts ordered: \n");
        
        for(Product product : products)
        {
            System.out.println("| Product: " + product.getID() + " | " + product.getName() + " | price " + 
                                product.getPrice() + "£ | amount " + product.getAmount() + " | Total: " + product.getTotal() + "£ |");
        }
    }
    
    private void calculateTotal()
    {
        for(Product product : products)
        {
            this.total = total + product.getTotal();
        }
    }
    
    /**
     * 
     */ 
    private void calculateVat()
    {
        this.vat = total * VAT;
    }
        
    /**
     * 
     */
    private void calculateTotalAfterVat()
    {
        this.finalTotal = total + vat;
    }
    
    /** 
     * 
     */
    private void setInvoiceNo()
    {
        this.invoiceNo = generator.nextInt(8908093) + 1908093;
        
        getInvoiceNo();
    }
        
    /** 
     * 
     */
    private void getInvoiceNo()
    {
        System.out.println(invoiceNo);
    }
     
    /**  
     * 
     */
    public void setCustomer(String customer)
    {
        this.customer = customer;
    }
    
    /**
     * 
     */
    public void setCustomerType(String type)
    {
        this.customerType = type;
    }
    
    /**
     * 
     */
    public void setCustomerAddress(String address)
    {
        this.address = address;
    }
             
    public void generateInvoice()
    {
        calculateTotal();
        calculateVat();
        calculateTotalAfterVat();
        
        printHeading();
        
        System.out.println("\n");
        System.out.println("Invoice No: ");
        
        setInvoiceNo();

        System.out.println("\n Date: " + date + "\n");
        System.out.println("\nCustomerName: " + customer);
        System.out.println("\nCustomer type: " + customerType);
        System.out.println("\nAddress: " + address);
        getPrice();
        
        System.out.println("\nTotal before VAT: " + total + "£\n");
        
        System.out.println("\nVAT: " + df.format(vat) + "£\n");
        
        System.out.println("\nTotal after VAT: " + df.format(finalTotal) + "£\n");
    }
    
    private void printHeading()
    {
        System.out.println("*****************");
        System.out.println("     INVOICE     ");
        System.out.println("*****************");
    }
}
