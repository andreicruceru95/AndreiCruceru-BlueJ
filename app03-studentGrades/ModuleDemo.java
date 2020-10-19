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
        
        course.addModule(new Module("Web Development", "Y1S1h6r7d"));
        course.addModule(new Module("Database Design", "Y1S1423ew"));
        course.addModule(new Module("Programming Concepts", "Y1S13rfs"));
        course.addModule(new Module("Computer Architecture", "Y1S13yth5"));
        course.addModule(new Module("Application Programming", "Y1S245ys5y"));
        course.addModule(new Module("Data Warehousing", "Y1S254dry"));
        course.addModule(new Module("Networking", "Y1S265wbg"));
        course.addModule(new Module("Professional Practice", "Y1S2reg54"));
        course.addModule(new Module("Web Applications", "Y2S165hrh"));
        course.addModule(new Module("Big Data", "Y2S145td"));
        course.addModule(new Module("Information Security", "Y2S145t55"));
        course.addModule(new Module("Business Intelligence", "Y2S16uf65"));
        course.addModule(new Module("Data Visualisation", "Y2S256byhf"));
        course.addModule(new Module("Statistical Methods", "Y2S2gfh54"));
        course.addModule(new Module("Software Engeneering", "Y2S2hgj45"));
        course.addModule(new Module("Inteligence Systems", "Y2S2j4j5"));
        course.addModule(new Module("Data Science", "Y3S1jh435"));
        course.addModule(new Module("Database Development34kjl", "Y3S1ada32"));
        course.addModule(new Module("Cloud Computing", "Y3S132h4v"));
        course.addModule(new Module("Database Technologies", "Y3S1345vs4"));
        course.addModule(new Module("Machine Learning", "Y3S24f4f"));
        course.addModule(new Module("Network Security", "Y3S223gfd5"));
        course.addModule(new Module("Legal Aspects of IT", "Y3S2fgf3d"));
        course.addModule(new Module("Knowledge-Based Systems", "Y3S2k4fh7"));
    }
    
    /**
     * We award marks to the 24 modules.
     */
    public void awardMarks()
    {
        //show the course details before awarding mark to the modules.
        course.printCourseDetails();
        //award mark for each module.
        course.awardMark("Y1S1h6r7d", 34);
        course.awardMark("Y1S1423ew", 98);
        course.awardMark("Y1S13rfs", 67);
        course.awardMark("Y1S13yth5", 89);
        course.awardMark("Y1S245ys5y", 98);
        course.awardMark("Y1S254dry", 78);
        course.awardMark("Y1S265wbg", 65);
        course.awardMark("Y1S2reg54", 76);
        course.awardMark("Y2S165hrh", 56);
        course.awardMark("Y2S145td", 65);
        course.awardMark("Y2S145t55", 48);
        course.awardMark("Y2S16uf65", 97);
        course.awardMark("Y2S256byhf", 33);
        course.awardMark("Y2S2gfh54", 89);
        course.awardMark("Y2S2hgj45", 56);
        course.awardMark("Y2S2j4j5", 87);
        course.awardMark("Y3S1jh435", 96);
        course.awardMark("Y3S1ada32", 45);
        course.awardMark("Y3S132h4v", 59);
        course.awardMark("Y3S1345vs4", 45);
        course.awardMark("Y3S24f4f", 67);
        course.awardMark("Y3S223gfd5", 82);
        course.awardMark("Y3S2fgf3d", 52);
        course.awardMark("Y3S2k4fh7", 98);
        // Message.
        System.out.println("===================================");
        System.out.println("After awarding marks to the modules");
        System.out.println("===================================");
        //print the course details after awarding marks.
        course.printCourseDetails();
    }
}
