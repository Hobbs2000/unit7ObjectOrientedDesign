public class BillfoldTester
{
    public static void main(String args[])
    {
        Billfold billfold = new Billfold();
        
        DriverLicense driver = new DriverLicense("Calvin", 2020);
        billfold.addCard(driver);
        
        IDCard id = new IDCard("Calvin", 59025);
        billfold.addCard(id);
        
        System.out.println(billfold.formatCards());
    }
}