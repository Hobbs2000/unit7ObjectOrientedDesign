import javax.swing.JPanel;
import javax.swing.JButton;


public class ControlPanel extends JPanel
{
    private JButton pickColor, addCircle, addSquare;
    private JPanel colorShower;
    private DrawingPanel canvas;
    public ControlPanel(DrawingPanel canvas)
    {
        this.canvas = canvas;
        
        pickColor = new JButton("Pick Color");
        this.add(pickColor);
        
        colorShower = new JPanel();
        colorShower.setSize(20, 20);
        colorShower.setBackground(canvas.getColor());
        this.add(colorShower);
        
        addCircle = new JButton("Add Circle");
        this.add(addCircle);
        
        addSquare = new JButton("Add Square");
        this.add(addSquare);
    }
    
    //Use action listener
    
}