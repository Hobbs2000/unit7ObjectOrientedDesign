import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.geom.Point2D;

/**
 * 
 */
public class DrawingPanel extends JPanel
{
    private final Color DEFAULT_COLOR = Color.BLACK;
    
    private Color currentColor;
    
    private ArrayList<Shape> shapes = new ArrayList<Shape>();
    
    private Shape selectedShape;
    
    /**
     * 
     */
    public DrawingPanel()
    {
        this.setBackground(Color.WHITE);
        currentColor = DEFAULT_COLOR;
    }
    
    /**
     * 
     */
    public void pickColor()
    {
        System.out.println("picking color");
    }
    
    /**
     * 
     */
    public void addCircle()
    {
        System.out.println("adding circle");
        Shape newCircle = new Circle(currentColor, new Point2D.Double(100.0, 100.0), 50);
        shapes.add(newCircle);
    }
    
    /**
     * 
     */
    public void addSquare()
    {
        System.out.println("adding square");
        Shape newSquare = new Square(currentColor,new Point2D.Double(100.0, 100.0), 50);
        shapes.add(newSquare);
    }
    
    /**
     * 
     */
    public Color getColor()
    {
        return currentColor;
    }
    
    
    /**
     * 
     */
    public class MouseClickListener implements MouseListener
    {
        /**
         * 
         */
        public void mouseClicked(MouseEvent e)
        {
        }
        /**
         * 
         */
        public void mousePressed(MouseEvent e)
        {
        }
        /**
         * 
         */
        public void mouseReleased(MouseEvent e)
        {
        }    
        /**
         * 
         */
        public void mouseEntered(MouseEvent e)
        {
        }
        /**
         * 
         */
        public void mouseExited(MouseEvent e)
        {
        }
    }
}