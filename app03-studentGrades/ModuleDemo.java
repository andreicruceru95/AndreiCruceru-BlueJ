/**
 * This class will create 24 modules for a Course object.
 *
 * @author Andrei Cruceru
 * @version 16102020
 */
public class ModuleDemo
{
    // public Module module;
    public Course course;
    
    /**
     * This constructor will create 24 new modules with a name, code and marking.
     */
    public ModuleDemo(Course course)
    {
        course.addModule(new Module("Web Development", "Y1S1", 34));
        course.addModule(new Module("Database Design", "Y1S1", 23));
        course.addModule(new Module("Programming Concepts", "Y1S1", 67));
        course.addModule(new Module("Computer Architecture", "Y1S1", 89));
        course.addModule(new Module("Application Programming", "Y1S2", 98));
        course.addModule(new Module("Data Warehousing", "Y1S2", 78));
        course.addModule(new Module("Networking", "Y1S2", 65));
        course.addModule(new Module("Professional Practice", "Y1S2", 76));
        course.addModule(new Module("Web Applications", "Y2S1", 56));
        course.addModule(new Module("Big Data", "Y2S1", 65));
        course.addModule(new Module("Information Security", "Y2S1", 23));
        course.addModule(new Module("Business Intelligence", "Y2S1", 97));
        course.addModule(new Module("Data Visualisation", "Y2S2", 33));
        course.addModule(new Module("Statistical Methods", "Y2S2", 89));
        course.addModule(new Module("Software Engeneering", "Y2S2", 56));
        course.addModule(new Module("Inteligence Systems", "Y2S2", 87));
        course.addModule(new Module("Data Science", "Y3S1", 96));
        course.addModule(new Module("Database Development", "Y3S1", 45));
        course.addModule(new Module("Cloud Computing", "Y3S1", 59));
        course.addModule(new Module("Database Technologies", "Y3S1", 45));
        course.addModule(new Module("Machine Learning", "Y3S2", 67));
        course.addModule(new Module("Network Security", "Y3S2", 82));
        course.addModule(new Module("Legal Aspects of IT", "Y3S2", 52));
        course.addModule(new Module("Knowledge-Based Systems", "Y3S2", 98));
    }
}
