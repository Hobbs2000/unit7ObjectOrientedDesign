
public class TestBetterRectangle
{
    public static void main(String args[])
    {
        BetterRectangle rect = new BetterRectangle(10, 5, 23, 13);
        double perimeter = rect.getPerimeter();
        double area =  rect.getArea();
        System.out.println("Perimeter: "+perimeter+"\nArea: "+area);
    }
}