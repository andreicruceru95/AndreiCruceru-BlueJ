
/**
 * The class Course will create a course for students to attend.
 *
 * Andrei Cruceru
 * 02/10/20
 */
public class Course
{
    // variables 'code' and 'title' takes 'g400' and 'computing'
    private String code;
    private String title;
    private String fullName=code+title;
  

    /**constructor method for class Course
     * 
     */
    
    public Course(String courseCode, String courseTitle){
        code=courseCode;
        title=courseTitle;
    
    
    }
    
    
    /**
     * This method will return the name and code of the course
     *
     * 
     */
    public String getCourse()
    
    {
        // Return ""
        return code+" "+title;
    }
}
