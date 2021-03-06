/**
 * This class will create a student with a student ID.
 * It will enroll the student to a course and print the details of it's course.
 * 
 * @author Andrei Cruceru
 * @version 12102020
 */
public class Student
{
    // Student name
    private String name;
    // Student ID
    private int studentId;
    // The course the student attends
    private Course course;
       
    /**
     * Give a name to this student
     */
    public Student(String name, int studentId)
    {
        this.name = name;
        this.studentId = studentId;
    }
    
    /**
     * Enrol a student on a course
     */
    public void enrolOnCourse(Course course)
    { 
        this.course = course;
    }
    
    /**
     * Return the name and id of the student
     */
    public void getStudentDetails()
    {
        System.out.println("Student name: " + name + ", Student ID: " + studentId);
    }
    
    /**
     * Print the final grades and marks for the student
     */
    public void getCourseDetails()
    {
        course.printCourseDetails();
    }
}
