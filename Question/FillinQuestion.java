import java.util.Scanner;
/**
 * This class supports fill in the blank questions
 */
public class FillinQuestion extends Question
{
    
    /**
     * 
     */
    public void setText( String questionText )
    {
       //Sample parameter: The maker of javas name is _Bob_
       Scanner parser = new Scanner( questionText );
       parser.useDelimiter( "_" );
       String question = parser.next();
       String answer = parser.next();
       question += "_______"+parser.next();
       
       super.setText( question );
       this.setAnswer( answer );
    }
}