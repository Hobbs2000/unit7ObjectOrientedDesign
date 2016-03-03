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
 * This is the panel where shapes are created, held, displayed, and edited
 */
public class DrawingPanel extends JPanel
{
    private final Color DEFAULT_COLOR = Color.BLACK;
    
    private Color currentColor;
    
    private ArrayList<Shape> shapes = new ArrayList<Shape>();
    private final int DEFAULT_RADIUS = 100;
    private final Point2D.Double DEFAULT_START = new Point2D.Double(200.0, 300.0);
  
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
     * Changes the current color by using a JColorChooser
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
     * Adds a circle to the shapes ArrayList
     */
    public void addCircle()
    {
        Shape newCircle = new Circle(currentColor, DEFAULT_START, DEFAULT_RADIUS);
        shapes.add(newCircle);
    }
    
    /**
     * Adds a square to the shapes ArrayList
     */
    public void addSquare()
    {
        Shape newSquare = new Square(currentColor, DEFAULT_START, DEFAULT_RADIUS);
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
     * Will paint all the shapes to the screen
     */
    public void paintComponent(Graphics g)
    {
        //Draw all the shapes except the selected one
        for (int i = 0; i < shapes.size(); i++)
        {
            if (shapes.get(i) != selectedShape)
            {
                shapes.get(i).draw(g, false);
            }
        }
        
        //This handles how the selected shape is being drawn
        if (selectedShape != null)
        {
            if(dragging)
            {
                //Move the shape to the position of the mouse
                double x = MouseInfo.getPointerInfo().getLocation().getX() - this.getLocationOnScreen().getX();
                double y = MouseInfo.getPointerInfo().getLocation().getY() - this.getLocationOnScreen().getY();
                selectedShape.move(x,y);
                selectedShape.draw(g, true);
            }
            else if (resizing)
            {
                double x = MouseInfo.getPointerInfo().getLocation().getX() - this.getLocationOnScreen().getX();
                double y = MouseInfo.getPointerInfo().getLocation().getY() - this.getLocationOnScreen().getY();
                
                //Gets the distance from the point clicked to the center, this will be the new radius
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
     * Returns the current color
     */
    public Color getColor()
    {
        return currentColor;
    }
    
    /**
     * Returns what layer the selected shape is on (different from its index in shapes)
     */
    public int getLayer()
    {
        return shapes.size() - selectedShapeIndex;
    }
    
    /**
     * Copies the attributes of the selected Shape into a new Shape that is added to the list of shapes
     */
    public void copy()
    {
        Color copyColor = selectedShape.getColor();
        double copyRadius = selectedShape.getRadius();
        
        //Cannot instantiate a basic Shape because the class is abstract
        //Must test what kind of shape it is going to be 
        if (selectedShape instanceof Circle)
        {
            shapes.add(new Circle(copyColor, DEFAULT_START, copyRadius));
        }
        else
        {
            shapes.add(new Square(copyColor, DEFAULT_START, copyRadius));
        }
    }
    
    /**
     * Will move the selected shape to the desired layer by changing its position in Shapes
     */
    public void setLayer(int newLayer)
    {
        int newLayerIndex;
        //Make sure the newLayer will not cause an index error
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
        
        //Copy and put the selected shape in its new index
        shapes.add(newLayerIndex, shapes.get(selectedShapeIndex));
        
        //Have to remove the remaining original shape from the list, but done differently 
        //depending on the values of selectedShapeIndex and newLayerIndex because of the way
        //ArrayList.add() works by shifting other elements indexes to make room for the added element
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
            //Will check to see if this mouse press is meant to resize the shape or move it or deselect the shape
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