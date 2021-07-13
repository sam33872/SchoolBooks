public class LibraryCard
{
    private int limit;
    private int borrowed;
    private String reference;

    public LibraryCard(int l, int n)
    {
        limit = l;
        borrowed = 0;
        reference = "cardID " + n;
    }
    
    public void swipe()
    {
        borrowed++;
    }
    
    public boolean expired()
    {
        return borrowed > (limit-1);
    }
    
    public String getCardRef()
    {
        return reference;
    }
    
    public void describe()
    {
        System.out.println("Library card " + reference + " with " + (limit - borrowed) + " books left"); 
    }
}
