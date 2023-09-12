package interview.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * You cannot 'extend' exception in 'throws' section, for instance, IOException -> FileNotFoundException works well, but IOException -> Exception will be compile error.
 *
 * You cannot also 'override' some exception with 'sibling', like IOException -> SQLException.
 *
 * But you can add extra unchecked exceptions, like RuntimeException and it's heirs
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

//    public void aaa() throws SQLException {    // compile error

//    public void aaa() throws FileNotFoundException {      // works

    public void aaa() throws IOException, ArithmeticException, ArrayIndexOutOfBoundsException, OutOfMemoryError {    // works
    }

}
