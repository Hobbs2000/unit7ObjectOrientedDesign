import java.awt.Color;
import java.awt.geom.Point2D;
import java.awt.Graphics;

public class Square extends Shape
{
    public Square(Color color, Point2D.Double center, double radius)
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
            g.drawRect(this.getX(), this.getY(), (int)this.getRadius()*2, (int)this.getRadius()*2);
        }
        else
        {
            g.fillRect(this.getX(), this.getY(), (int)this.getRadius()*2, (int)this.getRadius()*2);
        }
    }
}