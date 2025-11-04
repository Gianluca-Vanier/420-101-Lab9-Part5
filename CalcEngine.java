/**
 * The main part of the calculator performing the arithmetic logic of the 
 * calculations.
 * 
 * @author: (none yet)
 * @version 0.1 (incomplete)
 */
public class CalcEngine
{
    private int displayValue;
        // The previous operator typed (+ or -).
    private char previousOperator;
        // The left operand to previousOperator.
    private int leftOperand;
    
    private int previousOperand;
    
    /**
     * Create a CalcEngine instance.
     */
    public CalcEngine()
    {
        displayValue = 0;
        previousOperator = ' ';
        leftOperand = 0;
        System.out.println("Display Value: " + displayValue);
        System.out.println("Previous Operator: " + previousOperator);
        System.out.println("Left Operand: " + leftOperand);
    }

    /**
     * Return the value of the calculator that should appear in the display right now.
     * @return The value to be shown on the calculator display.
     */
    public int getDisplayValue()
    {
        return displayValue;
    }

    /**
     * A number button was pressed. Process it.
     * @param number The single digit.
     */
    public void numberPressed(int number)
    {
        System.out.println("numberPressed called with: " + number);
        displayValue = displayValue * 10 + number;
        reportState("end of numberPressed");
    }

    /**
     * This method should be called when the '+' button was pressed. 
     */
    public void plus()
    {
        System.out.println("minus called");
        applyPreviousOperator();
        previousOperator = '+';
        displayValue = 0;
        reportState("end of plus");
    }

    /**
     * This method should be called when the '-' button was pressed.
     */
    public void minus()
    {
        System.out.println("minus called");
        applyPreviousOperator();
        if(previousOperator == '-'){
            previousOperator = '+';
            leftOperand = previousOperand;
        }
        if(previousOperator == ' '){
            previousOperator = '-';
            leftOperand = previousOperand;
        }
        displayValue = 0;
        reportState("end of minus");
    }
    
    /**
     * This method should be called when the '=' button was pressed.
     */
    public void equals()
    {
        System.out.println("equals called");
        if(previousOperator == '+') {
            displayValue = leftOperand + displayValue;
        }
        
        if(previousOperator == ' ') {
            displayValue = displayValue;
        }
        
        if(previousOperator == '-') {
            displayValue = leftOperand - displayValue;
        }
        leftOperand = 0;
        reportState("end of equals");
    }

    /**
     * This method should be called when the 'C' (clear) button was pressed.
     */
    public void clear()
    {
        displayValue = 0;
        leftOperand = 0;
        previousOperator = ' ';
        previousOperand = 0;
    }

    /**
     * Return the name of this calculator to be shown as the title of the application.
     * @return The title of this calculation engine.
     */
    public String getTitle()
    {
        return "Super Calculator";
    }

    /**
     * Return the name of the author of this application.
     * @return The author of this engine.
     */
    public String getAuthor()
    {
        return "Hacker T. Largebrain";
    }

    /**
     * Return the version number of this application.
     * @return The version number of this engine.
     */
    public String getVersion()
    {
        return "version 0.2";
    }
    
    private void applyPreviousOperator()
    {
        System.out.println("applyPreviousOperator called");
        if(previousOperator == '+') {
            leftOperand += displayValue;
            previousOperand = leftOperand;
        }
        else if(previousOperator == '-') {
            leftOperand -= displayValue;
            previousOperand = leftOperand;
        }
        else {
            // There was no preceding operator.
            leftOperand = displayValue;
            previousOperand = leftOperand;
        }
        reportState("end of applyPreviousOperator");
    }
    public void reportState(String where)
    {
        System.out.println("displayValue: " + displayValue +
                           " leftOperand: " + leftOperand +
                           " previousOperator: " + previousOperator + "previousOperand: " + previousOperand + where);
    }
}
