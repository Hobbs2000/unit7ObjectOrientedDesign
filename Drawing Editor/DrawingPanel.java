import javax.swing.JPanel;
import java.awt.Color;

/**
 * 
 */
public class DrawingPanel extends JPanel
{
    private final Color DEFAULT_COLOR = Color.BLACK;
    
    private Color currentColor;
    
    /**
     * 
     */
    public DrawingPanel()
    {
        currentColor = DEFAULT_COLOR;
    }
    
    /**
     * 
     */
    public Color getColor()
    {
        return currentColor;
    }
}