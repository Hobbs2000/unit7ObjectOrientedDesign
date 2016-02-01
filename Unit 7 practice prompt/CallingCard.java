/**
 * 
 */
public class CallingCard extends Card
{
    private int cardNumber;
    private int PIN;
    
    /**
     * 
     */
    public CallingCard(String name, int PIN, int cardNumber)
    {
        super(name);
        this.PIN = PIN;
        this.cardNumber = cardNumber;
    }
    
    /**
     * 
     */
    public String format()
    {
        String formatted = super.format();
        formatted += "\nCard Number: "+this.cardNumber;
        formatted += "\nPIN number: "+this.PIN;
        return formatted;
    }
}