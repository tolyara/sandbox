package interview.multithreading.lessons.lessons1_8;

/**
 *	java deadlock detection tool - jstack
 *
 * 1) from CL or Power Shell go to bin directory of JDK, like "C:\Program Files\Java\jdk-19\bin>",
 * then use command jps -l -m to list the process id of this deadlock program. In my example it is 18408:
 *
 * 20676 jdk.jcmd/sun.tools.jps.Jps -l -m
 * ..........................................................................................................................................................
 * 18408 interview.multithreading.lessons.lessons1_8.DeadLockExample
 * 4680
 * 5336 org.jetbrains.idea.maven.server.RemoteMavenServer36
 *
 * 2) then ust type jstack + process id, and it will display all detailed information about deadlock:
 *
 * ...........................................................................................................................................................
 * Java stack information for the threads listed above:
 * ===================================================
 * "Thread-1":
 *         at interview.multithreading.lessons.lessons1_8.DeadLockExample$2.run(DeadLockExample.java:66)
 *         - waiting to lock <0x00000000d591b170> (a java.lang.String)
 *         - locked <0x00000000d590c070> (a java.lang.String)
 * "Thread-0":
 *         at interview.multithreading.lessons.lessons1_8.DeadLockExample$1.run(DeadLockExample.java:38)
 *         - waiting to lock <0x00000000d590c070> (a java.lang.String)
 *         - locked <0x00000000d591b170> (a java.lang.String)
 *
 * Found 1 deadlock.
 *
 */

public class DeadLockExample {
/*
 	 Thread 1: locked resource 1

   	 Thread 2: locked resource 2

 */

	public static void main(String[] args) {

		final String resource1 = "ABAP";

		final String resource2 = "Java";

		// t1 tries to lock resource1 then resource2

		Thread t1 = new Thread() {

			public void run() {

				synchronized (resource1) {

					System.out.println("Thread 1: locked resource 1");

					try {

						Thread.sleep(100);

					} catch (Exception e) {

					}

					synchronized (resource2) {

						System.out.println("Thread 1: locked resource 2");

					}

				}

			}

		};

		Thread t2 = new Thread() {

			public void run() {

				synchronized (resource2) {

					System.out.println("Thread 2: locked resource 2");

					try {

						Thread.sleep(100);

					} catch (Exception e) {

					}

					synchronized (resource1) {

						System.out.println("Thread 2: locked resource 1");

					}

				}

			}

		};

		t1.start();

		t2.start();

	}

}
