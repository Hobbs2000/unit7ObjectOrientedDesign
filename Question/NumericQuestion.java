
/**
 * 
 */
public class NumericQuestion extends Question
{
    private double answer;
    
    /**\
     * Good example of method overloading (same method name but different parameters)
     * Sets the correct answer
     */
    public void setAnswer(double correctAnswer)
    {
        this.answer = correctAnswer;
    }
    
    /**
     * Good example of method overriding (same method name and parameters)
     */
    public boolean checkAnswer( String response )
    {
        double responseAsDouble = Double.parseDouble( response );
        //Checks to see if the response is within a one one-hundredth of the correct answer
        return Math.abs(responseAsDouble- answer) <= 0.01;
    }
}