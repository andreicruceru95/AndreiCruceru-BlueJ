import java.awt.Color; 
import enigma.console.*; 
import enigma.core.Enigma;

public class test 
{
    Color color1 = new Color(0,0,0);
    Color color2 = new Color (142,124,43);
    public static void main() {
        TextAttributes attrs = new TextAttributes(Color.BLUE, Color.WHITE);//Changes the color of background and text

        s_console.setTextAttributes(attrs); //Sets the colors to the console

        System.out.println("Hello World!"); //Default system println
        System.out.println("Hello World!");
        attrs = new TextAttributes(Color.RED, Color.GREEN);
        s_console.setTextAttributes(attrs);
        System.out.println("Hello World!");
        System.out.println("Hello World!");
        
    }

    public static final Console s_console; //Declare the Console
    static
    {
        s_console = Enigma.getConsole(); 
        //Sets the console to the Enigma console, named "Hellow World!"
    } 
}