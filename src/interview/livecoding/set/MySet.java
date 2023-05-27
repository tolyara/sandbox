package interview.livecoding.set;

import java.util.Arrays;

public class MySet {

    private static final int DEFAULT_SIZE = 10;

    private int size = 0;

    private Object[] data = new Object[DEFAULT_SIZE];

    public boolean isEmpty() {
        return size == 0;
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

    public void contains(Object element) {

    }

    public void clear() {
//        for (int i = 0; i < data.length; i++) {
//            data[i] = null;
//        }
        Arrays.fill(data, null);
    }

}
