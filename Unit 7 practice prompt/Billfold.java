/**
 * 
 */
public class Billfold
{
    private Card card1, card2;
    
    /**
     * 
     */
    public Billfold(Card card1, Card card2)
    {
        this.card1 = card1;
        this.card2 = card2;
    }
    
    /**
     * 
     */
    public Billfold()
    {
    }
    
    /**
     * 
     */
    public void addCard(Card newCard)
    {
        if (this.card1 == null)
        {
            this.card1 = newCard;
        }
        else if (this.card2 == null)
        {
            this.card2 = newCard;
        }
    }
    
    /**
     * 
     */
    public String formatCards()
    {
        String cards = "";
        cards += "["+this.card1.format()+"]\n";
        cards += "["+this.card2.format()+"]\n";
        return cards;
    }
}