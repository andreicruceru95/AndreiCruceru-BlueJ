/**
 * This class will create modules for a course.
 * Each module will be given a mark and it will be considered completed if the mark is over 39%.
 * Each module recieves 15 credits if it has been completed.
 * 
 * @author Andrei Cruceru
 * @version 12102020
 */
public class Module
{
    // Title and code for this course
    private String title;
    private String code;
    // The marks and credits for this module
    private int mark = 0;
    private int credits = 0;
    // The comfirmation that the course has been completed and marked
    private boolean isCompleted;
    private boolean isMarked;
    
    private Grades grade;
    
    /**
     * Give a title and a code to this module.
     * The code should be Year followd by Semester (ex Y1S1);
     */
    public Module (String title, String code, int mark)
    {
        this.title = title;
        this.code = code;
        this.mark = mark;
    }
    
    /**
     * Award marks to a module.
     */
    public void awardMark(int mark)
    {
        this.mark = mark;
    }
    
    /**
     * This method will return the credits for a module.
     * It will return 15 if the module has a mark over 39% and 0 if the module has a mark less than 39%.
     */
    public int getCredits()
    {
        if(mark > 39)
        {
            credits = 15;
        }
        else
        {
            credits = 0;
        }
        return credits;
    }
    
    /**
     * This method will return the marks for a module
     */
    public int getMark()
    {
        return mark;
    }
    
    /**
     * Get module Title
     */
    public String getTitle()
    {
        return "Module title: " + title;
    }
    
    /**
     * Get module code.
     */
    public String getCode()
    {
        return "Module code: " + code;
    }
    
    /**
     * This method will print the full module details
     */
    public void printModuleDetails()
    {
        System.out.println("Name: " + title + " Code: " + code + " Marks: " + mark +"%" + "Credits " + credits);
    }
}