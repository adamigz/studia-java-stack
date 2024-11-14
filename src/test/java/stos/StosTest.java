package stos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stos.Exceptions.EmptyStackException;
import stos.Exceptions.StackOverflowException;

import static org.junit.jupiter.api.Assertions.*;

public class StosTest {
    private Stos stos;

    @BeforeEach
    public void setUp() {
        stos = new Stos(3);
    }

    @Test
    public void testPush() throws StackOverflowException, EmptyStackException {
        stos.push("1");
        stos.push("2");
        
        assertEquals("2", stos.peek());
        assertEquals("2", stos.peek());
    }

    @Test
    public void testPop() throws StackOverflowException, EmptyStackException {
        stos.push("3");
        stos.push("4");
        
        String element = stos.pop();
        assertEquals("4", element);
        assertEquals("3", stos.peek());
    }

    @Test
    public void testPeek() throws StackOverflowException, EmptyStackException {
        stos.push("5");
        assertEquals("5", stos.peek());
    }

    @Test
    public void testPopOnEmptyStack() {
        assertThrows(EmptyStackException.class, () -> stos.pop());
    }

    @Test
    public void testPeekOnEmptyStack() {
        assertThrows(EmptyStackException.class, () -> stos.peek());
    }

    @Test
    public void testPushOnFullStack() throws StackOverflowException {
        stos.push("6");
        stos.push("7");
        stos.push("8");
        
        assertThrows(StackOverflowException.class, () -> stos.push("9"));
    }
}