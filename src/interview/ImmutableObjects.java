package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ImmutableObjects {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("one", "two", "three"));
        List<String> unmodifiableList = new ImmutableList(list).getList();
        unmodifiableList.add("four");
    }

}

class ImmutableList {

    private final List<String> list;

    ImmutableList(List<String> list) {
        this.list = Collections.unmodifiableList(cloneList(list));
    }

    public List<String> getList() {
        return list;
    }

    private List<String> cloneList(List<String> list) {
        List<String> cloneList = new ArrayList<String>(list.size());
        cloneList.addAll(list);
        return cloneList;
    }

}
