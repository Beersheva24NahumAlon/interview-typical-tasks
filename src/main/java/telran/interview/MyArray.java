package telran.interview;

import java.util.*;

public class MyArray<T> {
    // Value for filling array
    T valueForAll;
    // Size of array 
    int size;
    // Here I use data strucrure HashMap, because it has complexity O(1) for adding and getting data
    // As a key we use index in array and object of data as a value
    HashMap<Integer, T> map;

    public void setAll(T value) {
        // We create new map and define value for filling
        map = new HashMap<>();
        valueForAll = value;
    }

    public void set(int index, T value) {
        checkIndex(index);
        map.put(index, value);
    }

    // In this method we check bounds of array and throw exception
    private void checkIndex(int index) {
        if (index > size - 1 || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public T get(int index) {
        checkIndex(index);
        // We check if for some index we set some data, if it is not - return value for filling
        T res = map.get(index);
        return res != null ? res : valueForAll;
    }

    public MyArray(int size) {
        this.size = size;
        setAll(null);
    }
}
