package telran.interview;

import java.util.*;

public class MyStackInt {
    private ArrayList<Integer> array = new ArrayList<>();
    private ArrayList<Integer> arrayMax = new ArrayList<>();

    public void push(int num) {
        array.add(num);
        if (arrayMax.isEmpty() || num >= arrayMax.getLast()) {
            arrayMax.add(num);
        }
        
    }

    private void checkEmpty() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
    }

    public int pop() {
        checkEmpty();
        int res = array.getLast();
        array.removeLast();
        if (res == arrayMax.getLast()) {
            arrayMax.removeLast();
        }
        return res;
    }

    public int peek() {
        checkEmpty();
        return array.getLast();
    }

    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getMaxElement() {
        checkEmpty();
        return arrayMax.getLast();
    }
}
