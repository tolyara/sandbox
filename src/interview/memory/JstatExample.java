package interview.memory;

/**
 * Each Java process has a pid, which you first need to find with the jps command.
 * from CL or Power Shell go to bin directory of JDK, like "C:\Program Files\Java\jdk-19\bin>
 * jps -l -m
 *
 * Once you have the pid, you can use jstat -gc [insert-pid-here] to find statistics of the behavior of the garbage collected heap.
 * jstat -gccapacity [insert-pid-here] will present information about memory pool generation and space capabilities.
 *
 * jstat -gcutil [insert-pid-here] will present the utilization of each generation as a percentage of its capacity. Useful to get an at a glance view of usage.
 */
public class JstatExample {

    public static void main(String[] args) {
        while (true) {

        }
    }

}
