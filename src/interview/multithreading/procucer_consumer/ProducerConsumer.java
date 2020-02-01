package interview.multithreading.procucer_consumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer {

	public static void main(String[] args) throws InterruptedException {
		
//		WaitNotifyQueue<Item> queue = new WaitNotifyQueue(10);
//		queue.put(new Item());
		BlockingQueue<Item> queue = new ArrayBlockingQueue<>(10);
		
		final Runnable producer = () -> {
			while (true) {
				try {
					queue.put(new Item());
					System.out.println("Putting item... ");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} //thread blocks if queue is full
			}
		};
		new Thread(producer).start();
		
		final Runnable consumer = () -> {
			while (true) {
				try {
					Item item = queue.take();
					System.out.println("Getting item... ");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} //thread blocks if queue is empty
			}
		};
		new Thread(consumer).start();
		
		Thread.sleep(1000);
		
	}

}

class Item {
	
}

//wait-notify
class WaitNotifyQueue<E> {

	private Queue<E> queue;
	private int maxSize = 16;
	private Object lock = new Object();

	public WaitNotifyQueue(int maxSize) {
		queue = new LinkedList<>();
		this.maxSize = maxSize;
	}

	public void put(E e) {
		while (queue.size() == maxSize) {
			synchronized (lock) {
				try {
					lock.wait();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}			
		}
		queue.add(e);
		synchronized (lock) {
			lock.notifyAll();
		}
	}

	public E take() {
		while (queue.size() == 0) {
			synchronized (lock) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}			
		}
		E item = queue.remove();
		synchronized (lock) {
			lock.notifyAll();
		}
		return item;
	}

}

//Locks and conditions
class LocksConditionsQueue<E> {

	private Queue<E> queue;
	private int maxSize = 16;
	private ReentrantLock lock = new ReentrantLock(true);
	private Condition notEmpty = lock.newCondition();
	private Condition notFull = lock.newCondition();

	public LocksConditionsQueue(int maxSize) {
		queue = new LinkedList<>();
		this.maxSize = maxSize;
	}

	public void put(E e) {
		lock.lock();
		try {
			if (queue.size() == maxSize) {
				// block the thread
				notFull.await();
			}
			queue.add(e);
			notEmpty.signalAll();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public E take() throws InterruptedException {
		lock.lock();
		try {
			if (queue.size() == 0) {
				// block the thread
				notEmpty.await();
			}
			E item = queue.remove();
			notFull.signalAll();
			return item;
		} finally {
			lock.unlock();
		}
	}

}
