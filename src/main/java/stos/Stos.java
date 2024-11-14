package stos;

import stos.Exceptions.*;
public class Stos {
    private String[] stos;
    private int rozmiar;
    private int szczyt;

    public Stos(int maxRozmiar) {
        this.stos = new String[maxRozmiar];
        this.rozmiar = maxRozmiar;
        this.szczyt = -1; 
    }

    public void push(String value) throws StackOverflowException{
        if (this.szczyt+1 >= this.rozmiar) {
            throw new StackOverflowException();
        }
        this.stos[++this.szczyt] = value;
    }

    public String pop() throws EmptyStackException {
        if (this.szczyt < 0) {
            throw new EmptyStackException();
        }
        String element = this.stos[this.szczyt];
        this.stos[this.szczyt--] = null;
        return element;
    }

    public String peek() throws EmptyStackException {
        if (this.szczyt < 0) {
            throw new EmptyStackException();
        }
        return this.stos[this.szczyt];
    }
}
