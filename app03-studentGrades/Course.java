import java.util.*;
/**
 * @author Andrei Cruceru
 * @version 12102020
 */
public class Course
{
    //course name
    private String courseName;
    //modules for course
    public Module module;
    
    private ArrayList<Module> modules;
    
    //constructor method
    public Course(String courseName)
    {
        this.courseName = courseName;
    }
    
    public void addFirstModule(Module newModule)
    {
        this.module = newModule;
    }
    
    public void calculateGrade()
    {
        
    }
}