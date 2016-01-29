/**
 * 
 */
public class ChoiceQuestion extends Question
{
    private int numChoices;
    
    /**
     * 
     */
    public ChoiceQuestion()
    {
        super();
        numChoices = 0;
    }
    
    /**
     * 
     */
    public void addChoice( String choice, boolean correct )
    {
        numChoices ++;
        this.addText("\n"+ numChoices + ")" + choice);
        if (correct)
        {
            String choiceString = "" + numChoices;
            this.setAnswer( choiceString );
        }
    }
    
}