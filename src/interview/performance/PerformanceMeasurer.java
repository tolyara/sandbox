package interview.performance;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class PerformanceMeasurer<O> {

    public PerformanceMeasurer() {
    }

    public void process(Collection<O> objects, UnaryOperator<O> preparer, Consumer<O> targetOperationAcceptor) {
        System.out.println("Preparations are being made ... ");
        for (O object : objects) {
            object = preparer.apply(object);
            if (object instanceof Collection) {
                System.out.println("Prepared " + object.getClass().getSimpleName() + " size : " + ((Collection) object).size());
            }
        }
        System.out.println("Performance benchmarking starts ... ");
        for (O object : objects) {
            process(object, object.getClass().getSimpleName(), targetOperationAcceptor);
        }
    }

    private void process(O object, String name, Consumer<O> targetOperationAcceptor) {
        long start = System.currentTimeMillis();
        targetOperationAcceptor.accept(object);
        long finish = System.currentTimeMillis();
        System.out.println(name + " : " + (finish - start));
    }

}
