import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ControlPanel extends JPanel
{
    private JButton pickColor, addCircle, addSquare;
    private JPanel colorShower;
    private DrawingPanel canvas;
    private ActionListener buttonListener;
    public ControlPanel(DrawingPanel canvas)
    {
        buttonListener = new ButtonListener();
        
        this.canvas = canvas;
        
        pickColor = new JButton("Pick Color");
        pickColor.addActionListener(buttonListener);
        this.add(pickColor);       
        
        colorShower = new JPanel();
        colorShower.setSize(20, 20);
        colorShower.setBackground(canvas.getColor());
        this.add(colorShower);
        
        addCircle = new JButton("Add Circle");
        addCircle.addActionListener(buttonListener);
        this.add(addCircle);
        
        addSquare = new JButton("Add Square");
        addSquare.addActionListener(buttonListener);
        this.add(addSquare);
    }
    
    /**
     * 
     */
    public class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if (e.getActionCommand() == "Pick Color")
            {
                canvas.pickColor();
            }
            else if (e.getActionCommand() == "Add Circle")
            {
                canvas.addCircle();
            }
            else if (e.getActionCommand() == "Add Square")
            {
                canvas.addSquare();
            }
        }
    }
}