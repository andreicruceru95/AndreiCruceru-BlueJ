/**
 * @author Andrei Cruceru
 * @version 12102020
 */
public class Module
{
    private String title;
    private int code;
    private int marks;
    
    //Constructor method for Module
    public Module (String title, int code)
    {
        this.title = title;
        this.code = code;
    }
    
    /**
     * This method will add points for this module
     */
    public void giveMarks(int marks)
    {
        this.marks = marks;
        System.out.println(title + " " + code + " recieves " + marks + "%"); 
    }
    
    /**
     * This method will print the full module details
     */
    public void printModuleDetails()
    {
        System.out.println("Module name: " + title + " Code: " + code + " Marks: " + marks +"%");
    }
}