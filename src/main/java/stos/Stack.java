package stos;

import java.util.ArrayList;
import stos.Exceptions.EmptyStackException;

public class Stack {
    private ArrayList<String> stack;

    public Stack() {
        this.stack = new ArrayList<String>();
    }

    public String pop() throws EmptyStackException 
    {
        if (this.stack.size() > 0) {
            int lastIndex = this.stack.size()-1;
            String ret = this.stack.get(lastIndex);
            this.stack.remove(lastIndex);
            return ret;
        } else {
            throw new EmptyStackException();
        }
    }

    public void push(String value)
    {
        this.stack.add(value);
    }

    public String peek() throws EmptyStackException 
    {
        if (this.stack.size() > 0) {
            return this.stack.get(this.stack.size()-1);
        } else {
            throw new EmptyStackException();
        }
    }
}
