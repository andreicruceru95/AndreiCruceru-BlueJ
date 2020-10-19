import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class represents a real life example of a course.
 * A course has a three years lenght and eight modules each year separated in two semesters.
 * It will calculate the credits for the course based on how many modules are completed and the overall grade of the modules.
 * It also allows the user to search modules based on their code, or part of their name.
 * 
 * @author Andrei Cruceru
 * @version 12102020
 */
public class Course
{
    public static final int LOWEST_PASS = 40;
    public static final int D_PASS = 50;
    public static final int C_PASS = 60;
    public static final int B_PASS = 70;
    public static final int MAXIMUM_MARK = 100;
    // Course name
    private String name;
    // Course Code
    private String code;
    //ArrayList of modules
    private ArrayList<Module> modules;
    private Module module;
    // Course credits
    private int credits = 0;
    // Marks for the modules
    private int mark = 0;
    private int finalMark = 0;
    // The final grade of the course
    private Grades finalGrade = null;
    //period variables(cannot be defined inside calculateForPeriod method)
    private int periodMark = 0;
    private int periodFinalMark = 0;
    private int periodCredits = 0;
    private Grades periodGrade = null; 
         
    /**
     * Add a name and code to this course.
     */
    public Course(String name, String code)
    {
        this.name = name;
        this.code = code;
        modules = new ArrayList<Module>();
    }
    
    /**
     * Add a module to the list.
     */
    public void addModule(Module newModule)
    {
        modules.add(newModule);
    }
    
    /**
     * This method will calculate the final grade of a student based on his percentage marks.
     * It will print this details to the terminal window.
     */
    public void getFinalGrade()
    {
        //Resetting the values of the variables before they are used
        mark = 0;
        credits= 0;
        finalMark = 0;
        
        modules.forEach(module ->
        {
            mark = mark + module.getMark();
            credits = credits + module.getCredits();
        });
        
        finalMark = mark / modules.size(); 
        finalGrade = convertToGrade(finalMark);
       
        printFinalGrade();
    }
    
    /**
     * This method will print out the final grades, marks and credits
     */
    private void printFinalGrade()
    {
        System.out.println("Your total marks for your " + modules.size() + " modules is: " + mark + "%"); 
        System.out.println("Your final mark is: " + finalMark + "%");
        System.out.println("Your final grade is: " + finalGrade + "!");
        System.out.println("Your final credits are: " + credits);
    }
       
    /**
     * Convert the marks into grades.
     */
    private Grades convertToGrade(int mark)
    {
        Grades grade = null;
                
        if (mark < LOWEST_PASS && mark > 0)
        {
            grade = Grades.F;
        }
        else if (mark >= LOWEST_PASS  && mark < D_PASS)
        {
            grade = Grades.D;
        }
        else if (mark >= D_PASS && mark < C_PASS)
        {
            grade = Grades.C;
        }
        else if (mark >= C_PASS && mark < B_PASS)
        {
            grade = Grades.B;
        }
        else if (mark >= B_PASS && mark < MAXIMUM_MARK)
        {
            grade = Grades.A;
        }
        else
        {
            grade = Grades.X;
        }
         
        return grade;
    }
    
    /**
     * This method will return the course details only.
     */
    private String getCourse()
    {
        return "Course Name: " + name + ", Course Code: " + code;
    }
    
    /**
     * Find a module using it's unique code
     */
    private Module findModule(String code)
    {
        for(Module module : modules)
        { 
            if(module.getCode() == code) 
            {
                return module;
            }
        }
        return null;
    }
    
    /**
     * Award mark to a module using it's unique code.
     */
    public void awardMark(String code, int mark)
    {
        Module module = findModule(code);
        
        if (module != null)
        {
            module.awardMark(mark);
        }
        else
        {
            System.out.println("Module not found!");
        }
    }
    
    /**
     * This method will print all the course details.
     * It will include separate marks for each modules and the total credits.
     */
    public void printCourseDetails()
    {
        System.out.println(getCourse());
                
        modules.forEach(module ->
        {
            getDetails(module);
        });
    }
    
    /**
     * Return the final mark value.
     */
    public void getFinalMark()
    {
        System.out.println("Final mark: " + finalMark + "%");
    }
    
    /**
     * Search for modules using their code.
     * A module code is made by year number and semester number (ex:Y1S1).
     * As another example Y1 will show you all the modules from year 1, S1 will show you all the modules from semesters 1.
     */
    public void searchByCode(String code)
    {
        List <Module> listClone = new ArrayList<Module>();
        
        for(Module module : modules) 
        { 
            if(module.getCode().contains(code))
 
            { 
                listClone.add(module);
            }
        }
        
        listClone.forEach(entry->
        {
            getDetails(entry);
        });
    }
    
    /**
     * This method will search the modules for the input word.
     */
    public void searchByName(String name)
    {
        List <Module> listClone = new ArrayList<Module>();
        
        for(Module module : modules)
        { 
            if(module.getTitle().contains(name))
 
            { 
                listClone.add(module);
            }
        }
        
        listClone.forEach(entry->
        {
            getDetails(entry);
        });
    }
    
    /**
     * Get details about a given module.
     */
    private void getDetails(Module module)
    {
        System.out.println("Module name: " + module.getTitle() + ", Module Code: " 
                           + module.getCode() + ", Mark: " + module.getMark() 
                           + "%" + ", Credits: " + module.getCredits());
    }
    
    /**
     * Calculate the grades for a semester or year.
     */
    public void calculateForPeriod(String code)
    {
        //reseting the values of the variables before they are used
        periodMark = 0;
        periodFinalMark = 0;
        periodCredits = 0; 
        
        List <Module> listClone = new ArrayList<Module>(); 
        
        for(Module module : modules) 
        { 
            if(module.getCode().contains(code))
 
            { 
                listClone.add(module);
            }
        }
        
        listClone.forEach(entry->
        {
            periodMark = periodMark + entry.getMark();
            periodCredits = periodCredits + entry.getCredits(); 
        });    
                
        System.out.println("For the given period, you have obtained " + periodMark/listClone.size() 
                           + "% mark and " + periodCredits + " Credits.");
        
        periodFinalMark = periodMark / listClone.size();
        periodGrade = convertToGrade(periodFinalMark);
        
        System.out.println("Your grade for the time period is " + periodGrade + " ");
        System.out.println("Here is a breakdown of your modules for the time given:");
            
        listClone.forEach(entry->
        {
            getDetails(entry);
        });
    }
}