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

	@After
	public void after() {
		set.clear();
	}

}
