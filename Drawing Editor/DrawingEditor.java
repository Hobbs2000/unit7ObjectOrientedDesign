import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.lang.Thread;

/**
 * 
 */
public class DrawingEditor extends JFrame
{
    private final int WIDTH = 800;
    private final int HEIGHT = 600;
    
    private DrawingPanel canvas;
    private ControlPanel control;
    /**
     * 
     */
    public DrawingEditor()
    {
        //Setup a layout in order to specify where certain component should go
        this.setLayout(new BorderLayout());
        
        //Put the drawing area in the middle
        canvas = new DrawingPanel();
        this.add(canvas, BorderLayout.CENTER);
        //Put the controls at the bottom
        control = new ControlPanel(canvas);
        this.add(control, BorderLayout.SOUTH);
        
        //Complete the JFrame setup
        this.setName("Drawing Editor");
        this.setSize(WIDTH, HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    /**
     * 
     */
    public void repaint()
    {
        super.repaint();
        canvas.repaint();
    }
    
    
    /**
     * 
     */
    public static void main(String[] args) throws java.lang.InterruptedException
    {
        DrawingEditor editor = new DrawingEditor();
        while (true)
        {
            editor.repaint();
            Thread.sleep(33);
        }
    }
}