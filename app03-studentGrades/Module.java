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
    // The confirmation that the course has been completed and marked
    public boolean isCompleted;
    public boolean isMarked;
        
    /**
     * Give a title and a code to this module.
     * The code should contain the Year followed by Semester (ex Y1S1example);
     */
    public Module (String title, String code)
    {
        this.title = title;
        this.code = code;
    }
    
    /**
     * Award marks to a module.
     */
    public void awardMark(int mark)
    {
        this.mark = mark;
    }
    
    /**
     * Return the credits for a module.
     * It will return 15 if the module has a mark over 39% and 0 if the module has a mark less than 39%.
     */
    public int getCredits()
    {
        if(mark > 39)
        {
            credits = 15;
            isCompleted = true;
            isMarked = true;
        }
        else 
        {
            credits = 0;
            isMarked = true;
        }
        return credits;
        
    }

    
    /**
     * Return the marks for a module
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
        return title;
    }
    
    /**
     * Get module code.
     */
    public String getCode()
    {
        return code;
    }
    
    /**
     * Print the full module details
     */
    public void printModuleDetails()
    {
        System.out.println("Name: " + title + " Code: " + code + " Marks: " 
                           + mark +"%" + "Credits " + credits);
    }
}