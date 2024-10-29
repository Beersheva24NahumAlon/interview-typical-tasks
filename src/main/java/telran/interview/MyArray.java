package telran.interview;

import java.util.*;

public class MyArray<T> {
    T valueForAll;
    int size;
    HashMap<Integer, T> map;

    public void setAll(T value) {
        map = new HashMap<>();
        valueForAll = value;
    }

    public void set(int index, T value) {
        checkIndex(index);
        map.put(index, value);
    }

    private void checkIndex(int index) {
        if (index > size - 1 || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public T get(int index) {
        checkIndex(index);
        T res = map.get(index);
        return res != null ? res : valueForAll;
    }

    public MyArray(int size) {
        this.size = size;
        setAll(null);
    }
}
