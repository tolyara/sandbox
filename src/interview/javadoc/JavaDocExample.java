package interview.javadoc;

/**
 * 
 * This is main class. <img src="doc-files/smile.jpg" alt="alt"/>
 * 
 * @author Anatolii Melchenko
 * @version 1.1
 * @since 1.0
 */
public class JavaDocExample {

	/**
	 * This is some field.
	 */
	protected int myField;

	/**
	 * Here program starts.
	 * 
	 * @param args command line values
	 */
	public static void main(String[] args) {
		label: for (int i = 0; i < args.length; i++) {
			for (int j = 0; i < args.length; i++) {
				if (true) {
					continue label;
				}
			}
		}
	}

	/**
	 * This is some description with link to other class - {@link OtherClass}
	 * 
	 * @see OtherClass#otherMethod()
	 * @see "Chapter 2"
	 */
	void newMethod() {

	}

}
