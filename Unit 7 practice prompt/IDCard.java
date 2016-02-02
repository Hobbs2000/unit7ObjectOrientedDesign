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
    public boolean equals(IDCard other)
    {
        if (super.equals(other))
        {
            if (other.getIDnumber() == this.getIDnumber())
            {
                return true;
            }
        }
    }
}