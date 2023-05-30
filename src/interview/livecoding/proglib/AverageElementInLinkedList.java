package interview.livecoding.proglib;

import java.util.Iterator;
import java.util.LinkedList;

@Deprecated
public class AverageElementInLinkedList {

    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList();
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        linkedList.add("4");
        linkedList.add("5");
        linkedList.add("6");
        linkedList.add("7");
        linkedList.add("8");
        linkedList.add("9");
        linkedList.add("10");
        String head = linkedList.getFirst();

        String current = head;
        int length = 0;
        String middle = head;

        Iterator<String> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            length++;
            if (length % 2 == 0) {
                middle = next;
                System.out.println(middle);
            }
//            current = next;
        }
//        if (length % 2 == 1) {
//            middle = iterator.next();
//        }
        System.out.println("length of LinkedList: " + length);
        System.out.println("middle element of LinkedList : " + middle);
    }

}
