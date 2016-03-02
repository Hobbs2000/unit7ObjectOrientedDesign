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
import java.awt.MouseInfo;
import javax.swing.JColorChooser;
import java.util.Collections;

/**
 * 
 */
public class DrawingPanel extends JPanel
{
    private final Color DEFAULT_COLOR = Color.BLACK;
    
    private Color currentColor;
    
    private ArrayList<Shape> shapes = new ArrayList<Shape>();
  
    private Shape selectedShape;
    private int selectedShapeIndex = 0;
    private boolean dragging;
    private boolean resizing;
    
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
        currentColor = JColorChooser.showDialog(this, "Pick Color", currentColor);
        if (selectedShape != null)
        {
            selectedShape.setColor(currentColor);
        }
    }
    
    /**
     * 
     */
    public void addCircle()
    {
        Shape newCircle = new Circle(currentColor, new Point2D.Double(200.0, 300.0), 100);
        shapes.add(newCircle);
    }
    
    /**
     * 
     */
    public void addSquare()
    {
        Shape newSquare = new Square(currentColor,new Point2D.Double(200.0, 300.0), 100);
        shapes.add(newSquare);
    }
    
    /**
     * Deselects the current shape
     */
    public void deselect()
    {
        selectedShape = null;
        selectedShapeIndex = -1;
        dragging = false;
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
            if(dragging)
            {
                double x = MouseInfo.getPointerInfo().getLocation().getX() - this.getLocationOnScreen().getX();
                double y = MouseInfo.getPointerInfo().getLocation().getY() - this.getLocationOnScreen().getY();
                selectedShape.move(x,y);
                selectedShape.draw(g, true);
            }
            else if (resizing)
            {
                double x = MouseInfo.getPointerInfo().getLocation().getX() - this.getLocationOnScreen().getX();
                double y = MouseInfo.getPointerInfo().getLocation().getY() - this.getLocationOnScreen().getY();
                
                double distance = Math.sqrt(Math.pow(selectedShape.getCenter().getX()-x, 2)+Math.pow(selectedShape.getCenter().getY()-y,2));
                selectedShape.resize(distance);
                selectedShape.draw(g, true);
            }
            else
            {
                selectedShape.draw(g, false);
            }
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
    public int getLayer()
    {
        return shapes.size() - selectedShapeIndex;
    }
    
    /**
     * 
     */
    public void copy()
    {
        Color copyColor = selectedShape.getColor();
        double copyRadius = selectedShape.getRadius();
        if (selectedShape instanceof Circle)
        {
            shapes.add(new Circle(copyColor, new Point2D.Double(200.0, 300.0), copyRadius));
        }
        else
        {
            shapes.add(new Square(copyColor, new Point2D.Double(200.0, 300.0), copyRadius));
        }
    }
    
    /**
     * Will move the selected shape to the desired layer by changing its position in Shapes
     */
    public void setLayer(int newLayer)
    {
        int newLayerIndex;
        //Make sure the newLayer will not cause an error
        if (newLayer <= 0)
        {
            newLayerIndex = shapes.size() - 1;
        }
        else if (newLayer >= shapes.size())
        {
            newLayerIndex = 0;
        }
        else
        {
            newLayerIndex = shapes.size() - newLayer;
        }
        
        shapes.add(newLayerIndex, shapes.get(selectedShapeIndex));
        
        //Have to remove the remaining un-moved shape from the list, but done differently 
        //depending on the values of selectedShapeIndex and newLayerIndex because of the way
        //ArrayList.add() works
        if (selectedShapeIndex > newLayerIndex)
        {
            shapes.remove(selectedShapeIndex+1); 
            selectedShapeIndex = newLayerIndex;
        }
        else if (selectedShapeIndex < newLayerIndex)
        {
            shapes.remove(selectedShapeIndex);
            if (newLayerIndex == (shapes.size()-1))
            {
                Collections.swap(shapes, shapes.size()-2, shapes.size()-1);
            }
            selectedShapeIndex = newLayerIndex;
        }
        
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
            boolean any = false;
            for (int i = shapes.size()-1; i >= 0; i--)
            {
                if (shapes.get(i).isInside(new Point2D.Double(e.getX(), e.getY())))
                {
                    selectedShape = shapes.get(i);
                    selectedShapeIndex = i;
                    any = true;
                    break;
                }
            }
            if (any == false)
            {
                selectedShape = null;
                selectedShapeIndex = -1;
            }
        }
        /**
         * 
         */
        public void mousePressed(MouseEvent e)
        {
            if (selectedShape.isInside(new Point2D.Double(e.getX(), e.getY())))
            {
                if (selectedShape.onBorder(new Point2D.Double(e.getX(), e.getY())) == true)
                {
                    System.out.println("Resizing");
                    resizing = true;
                    dragging = false;
                }
                else
                {
                    resizing = false;
                    dragging = true;
                }
            }
            else
            {
                resizing = false;
                dragging = false;
            }
        }
        /**
         * 
         */
        public void mouseReleased(MouseEvent e)
        {
            dragging = false;
            resizing = false;
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