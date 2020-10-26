/**
 * This class will create 24 modules for a Course object.
 * The purpose of this class is to test the application's features.
 *
 * @author Andrei Cruceru
 * @version 16102020
 */
public class ModuleDemo
{
    // public Module module;
    private Course course;
    
    /**
     * We create 24 new modules each with a name and code.
     */
    public ModuleDemo(Course course)
    {
        this.course = course;
        
        course.addModule(new Module("Web Development", "Y1S1LvL4WD"));
        course.addModule(new Module("Database Design", "Y1S1LvL4DD"));
        course.addModule(new Module("Programming Concepts", "Y1S1LvL4PC"));
        course.addModule(new Module("Computer Architecture", "Y1S1LvL4CA"));
        course.addModule(new Module("Application Programming", "Y1S2LvL4AP"));
        course.addModule(new Module("Data Warehousing", "Y1S2LvL4DW"));
        course.addModule(new Module("Networking", "Y1S2LvL4N"));
        course.addModule(new Module("Professional Practice", "Y1S2LvL4PP"));
        course.addModule(new Module("Web Applications", "Y2S1LvL5WA"));
        course.addModule(new Module("Big Data", "Y2S1LvL5BD"));
        course.addModule(new Module("Information Security", "Y2S1LvL5IS"));
        course.addModule(new Module("Business Intelligence", "Y2S1LvL5BI"));
        course.addModule(new Module("Data Visualisation", "Y2S2LvL5DV"));
        course.addModule(new Module("Statistical Methods", "Y2S2LvL5SM"));
        course.addModule(new Module("Software Engeneering", "Y2S2LvL5SE"));
        course.addModule(new Module("Inteligence Systems", "Y2S2LvL5IS"));
        course.addModule(new Module("Data Science", "Y3S1LvL6DS"));
        course.addModule(new Module("Database Development34kjl", "Y3S1LvL6DD"));
        course.addModule(new Module("Cloud Computing", "Y3S1LvL6CD"));
        course.addModule(new Module("Database Technologies", "Y3S1LvL6DT"));
        course.addModule(new Module("Machine Learning", "Y3S2LvL6ML"));
        course.addModule(new Module("Network Security", "Y3S2LvL6NS"));
        course.addModule(new Module("Legal Aspects of IT", "Y3S2LvL6LA"));
        course.addModule(new Module("Knowledge-Based Systems", "Y3S2LvL6KS"));
    }
    
    /**
     * We award marks to the 24 modules.
     */
    public void awardMarks()
    {
        //show the course details before awarding mark to the modules.
        course.printCourseDetails();
        //award mark for each module.
        course.awardMark("Y1S1LvL4WD", 54);
        course.awardMark("Y1S1LvL4DD", 98);
        course.awardMark("Y1S1LvL4PC", 67);
        course.awardMark("Y1S1LvL4CA", 89);
        course.awardMark("Y1S2LvL4AP", 98);
        course.awardMark("Y1S2LvL4DW", 78);
        course.awardMark("Y1S2LvL4N", 65);
        course.awardMark("Y1S2LvL4PP", 76);
        course.awardMark("Y2S1LvL5WA", 56);
        course.awardMark("Y2S1LvL5BD", 65);
        course.awardMark("Y2S1LvL5IS", 48);
        course.awardMark("Y2S1LvL5BI", 97);
        course.awardMark("Y2S2LvL5DV", 53);
        course.awardMark("Y2S2LvL5SM", 89);
        course.awardMark("Y2S2LvL5SE", 56);
        course.awardMark("Y2S2LvL5IS", 87);
        course.awardMark("Y3S1LvL6DS", 96);
        course.awardMark("Y3S1LvL6DD", 45);
        course.awardMark("Y3S1LvL6CD", 59);
        course.awardMark("Y3S1LvL6DT", 45);
        course.awardMark("Y3S2LvL6ML", 67);
        course.awardMark("Y3S2LvL6NS", 82);
        course.awardMark("Y3S2LvL6LA", 52);
        course.awardMark("Y3S2LvL6KS", 98);
        // Message.
        System.out.println("===================================");
        System.out.println("After awarding marks to the modules");
        System.out.println("===================================");
        //print the course details after awarding marks.
        course.printCourseDetails();
    }
}
