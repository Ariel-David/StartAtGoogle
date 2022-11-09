package JavaBasic.exercise;

import java.util.Arrays;

public class MyStack {
    public Object[] stack;

    private final int Default_Size = 10;

    private int size = 0;

    public MyStack() {
        stack = new Object[Default_Size];
    }

    public boolean empty() {
        if (stack.length == 0) {
            return true;
        }
        return false;
    }

    public Object peek() {
        Object object = stack[size];
        return object;
    }

    public Object pop() {
        Object object = stack[--size];
        return object;
    }

    public void push(Object obj) {
        if (size == stack.length) {
            stack = Arrays.copyOf(stack, stack.length + Default_Size);
        }
        stack[size++] = obj;
    }

    public int search(Object obj) {
        int pos = -1;
        for (int i = 0; i < stack.length; i++) {
            if (stack[i] == obj) {
                pos = i;
            }
        }
        return pos;
    }

}



