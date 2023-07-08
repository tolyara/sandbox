package interview;

public class DiamondShapedProblem {

}

interface Inter1 {

	default void f() {
	}

}

interface Inter2 {

	default void f() {
	}

}

/**
 *
 * There will be a compile error without overriding:
 * interview.Inter3 inherits unrelated defaults for f() from types interview.Inter1 and interview.Inter2
 */
interface Inter3 extends Inter1, Inter2 {

	@Override
	default void f() {
		Inter1.super.f();
	}
//	@Override
//	default void f() {
//		Inter2.super.f();
//	}

}

