package interview.livecoding.set;

import java.util.Arrays;

public class MySet {

    private static final int DEFAULT_SIZE = 10;

    private int size = 0;

    private Object[] data = new Object[DEFAULT_SIZE];

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void add(Object element) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null) {
                data[i] = element;
                size++;
                break;
            }
        }
    }

    public boolean contains(Object element) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    public void remove(Object element) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(element)) {
                data[i] = data[size - 1];
                data[size - 1] = null;
                size--;
            }
        }
    }

    public void clear() {
//        for (int i = 0; i < data.length; i++) {
//            data[i] = null;
//        }
        Arrays.fill(data, null);
    }

    @Override
    public String toString() {
        return "MySet{" +
                "data=" + Arrays.toString(data) +
                '}';
    }
}
