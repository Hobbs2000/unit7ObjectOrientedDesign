/**
 * 
 */
public class DriverLicense extends Card
{
    private int expireYear;
    
    /**
     * 
     */
    public DriverLicense(String name, int expireYear)
    {
        super(name);
        this.expireYear = expireYear;
    }
    
    /**
     * 
     */
    public String format()
    {
        String formatted = super.format();
        formatted += "\nExpiration Year: "+this.expireYear;
        return formatted;
    }
    
    /**
     * 
     */
    public boolean isExpired(int currentYear)
    {
        if (this.expireYear < currentYear)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}