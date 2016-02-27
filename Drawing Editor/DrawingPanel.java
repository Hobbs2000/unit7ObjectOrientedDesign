import javax.swing.JPanel;
import javax.swing.JComponent;
import java.awt.Component;
import java.awt.Color;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.geom.Point2D;
import java.awt.Point;
import java.awt.Graphics;

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
        
        Mouse mouse = new Mouse();
        this.addMouseListener(mouse);
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
        Shape newCircle = new Circle(currentColor, new Point2D.Double(250.0, 300.0), 100);
        shapes.add(newCircle);
    }
    
    /**
     * 
     */
    public void addSquare()
    {
        System.out.println("adding square");
        Shape newSquare = new Square(Color.GRAY,new Point2D.Double(200.0, 300.0), 100);
        shapes.add(newSquare);
    }
    
    /**
     * 
     */
    public void paintComponent(Graphics g)
    {
        for (int i = 0; i < shapes.size(); i++)
        {
            if (shapes.get(i) != selectedShape)
            {
                shapes.get(i).draw(g, false);
            }
        }
        
        if (selectedShape != null)
        {
            selectedShape.draw(g, true);
        }
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
    public class Mouse implements MouseListener
    {
        /**
         * 
         */
        public void mouseClicked(MouseEvent e)
        {          
            for (int i = 0; i < shapes.size(); i++)
            {
                if (shapes.get(i).isInside(new Point2D.Double(e.getX(), e.getY())))
                {
                    selectedShape = shapes.get(i);
                    break;
                }
            }
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