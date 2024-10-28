package telran.interview;

import java.util.*;

public class MyStackInt {
    // I use data structures ArrayList (actualy, in our case it's not metter wich list we chouse,
    // because operations adding last element and getting last element of ArrayList and LinkedList 
    // have same complaxity O(1))

    // Here we will store all elements of our stack 
    private ArrayList<Integer> array = new ArrayList<>();
    // Here we will store all maximum elements of our stack in increasing order
    // to return maximum element of stack with complaxity O(1) (return last element of this list)
    private ArrayList<Integer> arrayMax = new ArrayList<>();

    public void push(int num) {
        array.add(num);
        if (arrayMax.isEmpty() || num >= arrayMax.getLast()) {
            arrayMax.add(num);
        }
        
    }

    // In this method we check if stack is empty and throw exception
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
