package interview.livecoding.leetcode;

import java.util.Iterator;
import java.util.TreeSet;

// Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.
public class MinimumAbsoluteDifference {

    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(5);
        set.add(10);
        set.add(12);
        set.add(21);

        System.out.println(getMinimumAbsoluteDifference(set));
    }

    private static int getMinimumAbsoluteDifference(TreeSet<Integer> set) {
        if (set.size() <= 1) return 0;
        int result = Integer.MAX_VALUE;

        Iterator<Integer> iterator = set.iterator();
        int current = iterator.next();
        while (iterator.hasNext()) {
            int next = iterator.next();
            int diff = next - current;
            if (diff < result) {
                result = diff;
            }
            current = next;
        }
        return result;
    }

}
