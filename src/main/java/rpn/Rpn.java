package rpn;

import stos.*;
import stos.Exceptions.StackOverflowException;
import stos.Exceptions.EmptyStackException;

public class Rpn {
    private String entry;
    private Stos stos;

    private int MAX_STACK_SIZE = 40;

    public Rpn(String entry)
    {
        this.entry = entry;
        this.stos = new Stos(this.MAX_STACK_SIZE);
    }

    public int evaluate() throws StackOverflowException, EmptyStackException
    {
        String[] chars = this.entry.split(" ");

        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case "+":
                    int add = this.parse(this.stos.pop()) + this.parse(this.stos.pop());
                    this.stos.push(String.valueOf(add));
                    break;
                case "-":
                    // tymczasowa zmienna bo kolejność ma znaczenie
                    int firstPoppedFromStack = this.parse(this.stos.pop());
                    int sub = this.parse(this.stos.pop()) - firstPoppedFromStack;
                    this.stos.push(String.valueOf(sub)); 
                    break;
                case "*":
                    int mult = this.parse(this.stos.pop()) * this.parse(this.stos.pop());
                    this.stos.push(String.valueOf(mult));
                    break;
                default:
                    this.stos.push(chars[i]);
                    break;
            }
        }

        return this.parse(this.stos.pop());
    }

    private int parse (String c) {
        return Integer.valueOf(c);
    }
}
