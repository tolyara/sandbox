package interview.livecoding.set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MySetTest {

	private MySet set;

	@Before
	public void before() {
		set = new MySet();
		set.add("1");
		set.add("2");
	}

	@Test
	public void testIsEmpty() throws Exception {
		Assert.assertFalse(set.isEmpty());
	}

	@Test
	public void testRemove() throws Exception {
		Assert.assertEquals(2, set.size());

		System.out.println(set);
		set.remove("1");
		System.out.println(set);

		Assert.assertEquals(1, set.size());
		Assert.assertFalse(set.contains("1"));
		Assert.assertTrue(set.contains("2"));
	}

	@After
	public void after() {
		set.clear();
	}

}
