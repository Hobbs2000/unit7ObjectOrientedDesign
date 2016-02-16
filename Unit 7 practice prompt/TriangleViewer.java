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

    private Mouse mouse;
    
    private TriangleComponent component;
    /**
     * 
     */
    public TriangleViewer()
    {
        frame = new JFrame();
        panel = new JPanel();
        frame.add(panel);
       
        this.component = new TriangleComponent();
        this.component.clearPoints();
        panel.add(component);
        
        mouse = new Mouse();
        panel.addMouseListener(mouse);
        
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
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
            System.out.print(numClicks);
            if (numClicks >= 4)
            {
                System.out.println(" Clear\n");
                numClicks = 0;
                component.clearPoints();
                return;
            }
            
            component.update(numClicks, event.getX(), event.getY());
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