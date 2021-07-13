public class TextBook
{
    private String title;
    private int chapters;
    private int currentChapter;
    
    /**
     * Constructor for objects of class TextBook
     */
    public TextBook(String t,int l)
    {
        title = t;
        chapters = l;
        currentChapter = 0;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public void readNextChapter()
    {
        if(currentChapter > chapters-1)
        {
            System.out.println("You have already finished the book");
        }
        else
        {
            currentChapter++;
            if(currentChapter == chapters)
            {   
                System.out.println("You have now read the final chapter!");
            }
        }         
    }
    
    public boolean isFinished()
    {
        return currentChapter > chapters-1;  
    }
    
    public void closeBook()
    {
        currentChapter = 0;
    }
    
    public void describe()
    {
        System.out.println(title + " with " + (chapters - currentChapter) + " chapters left to read"); 
    }
}
