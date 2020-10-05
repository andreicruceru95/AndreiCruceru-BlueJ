
/**
 * The class Course will create a course for students to attend.
 *
 * @author:Andrei Cruceru
 * @version 05/10/20
 */
public class Course
{
    // defining variables code and title
    public String code;
    public String title;
    
  

    /**constructor method
     */
    
    public Course(String courseCode, String courseTitle){
        code=courseCode;
        title=courseTitle;
    
    
    }
    
    
    /**
     * This method will return the name and code of the course
     */
    public String returnCourse()
    
    {
        // Return code and title separated by a space
        return code+" "+title;
    }
    
   
}
