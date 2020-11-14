import java.awt.Color; 
import enigma.console.*; 
import enigma.core.Enigma;

/**
 * Write a description of class Program here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Program
{
    private static final char CLEAR = '\u000c';
    private static StockApp app;

    /**
     * This class creates and runs an instance of
     * the StockApp class
     */
    public static void main()
    {
        System.out.println(CLEAR);
        
        app = new StockApp();
        app.run();
    }
}
