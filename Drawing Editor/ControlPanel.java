import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ControlPanel extends JPanel
{
    private JButton pickColor, addCircle, addSquare, deselect;
    private JPanel colorShower;
    private JTextField layer;
    private JButton changeLayer;
    private JLabel layerLabel;
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
        
        deselect = new JButton("Deselect");
        deselect.addActionListener(buttonListener);
        this.add(deselect);
        
        layerLabel = new JLabel("Layer:");
        this.add(layerLabel);
        
        layer = new JTextField("0",3);
        this.add(layer);
        
        changeLayer = new JButton("Change Layer");
        changeLayer.addActionListener(buttonListener);
        this.add(changeLayer);
        
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
                colorShower.setBackground(canvas.getColor());
            }
            else if (e.getActionCommand() == "Add Circle")
            {
                canvas.addCircle();
            }
            else if (e.getActionCommand() == "Add Square")
            {
                canvas.addSquare();
            }
            else if (e.getActionCommand() == "Deselect")
            {
                canvas.deselect();
            }
            else if (e.getActionCommand() == "Change Layer")
            {
                int newLayer;
                try 
                {
                    newLayer = Integer.parseInt(layer.getText());
                }
                catch(NumberFormatException ex)
                {
                    System.out.println("Exception : "+ex);
                } 
                
                canvas.changeLayer(newLayer);
            }
            
        }
    }
}