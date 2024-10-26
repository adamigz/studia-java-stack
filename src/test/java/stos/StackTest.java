package stos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.Test;
import stos.Exceptions.EmptyStackException;

public class StackTest {

    @Test
    public void testPushAndPop() throws EmptyStackException {
        Stack stack = new Stack();
        stack.push("A");
        assertEquals("A", stack.pop());
    }

    @Test
    public void testPushMultipleAndPop() throws EmptyStackException {
        Stack stack = new Stack();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        assertEquals("C", stack.pop());
        assertEquals("B", stack.pop());
        assertEquals("A", stack.pop());
    }

    @Test
    public void testPopEmptyStackException() {
        Stack stack = new Stack();
        assertThrows(EmptyStackException.class, stack::pop);
    }

    @Test
    public void testPeek() throws EmptyStackException {
        Stack stack = new Stack();
        stack.push("A");
        assertEquals("A", stack.peek());
        assertEquals("A", stack.pop());
    }

    @Test
    public void testPeekEmptyStackException() {
        Stack stack = new Stack();
        assertThrows(EmptyStackException.class, stack::peek);
    }

    @Test
    public void testPushPopEmptyAfterwards() throws EmptyStackException {
        Stack stack = new Stack();
        stack.push("A");
        stack.pop();
        assertThrows(EmptyStackException.class, stack::pop);
    }

    @Test
    public void testPushNull() throws EmptyStackException {
        Stack stack = new Stack();
        stack.push(null);
        assertEquals(null, stack.peek());
        assertEquals(null, stack.pop());
    }

    @Test
    public void testMultiplePushesIncludingNull() throws EmptyStackException {
        Stack stack = new Stack();
        stack.push("A");
        stack.push(null);
        stack.push("B");
        assertEquals("B", stack.pop());
        assertEquals(null, stack.pop());
        assertEquals("A", stack.pop());
    }

    @Test
    public void testPopUntilEmptyAndThenThrowException() throws EmptyStackException {
        Stack stack = new Stack();
        stack.push("A");
        stack.pop();
        assertThrows(EmptyStackException.class, stack::pop);
    }

    @Test
    public void testPeekUntilEmptyAndThenThrowException() throws EmptyStackException {
        Stack stack = new Stack();
        stack.push("A");
        stack.pop();
        assertThrows(EmptyStackException.class, stack::peek);
    }

    @Test
    public void testPopAndPeekInterleavedWithEmptyStackException() throws EmptyStackException {
        Stack stack = new Stack();
        stack.push("A");
        assertEquals("A", stack.pop());
        stack.push("B");
        assertEquals("B", stack.peek());
        assertEquals("B", stack.pop());
        assertThrows(EmptyStackException.class, stack::peek);
        assertThrows(EmptyStackException.class, stack::pop);
    }
}