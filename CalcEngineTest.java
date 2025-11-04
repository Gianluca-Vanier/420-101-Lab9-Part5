

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class CalcEngineTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CalcEngineTest
{
    private CalcEngine testCalc;

    /**
     * Default constructor for test class CalcEngineTest
     */
    public CalcEngineTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        testCalc = new CalcEngine();
    }

    @AfterEach
    public void clear(){
        testCalc.clear();
    }
    
    @Test
    public void testNumPressed(){
        testCalc.numberPressed(1);
        assertEquals(1, testCalc.getDisplayValue());
        testCalc.numberPressed(1);
        assertEquals(11, testCalc.getDisplayValue());
    }
    
    @Test
    public void testAddition(){
        testCalc.numberPressed(1);
        testCalc.plus();
        testCalc.numberPressed(1);
        testCalc.equals();
        assertEquals(2, testCalc.getDisplayValue());
    }
    
    @Test
    public void testMinus(){
        testCalc.numberPressed(1);
        testCalc.minus();
        testCalc.numberPressed(1);
        testCalc.equals();
        assertEquals(0, testCalc.getDisplayValue());
    }
    
    @Test
    public void testMinusMinus(){
        testCalc.numberPressed(1);
        testCalc.minus();
        testCalc.minus();
        testCalc.numberPressed(1);
        testCalc.equals();
        assertEquals(2, testCalc.getDisplayValue());
    }
    
    @Test
    public void testPlusMinus(){
        testCalc.numberPressed(1);
        testCalc.plus();
        testCalc.minus();
        testCalc.numberPressed(1);
        testCalc.equals();
        assertEquals(0, testCalc.getDisplayValue());
    }
}
