package interview.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * You cannot 'extend' exception in 'throws' section, for instance, IOException -> FileNotFoundException works well, but IOException -> Exception will be compile error
 *
 */
public class ExceptionOverriding {

    public static void main(String[] args) {

    }

}

class A {

    public void aaa() throws IOException {
    }

}

class B extends A {

    @Override
//    public void aaa() throws Exception {      // compile error, 'aaa()' in 'interview.exceptions.B' clashes with 'aaa()' in 'interview.exceptions.A'; overridden method does not throw 'java.lang.Exception'

    public void aaa() throws FileNotFoundException {
    }

}
