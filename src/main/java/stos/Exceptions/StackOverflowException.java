package stos.Exceptions;

public class StackOverflowException extends Exception { 
    public StackOverflowException() {
        super("Stack is full");
    }
}