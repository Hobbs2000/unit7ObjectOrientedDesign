import java.awt.Point;
import java.awt.Graphics;
import javax.swing.JComponent;
public class TriangleComponent extends JComponent
{
    private Point p1, p2, p3; //Points of the triangle
    private int numClicks;
    
    /**
    * 
    */
    public void clearPoints()
    {
        p1 = new Point(0,0);
        p2 = new Point(0,0);
        p3 = new Point(0,0);
    }
    
    /**
     * 
     */
    public void update(int numClicks, int x, int y)
    {
        this.numClicks = numClicks;
        
        //System.out.println(" Passed in X: "+x+" Y: "+y);
        
        if (numClicks == 1)
        {
            p1.setLocation(x, y);
            //System.out.println("p1 x: "+p1.getX()+" y: "+p1.getY());
        }
        else if (numClicks == 2)
        {
            p2.setLocation(x, y);
            //System.out.println("p2 x: "+p2.getX()+" y: "+p2.getY());
        }
        else if (numClicks == 3)
        {
            p3.setLocation(x, y);
            //System.out.println("p3 x: "+p3.getX()+" y: "+p3.getY());
        }
        
    }
   
    /**
     * 
     */
    public void paintComponent(Graphics g)
    {
        if (numClicks == 2)
        {
            g.drawLine((int)p1.getX(), (int)p1.getY(), (int)p2.getX(), (int)p2.getY());
        }
        else if (numClicks == 3)
        {

            g.drawLine((int)p1.getX(), (int)p1.getY(), (int)p2.getX(), (int)p2.getY());

            g.drawLine((int)p1.getX(), (int)p1.getY(), (int)p3.getX(), (int)p3.getY());

            g.drawLine((int)p2.getX(), (int)p2.getY(), (int)p3.getX(), (int)p3.getY());
        }
    }
   
}