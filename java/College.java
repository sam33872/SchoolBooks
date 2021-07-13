import java.util.Random;
import java.util.ArrayList;
/**
 * The College class is an overview class that is used 
 * to run the whole system. It has access to every method
 * and has control over students leaving the system.
 * 
 * @author 184504
 * @version 7/12/18
 */
public class College
{
    // instance variables - replace the example below with your own
    private ArrayList<Student> students;
    private Library lib;
    private Random random;
    
    /**
     * Constructor for objects of class College
     * 
     * @param s <the number of students in the college>, b <the number of books in the library>
     */
    public College(int s, int b)
    {
       lib = new Library(b);
       students = new ArrayList<Student>(s);
       for(int x = 0; x<s; x++)
       {
           Student student = new Student("Student" + (x+1), lib);
           students.add(student);
       }
       random = new Random();
    }
    
    /**
     * Main function for running outside of blueJ.
     * 
     * @param args <allows the user to enter multiple inputs>
     * In this case, this allows the user to enter value for students,
     * textBooks and steps. These are then used to create an instance of 
     * the college class and run a method within a set amount of times.
     */
    public static void main(String[] args)
    {
        int students, textBooks, steps;
        if(args.length > 2)
        {
            steps = Integer.parseInt(args[2]);
        }
        else
        {
            steps = 100;
        }
        if(args.length > 1)
        {
            textBooks = Integer.parseInt(args[1]);
        }
        else
        {
            textBooks = 15;
        }
        if(args.length == 1)
        {
            students = Integer.parseInt(args[0]);
        }
        else
        {
            students = 10;
        }
        College college = new College(students,textBooks);
        college.runCollege(steps);
    }
    
    /**
     * Describes the current state of the college.
     */
    private void describe()
    {
        System.out.println("The college currently has " + students.size() + " hard-working students");
        lib.describe();
    }
    
    /**
     * Tests if the student has completed their studies
     * If there are no students, then says the place is quiet.
     * If the student has finsihed then they are removed.
     * If they haven't finsihed then they study.
     */
    public void nextStep()
    {
        if(students.size() == 0)
        {
            System.out.println("Everything has gone quiet");
        }
        else
        {
            int num = random.nextInt(students.size());
            if(students.get(num).finishedStudies() == true)
            {
                students.remove(num);
                System.out.println("The student has graduated and left the college");
            }
            else
            {
                students.get(num).study();
            }
        }
    }
    
    /**
     * Runs the college.
     * Runs the describe and nextStep methods a inputted number of times, which
     * allows studys to study and eventually graduate/leave. 
     * 
     * @param nSteps <defines the number of times college will advance>
     */
    public void runCollege(int nSteps)
    {
        for(int x = 0; x < nSteps; x++)
        {
            System.out.println("Step " + (x + 1));
            describe();
            nextStep();
        }
    }
}
