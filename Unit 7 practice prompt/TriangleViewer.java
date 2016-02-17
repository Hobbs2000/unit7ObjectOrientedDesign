import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
public class TriangleViewer extends JFrame
{
    private static final int WIDTH = 500;
    private static final int HEIGHT = 300;

    private Mouse mouse;
    
    private TriangleComponent component;
    /**
     * 
     */
    public TriangleViewer()
    {  
        component = new TriangleComponent();
        component.clearPoints();
        this.add(component);
        
        mouse = new Mouse();
        this.addMouseListener(mouse);
        
        this.setSize(WIDTH, HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    /**
     * 
     */
    public static void main(String[] args)
    {
        TriangleViewer viewer = new TriangleViewer(); 
    }
    
    /**
     * 
     */
    public class Mouse implements MouseListener
    {
        private int numClicks = 0;
        public void mousePressed(MouseEvent event)
        {
        }
        public void mouseReleased(MouseEvent event)
        {
        }
        public void mouseClicked(MouseEvent event)
        {
            numClicks++;
            System.out.print(numClicks);
            if (numClicks >= 4)
            {
                System.out.println(" Clear\n");
                numClicks = 0;
                component.clearPoints();
                component.repaint();
                return;
            }
            
            component.update(numClicks, event.getX(), (event.getY()-30)); //Off by the title bar
            //System.out.println("Mouse Event X: "+event.getX() + " Y: "+event.getY());
            component.repaint();
        }
        public void mouseEntered(MouseEvent event)
        {
        }
        public void mouseExited(MouseEvent event)
        {
        }
        
    }
}