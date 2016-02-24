import javax.swing.JComponent;
import java.awt.Color;
import java.awt.geom.Point2D;


public abstract class Shape extends JComponent
{
    private Color color;
    private Point2D.Double center;
    private double radius;
    
    public Shape(Color color, Point2D.Double center, double radius)
    {
        this.color = color;
        this.center = center;
        this.radius = radius;
    }
    
    /**
     * 
     */
    public void move(double x, double y)
    {
        center = new Point2D.Double(x, y);
    }
    
    /**
     * 
     */
    public void isInside(Point2D.Double point)
    {
        //TODO: implement this
    }
    
    /**
     * 
     */
    public void onBorder(Point2D.Double point)
    {
        //TODO: implement this
    }
    
    /**
     * 
     */
    public Point2D.Double getCenter()
    {
        return this.center;
    }
    
    /**
     * 
     */
    public void setRadius(double newRadius)
    {
        this.radius = newRadius;
    }
    
    /**
     * 
     */
    public double getRadius()
    {
        return this.radius;
    }
}