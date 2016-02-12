import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Point;
import java.awt.Graphics;
public class TriangleViewer
{
    private JFrame frame;
    private JPanel panel;
    
    private static final int WIDTH = 500;
    private static final int HEIGHT = 300;
    
    private Point p1, p2, p3; //Points of the triangle
    private Mouse mouse;
    
    private Graphics g;
    /**
     * 
     */
    public TriangleViewer()
    {
        frame = new JFrame();
        panel = new JPanel();
        frame.add(panel);
        
        clearPoints();
        
        mouse = new Mouse();
        panel.addMouseListener(mouse);
        
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    /**
     * 
     */
    public void clearPoints()
    {
        this.p1 = new Point(0,0);
        this.p2 = new Point(0,0);
        this.p3 = new Point(0,0);
    }
    
    /**
     * 
     */
    public static void main(String[] args)
    {
        TriangleViewer viewer = new TriangleViewer(); 
    }
    
    public void draw(int x1, int y1, int x2, int y2)
    {
        g.drawLine((int)x1, (int)y1, (int)x2, (int)x2);
    }
    
    /**
     * 
     */
    public class Mouse implements MouseListener
    {
        private int numClicks = 0;
        private JPanel container = panel;
        public void mousePressed(MouseEvent event)
        {
        }
        public void mouseReleased(MouseEvent event)
        {
        }
        public void mouseClicked(MouseEvent event)
        {
            numClicks++;
            if (numClicks == 1)
            {
                p1.setLocation(event.getX(), event.getY());
            }
            else if (numClicks == 2)
            {
                p2.setLocation(event.getX(), event.getY());
                draw(p1.getX(), p1.getY(), p2.getX(), p2.getY());
            }
            else if (numClicks == 3)
            {
                p3.setLocation(event.getX(), event.getY());
                draw(p1.getX(), p1.getY(), p3.getX(), p3.getY());
                draw(p2.getX(), p2.getY(), p3.getX(), p3.getY());
            }
            else
            {
                clearPoints();
                numClicks = 0;
            }
        }
        public void mouseEntered(MouseEvent event)
        {
        }
        public void mouseExited(MouseEvent event)
        {
        }
        
    }
}