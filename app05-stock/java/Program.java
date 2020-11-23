/**
 * Write a description of class Program here.
 *
 * @author Andrei Cruceru
 * @version 14112020
 */
public class Program
{
    private static final char CLEAR = '\u000c';
    
    private static StockApp app;

    /**
     * This class creates and runs an instance of
     * the StockApp class
     * 
     * Clear the terminal before each use.
     */
    public static void main()
    {
        System.out.println(CLEAR);
        
        app = new StockApp();
        app.run();
    }
}
