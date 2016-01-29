/**
 * 
 */
public class IDCard extends Card
{
    private int IDnumber;
    
    /**
     * 
     */
    public IDCard(int id, String name)
    {
        super(name);
        this.IDnumber = id;
    }
    
    /**
     * 
     */
    public String format()
    {
        String formated = super.format();
        formated += "\nID number: "+this.IDnumber;
        return formated;
    }
    
    
}