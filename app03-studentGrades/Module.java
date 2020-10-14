/**
 * This class will create modules for a course.
 * Each module will be given a mark and it will be considered completed if the mark is over 39%.
 * @author Andrei Cruceru
 * @version 12102020
 */
public class Module
{
    // Title and code for this course
    public String moduleTitle;
    public int moduleCode;
    // The marks and credits for this module
    public int moduleMark = 0;
    public int moduleCredits = 0;
    // The comfirmation that the course has been completed and marked
    public boolean isCompleted;
    public boolean isMarked;
    
    /**
     * Constructor method for this module.
    */
    public Module (String moduleTitle, int moduleCode)
    {
        this.moduleTitle = moduleTitle;
        this.moduleCode = moduleCode;
    }
    
    /**
     * This method will add points for this module
     */
    public void giveMark(int moduleMark)
    {
        if (moduleMark > 39 && moduleMark <= 100) 
        {
            isCompleted = true;
            isMarked = true;
            this.moduleMark = moduleMark;
            this.moduleCredits = 15;
            System.out.println(moduleTitle + " " + moduleCode + " recieves " + moduleMark + "%");
        }
        else if (moduleMark > 100) 
        {
            System.out.println("Maximum mark you can give is 100");
        }
        else if (moduleMark < 0) 
        {
            System.out.println("Please insert a positive number");
        }
        else
        {
            isCompleted = false;
            isMarked = true;
            this.moduleMark = moduleMark;
            System.out.println(moduleTitle + " " + moduleCode + " recieves " + moduleMark + "%");
        }
    }
    
    /**
     * This method will return the credits for a module.
     * It will return 15 if the module has a mark over 39% and 0 if the module has a mark less than 39%.
     */
    public int getCredits()
    {
        return moduleCredits;
    }
    
    /**
     * This method will tell us if the course is completed or not
     */
    public boolean isCompleted()
    {
        return isCompleted;
    }
    
    /**
     * This will return if the module has been marked.
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
        return moduleMark;
    }
    
    /**
     * This method will print the full module details
     */
    public void printModuleDetails()
    {
        System.out.println("Module name: " + moduleTitle + " Code: " + moduleCode + " Marks: " + moduleMark +"%");
    }
}