/**
 * The Student class represents all the details and functions  
 * of a student in this system. It store details such as name and
 * book borrowed and allows the student to study.
 * 
 * @author 184504
 * @version 7/12/18
 */
public class Student
{
    // instance variables - replace the example below with your own
    private String stuName;
    private Library lib;
    private LibraryCard card;
    private TextBook textBook;

    /**
     * Constructor for objects of class Student.
     * 
     * @param name <the name of the student>, library <an instance of the Library class which will contain objects of the TextBook class>
     */
    public Student(String name, Library library)
    {
        stuName = name;
        lib = library;
        card = lib.issueCard();
        textBook = null;
    }

    /**
     * Tests if the student has completed their studies
     *
     * @return true/false
     */
    public boolean finishedStudies()
    {
        return ((textBook == null) && (card.expired() == true));
    }
    
    /** 
     * Allows the student to studies.
     * If they don't have a textbook, they get a new one.
     * If they have a book but it is finished, they return it.
     * If they have a book with chapters to be read, they read a chapter.
     */
    public void study()
    {
        if((textBook == null) && (finishedStudies() == false))
        {
            textBook = lib.borrowBook(card);
        }
        else
        {
            if(textBook.isFinished() == false)
            {
                textBook.readNextChapter();
            }
            else
            {
                textBook.closeBook();
                lib.returnBook(textBook);
                textBook = null;
            }
        }
    }
    
    /** 
     * Describes the current state of the student.
     * If they don't have a textbook, prints out that they don't.
     * If they have a book but it is finished, it says that the book is finished.
     * If they have a book with chapters to be read, it says that the student is currently reading the book.
     */
    public void describe()
    {
        if(textBook == null)
        {
             System.out.println("Student " + stuName + " does not have a book.");
             card.describe();
        }
        else if(textBook.isFinished() == false)
        {
            System.out.println("Student " + stuName + " has a book called " + textBook.getTitle());
            textBook.describe();
            System.out.println("The student is reading the book");
        }
        else
        {
            System.out.println("Student " + stuName + " has a book called " + textBook.getTitle());
            textBook.describe();
            System.out.println("This book is finished");
        }
   }
}
