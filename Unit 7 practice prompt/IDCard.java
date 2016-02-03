/**
 * 
 */
public class IDCard extends Card
{
    private int IDnumber;
    
    /**
     * 
     */
    public IDCard( String name, int id)
    {
        super(name);
        this.IDnumber = id;
    }
    
    /**
     * 
     */
    public int getIDnumber()
    {
        return this.IDnumber;
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
    
    /**
     * 
     */
    public boolean equals(Object other)
    {
        if (this.getClass() == other.getClass())
        {
            boolean isEqual = super.equals(other);
            
            IDCard otherID = (IDCard) other;
            if (this.getIDnumber() == otherID.getIDnumber())
            {
                return true;
            }
        }
        return false;
    }
}