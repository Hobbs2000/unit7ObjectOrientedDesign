import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 */
public class ButtonViewer
{
    private static final int FRAME_WIDTH = 100;
    private static final int FRAME_HEIGHT = 60;
    
    private JFrame frame;
    private JPanel panel;
    private JButton button;
    private JButton button2;
    private JLabel label;
    private ClickListener listener;
    
    /**
     * 
     */
    public ButtonViewer()
    {
        this.frame = new JFrame();
        
        panel = new JPanel();
        frame.add(panel);
        
        label = new JLabel();
        panel.add(label);
        
        button = new JButton("Click Me!");
        panel.add(button);
        
        button2 = new JButton("Click Me Too!");
        panel.add(button2);
        
        listener = new ClickListener();
        button.addActionListener(listener);
        button2.addActionListener(listener);
        
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    /**
     * 
     */
    public static void main(String[] args)
    {
        ButtonViewer bViewer = new ButtonViewer();
    }
    
    
    
    /**
    * An action listener that prints a message 
    */
    public class ClickListener implements ActionListener
    {    
        public void actionPerformed(ActionEvent event)
        {
            label.setText(event.getActionCommand()+" was clicked.");
        }
    }
}