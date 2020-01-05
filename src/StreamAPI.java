import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StreamAPI {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		System.out.println(getSumOddOldWay(list));
		System.out.println(getSumOddStreamWay(list));
	}

	static int getSumOddOldWay(Collection<Integer> collection) {
		Integer sumOdd = 0;
		for (Integer element : collection) {
			if (element % 2 != 0) {
				sumOdd += element;
			}
		}
		return sumOdd;
	}

	static int getSumOddStreamWay(Collection<Integer> collection) {
		return collection.stream().filter(o -> o % 2 != 0).reduce((s1, s2) -> s1 + s2).orElse(0);
	}
	
	static int getSumOddStreamWayParallelThread(Collection<Integer> collection) {
		return collection.parallelStream().filter(o -> o % 2 != 0).reduce((s1, s2) -> s1 + s2).orElse(0);
	}
	
}
