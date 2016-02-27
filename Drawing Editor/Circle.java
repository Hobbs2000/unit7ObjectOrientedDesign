import java.awt.Color;
import java.awt.geom.Point2D;
import java.awt.Graphics;

public class Circle extends Shape
{
    public Circle(Color color, Point2D.Double center, double radius)
    {
        super(color, center, radius);
    }
    
    /**
     * 
     */
    public void draw(Graphics g, boolean selected)
    {
        g.setColor(this.getColor());
        
        if (selected == true)
        {
            g.drawOval(this.getX(), this.getY(), (int)this.getRadius(), (int)this.getRadius());
        }
        else
        {
            g.fillOval(this.getX(), this.getY(), (int)this.getRadius(), (int)this.getRadius());
        }
    }
}