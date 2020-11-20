import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * This class will compare and sort our products by name.
 * 
 * @author  Andrei Cruceru
 * @version 20112020
 */
public class NameSorter implements Comparator<Product>
{

    public int compare(Product one, Product another)
    {
        return one.getName().compareTo(another.getName());
    }
        
}