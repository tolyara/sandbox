package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WhyMultithreadingIsBad {

	public static void main(String[] args) throws CloneNotSupportedException {

//		doDemoImmutable();
		System.out.println((new Person().hashCode()));
		System.out.println((new Person().hashCode()));

	}

	private static void doDemo() {

		Count count = new Count();
		long start = System.currentTimeMillis();
		for (int i = 0; i < 1_000_000_000; i++) {
			count.increment();
		}
		long finish = System.currentTimeMillis();
		System.out.println(finish - start);

	}

	private static void doDemoImmutable() throws CloneNotSupportedException {

		ImmutableCount immutableCount = new ImmutableCount(5, Arrays.asList("one", "two"), "hello", new Person());
		immutableCount.getPerson().age = 7;
		System.out.println(immutableCount);

	}

	static class Count {

		int i;
//		volatile int i;
//		AtomicInteger atomicInteger = new AtomicInteger(0);

		synchronized void increment() {
			i++;
//			atomicInteger.incrementAndGet();
		}

	}

	final static class ImmutableCount {

		private final int i;
		private final List<String> list;
		private final String string;
		private final Person person;
//		private final Object object;

		public ImmutableCount(int i, List<String> list, String string, Person person)
				throws CloneNotSupportedException {
			this.i = i;
			this.list = Collections.unmodifiableList(cloneList(list));
			this.string = string;
			this.person = (Person) person.clone();
//			this.object = object;
		}

		public int getI() {
			return i;
		}

		public List<String> getList() {
			return list;
		}

		public String getString() {
			return string;
		}

		public Person getPerson() throws CloneNotSupportedException {
//			return person;
			return (Person) person.clone();
		}

		@Override
		public String toString() {
			return "ImmutableCount [i=" + i + ", list=" + list + ", string=" + string + ", person=" + person + "]";
		}

		private List<String> cloneList(List<String> list) {

			List<String> cloneList = new ArrayList<String>(list.size());
			cloneList.addAll(list);
//			for (String s : list) {
//				cloneList.add(s);
//			}
			return cloneList;

		}

	}

	static class Person implements Cloneable {

		int age;

		@Override
		protected Object clone() throws CloneNotSupportedException {
			return super.clone();
		}

		@Override
		public String toString() {
			return "Person [age=" + age + "]";
		}

	}

}
