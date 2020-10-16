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
    // Course name
    private String name;
    // Course Code
    private String code;
    //ArrayList of modules
    public ArrayList<Module> modules;
    private Module module;
    // Course credits
    private int credits = 0;
    // Marks for the modules
    private int mark = 0;
    private int finalMark = 0;
    // The final grade of the course
    private String finalGrades;
         
    /**
     * Add a name and code to this course.
     */
    public Course(String name, String code)
    {
        this.name = name;
        this.code = code;
        modules = new ArrayList<Module>();
        finalGrades = null;
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
    public void calculateFinalGrades()
    {
        modules.forEach(module ->
        {
            mark = mark + module.getMark();
            credits = credits + module.getCredits();
        });
        System.out.println("Your total marks for your " + modules.size() + " modules is: " + mark); 
        finalMark = mark / modules.size(); 
        // Converting marks to grades
        if (finalMark < 40 && finalMark > 0)
        {
            finalGrades = "F";
        }
        else if (finalMark > 39 && finalMark < 50)
        {
            finalGrades = "D";
        }
        else if (finalMark > 49 && finalMark < 60)
        {
            finalGrades = "C";
        }
        else if (finalMark > 59 && finalMark < 70)
        {
            finalGrades = "B";
        }
        else if (finalMark > 69 && finalMark < 100)
        {
            finalGrades = "A";
        }
        else
        {
            System.out.println("Module marks should be a positive between 0 and 100!");
        }
        System.out.println("Your final mark is: " + finalMark + "%");
        System.out.println("Your final grade is: " + finalGrades);
        System.out.println("Your final credits are: " + credits);
    }
    
    /**
     * This method will return the course details only.
     */
    public String getCourse()
    {
        return "Course name: " + name + ", Course code: " + code;
    }
        
    /**
     * This method will print all the course details.
     * It will include separate marks for each modules and the total credits.
     */
    public void printCourseDetails()
    {
        System.out.println("Course name: " + name + ", Course code: " + code);
        System.out.println("Modules:");
        modules.forEach(module ->
        {
            System.out.println(module.getTitle() + "," + module.getCode() + ",Mark: " + module.getMark() + ", Credits: " + module.getCredits());
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
     * Search for modules using it's code.
     * A module code is made by year number and semester number (ex:Y1S1).
     * As another example Y1 will show you all the modules from year 1, S1 will show you all the modules from semesters 1.
     */
    public void searchCode(String code)
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
            System.out.println(entry.getTitle() + "," + entry.getCode() + ",Mark: " + entry.getMark() + ", Credits: " + entry.getCredits());
        });
    }
    
    public void searchName(String word)
    {
        List <Module> listClone = new ArrayList<Module>(); 
        for(Module module : modules)
        { 
            if(module.getTitle().contains(word))
 
            { 
                listClone.add(module);
            }
        }
        listClone.forEach(entry->
        {
            System.out.println(entry.getTitle() + "," + entry.getCode() + ",Mark: " + entry.getMark() + "%" + ", Credits: " + entry.getCredits());
        });
    }
}