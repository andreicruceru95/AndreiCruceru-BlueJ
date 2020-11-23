import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * This class will compare and sort our products by quantity increment.
 * 
 * @author  Andrei Cruceru
 * @version 20112020
 */
public class QuantitySorter implements Comparator<Product>
{

    public int compare(Product one, Product another)
    {
        int returnVal = 0;
    
        if(one.getQuantity() < another.getQuantity())
        {
            returnVal =  -1;
        }
        else if(one.getQuantity() > another.getQuantity()) 
        {
            returnVal =  1;
        }
        else if(one.getQuantity() == another.getQuantity())
        {
            returnVal =  0;
        }
        
        return returnVal;
    
    }
}
