public class Library
{
    private TextBook[] bookShelf;
    private int position;
    private int borrowers;
    
    public Library(int max)
    {
       bookShelf = new TextBook[max];
       for(int x = 0; x<max; x++)
       {
           bookShelf[x] = new TextBook("Textbook " + (x+1), 5);
       }
    }
    
    public LibraryCard issueCard()
    {
        borrowers++;
        return new LibraryCard(10,(borrowers-1));
    }
    
    public TextBook borrowBook(LibraryCard card)
    {
        if((card.expired() == false) && (position < bookShelf.length))
        {
            TextBook book = bookShelf[position];
            bookShelf[position] = null;
            position++;
            card.swipe();
            return book;
        }
        else
        {
            return null;
        }
    }
    
    public void returnBook(TextBook book)
    {
        bookShelf[position-1] = book;
        position--;
    }
    
    public void describe()
    {
        System.out.println("The library has " + (bookShelf.length-position) + " books left on the shelf and has issued " + borrowers + " library cards");
    }
}
