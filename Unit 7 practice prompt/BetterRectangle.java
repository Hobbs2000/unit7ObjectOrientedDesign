import java.awt.Rectangle;

public class BetterRectangle extends Rectangle
{
    
    /**
     * 
     */
    public BetterRectangle(int x, int y, int width, int height)
    {
        super(x, y, width, height);
    }
    
    /**
     * 
     */
    public double getPerimeter()
    {
        double perimeter = super.getWidth()*2;
        perimeter += super.getHeight()*2;
        return perimeter;
    }
    
    /**
     * 
     */
    public double getArea()
    {
        double area = super.getWidth() * super.getHeight();
        return area;
    }
}