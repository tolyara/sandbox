package interview.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UnmodifiableCollections {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("111");
        list.add("222");

        List<String> unmodifiableList = Collections.unmodifiableList(list);
        System.out.println(unmodifiableList);
        unmodifiableList.add("333");        // java.lang.UnsupportedOperationException
        unmodifiableList.remove("222");  // java.lang.UnsupportedOperationException
    }

}
