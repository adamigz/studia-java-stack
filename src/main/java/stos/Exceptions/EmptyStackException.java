package stos.Exceptions;

public class EmptyStackException extends Exception { 
    public EmptyStackException() {
        super("Stack is empty");
    }
}