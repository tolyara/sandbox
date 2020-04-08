package interview.multithreading.lessons.lesson17;

import java.util.concurrent.Phaser;

//phase = 1 wash
public class Phasers {
	
	public static void main(String[] args) {
		Phaser phaser = new Phaser(3);
		
		new Washer(phaser);
		new Washer(phaser);
		new Washer(phaser);
	}
	
	static class Washer extends Thread {
		
		Phaser phaser;
		
		static int carNumber = 4;
		
		public Washer(Phaser phaser) {
			this.phaser = phaser;
			start();
		}

		@Override
		public void run() {	
			for (int i = 0; i < carNumber; i++) {
				System.out.println(getName() + " washing the car");
				phaser.arriveAndAwaitAdvance();
			}
		}
		
	}

}
