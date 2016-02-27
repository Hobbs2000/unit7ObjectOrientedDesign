import javax.swing.JComponent;
import java.awt.Color;
import java.awt.geom.Point2D;
import java.awt.Graphics;


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
    public boolean isInside(Point2D.Double point)
    {
        if ((point.getX() >= this.getX()) | (point.getX() <= (this.getX()+this.getRadius())))
        {
            if ((point.getY() >= this.getY()) | (point.getY() <= (this.getY()+this.getRadius())))
            {
                return true;
            }
        }
        return false;
    }
    
    /**
     * 
     */
    public boolean onBorder(Point2D.Double point)
    {
        //TODO: implement this
        return false;
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
    public int getX()
    {
        return (int)(getCenter().getX() - getRadius());
    }
    
    /**
     * 
     */
    public int getY()
    {
        return (int)(getCenter().getY() - getRadius());
    }
    
    /**
     * 
     */
    public Color getColor()
    {
        return this.color;
    }
    
    /**
     * 
     */
    public void draw(Graphics g, boolean selected)
    {
    }
    
    /**
     * 
     */
    public double getRadius()
    {
        return this.radius;
    }
}