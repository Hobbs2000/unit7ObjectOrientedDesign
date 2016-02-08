import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class ClickListener implements ActionListener
{
    private int count;
    
    public ClickListener()
    {
        count = 0;
    }
    
    public void actionPerformed(ActionEvent event)
    {
        count++;
        System.out.println("Times Clicked: "+count);
    }
}