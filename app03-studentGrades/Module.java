/**
 * This class will create modules for a course.
 * Each module will be given a mark and it will be considered completed if the mark is over 39%.
 * @author Andrei Cruceru
 * @version 12102020
 */
public class Module
{
    public String title;
    public int code;
    public int mark = 0;
    public boolean isCompleted;
    public boolean isMarked;
    
    //Constructor method for Module
    public Module (String title, int code)
    {
        this.title = title;
        this.code = code;
    }
    
    /**
     * This method will add points for this module
     */
    public void giveMark(int mark)
    {
        if (mark > 39 && mark <= 100) 
        {
            isCompleted = true;
            isMarked = true;
            this.mark = mark;
            System.out.println(title + " " + code + " recieves " + mark + "%");
        }
        else if (mark > 100) 
        {
            System.out.println("Maximum mark you can give is 100");
        }
        else if (mark < 0) 
        {
            System.out.println("Please insert a positive number");
        }
        else
        {
            isCompleted = false;
            isMarked = true;
            this.mark = mark;
            System.out.println(title + " " + code + " recieves " + mark + "%");
        }
    }
    
    /**
     * This method will tell us if the course is completed or not
     */
    public boolean isCompleted()
    {
        return isCompleted;
    }
    
    /**
     * 
     */
    public boolean isMarked()
    {
        return isMarked;
    }
    
    /**
     * This method will return the marks for a module
     */
    public int getMark()
    {
        return mark;
    }
    
    /**
     * This method will print the full module details
     */
    public void printModuleDetails()
    {
        System.out.println("Module name: " + title + " Code: " + code + " Marks: " + mark +"%");
    }
}