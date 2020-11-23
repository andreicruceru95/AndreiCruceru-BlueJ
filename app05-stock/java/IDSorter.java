import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * This class will compare and sort our products by id increment.
 * 
 * @author  Andrei Cruceru
 * @version 20112020
 */
public class IDSorter implements Comparator<Product>
{

    public int compare(Product one, Product another)
    {
        int returnVal = 0;
    
        if(one.getID() < another.getID())
        {
            returnVal =  -1;
        }
        else if(one.getID() > another.getID()) 
        {
            returnVal =  1;
        }
        else if(one.getID() == another.getID())
        {
            returnVal =  0;
        }
        
        return returnVal;
    }
}
