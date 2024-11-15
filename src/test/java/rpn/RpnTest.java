package rpn;

import org.junit.jupiter.api.Test;

import stos.Exceptions.StackOverflowException;
import stos.Exceptions.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

public class RpnTest {
    @Test
    public void testSimpleAddition() throws StackOverflowException, EmptyStackException {
        Rpn rpn = new Rpn("2 3 +");
        assertEquals(5, rpn.evaluate());
    }

    @Test
    public void testSimpleSubtraction() throws StackOverflowException, EmptyStackException {
        Rpn rpn = new Rpn("5 2 -");
        assertEquals(3, rpn.evaluate());
    }

    @Test
    public void testSimpleMultiplication() throws StackOverflowException, EmptyStackException {
        Rpn rpn = new Rpn("4 3 *");
        assertEquals(12, rpn.evaluate());
    }

    @Test
    public void testComplexExpression() throws StackOverflowException, EmptyStackException {
        Rpn rpn = new Rpn("2 3 + 5 *");
        assertEquals(25, rpn.evaluate());
    }

    @Test
    public void testExpressionWithNegativeResult() throws StackOverflowException, EmptyStackException {
        Rpn rpn = new Rpn("3 5 -");
        assertEquals(-2, rpn.evaluate());
    }

    @Test
    public void testExpressionWithMultipleOperators() throws StackOverflowException, EmptyStackException {
        Rpn rpn = new Rpn("5 1 2 + 4 * + 3 -");
        assertEquals(14, rpn.evaluate());
    }

    @Test
    public void testInvalidExpression() {
        Rpn rpn = new Rpn("2 +");
        assertThrows(EmptyStackException.class, rpn::evaluate);
    }

    @Test
    public void testOverflowInExpression() {
        // utworzenie ciagu znakow ktory przepelni stos
        String entry = "";
        for (int i = 0; i < 41; i++) {
            entry += String.valueOf(i)+" ";
        }
        entry += "+";

        Rpn rpn = new Rpn(entry);
        assertThrows(StackOverflowException.class, rpn::evaluate);
    }
}