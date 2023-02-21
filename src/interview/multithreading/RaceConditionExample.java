package interview.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class RaceConditionExample {

    public static void main(String[] args) {
        Counter counter = new Counter();
        MyThread t1 = new MyThread(counter, 100);
        MyThread t2 = new MyThread(counter, 100);
        t1.start();
        t2.start();
    }

}

class Counter {

    private int count = 0;
//    private AtomicInteger count = new AtomicInteger(0);

    public void increment() {
        count++;
//        count.getAndIncrement();
    }

    public int getCount() {
        return count;
//        return count.get();
    }

}

class MyThread extends Thread {

    private final Counter counter;
    private final Integer iteration;

    MyThread(Counter counter, Integer iteration) {
        this.counter = counter;
        this.iteration = iteration;
    }

    @Override
    public void run() {
//        synchronized (counter) {                  // use synchronization to synchronize output
            for (int i = 0; i < iteration; i++) {
                counter.increment();
                System.out.println(" Count = " + counter.getCount() + " " + this.getName());
            }
//        }
    }

}





/*

    Output data inconsistency

 Count = 1 Thread-1
 Count = 3 Thread-1         <<<<<<<
 Count = 4 Thread-1
 Count = 5 Thread-1
 Count = 6 Thread-1
 Count = 7 Thread-1
 Count = 8 Thread-1
 Count = 9 Thread-1
 Count = 10 Thread-1
 Count = 11 Thread-1
 Count = 12 Thread-1
 Count = 13 Thread-1
 Count = 14 Thread-1
 Count = 15 Thread-1
 Count = 16 Thread-1
 Count = 17 Thread-1
 Count = 18 Thread-1
 Count = 19 Thread-1
 Count = 20 Thread-1
 Count = 21 Thread-1
 Count = 22 Thread-1
 Count = 23 Thread-1
 Count = 24 Thread-1
 Count = 25 Thread-1
 Count = 26 Thread-1
 Count = 27 Thread-1
 Count = 28 Thread-1
 Count = 29 Thread-1
 Count = 30 Thread-1
 Count = 31 Thread-1
 Count = 32 Thread-1
 Count = 33 Thread-1
 Count = 34 Thread-1
 Count = 35 Thread-1
 Count = 36 Thread-1
 Count = 37 Thread-1
 Count = 38 Thread-1
 Count = 39 Thread-1
 Count = 40 Thread-1
 Count = 41 Thread-1
 Count = 42 Thread-1
 Count = 43 Thread-1
 Count = 44 Thread-1
 Count = 45 Thread-1
 Count = 46 Thread-1
 Count = 47 Thread-1
 Count = 48 Thread-1
 Count = 49 Thread-1
 Count = 50 Thread-1
 Count = 51 Thread-1
 Count = 52 Thread-1
 Count = 53 Thread-1
 Count = 54 Thread-1
 Count = 55 Thread-1
 Count = 56 Thread-1
 Count = 2 Thread-0                 <<<<<<<
 Count = 57 Thread-1
 Count = 58 Thread-0
 Count = 59 Thread-1
 Count = 60 Thread-0
 Count = 61 Thread-1
 Count = 63 Thread-1
 Count = 64 Thread-1
 Count = 65 Thread-1
 Count = 66 Thread-1
 Count = 67 Thread-1
 Count = 68 Thread-1
 Count = 69 Thread-1
 Count = 70 Thread-1
 Count = 71 Thread-1
 Count = 72 Thread-1
 Count = 73 Thread-1
 Count = 74 Thread-1
 Count = 75 Thread-1
 Count = 76 Thread-1
 Count = 77 Thread-1
 Count = 78 Thread-1
 Count = 62 Thread-0
 Count = 80 Thread-0
 Count = 81 Thread-0
 Count = 82 Thread-0
 Count = 83 Thread-0
 Count = 84 Thread-0
 Count = 85 Thread-0
 Count = 86 Thread-0
 Count = 87 Thread-0
 Count = 88 Thread-0
 Count = 89 Thread-0
 Count = 90 Thread-0
 Count = 91 Thread-0
 Count = 92 Thread-0
 Count = 93 Thread-0
 Count = 94 Thread-0
 Count = 95 Thread-0
 Count = 96 Thread-0
 Count = 97 Thread-0
 Count = 98 Thread-0
 Count = 99 Thread-0
 Count = 100 Thread-0
 Count = 101 Thread-0
 Count = 102 Thread-0
 Count = 103 Thread-0
 Count = 104 Thread-0
 Count = 105 Thread-0
 Count = 106 Thread-0
 Count = 107 Thread-0
 Count = 108 Thread-0
 Count = 109 Thread-0
 Count = 110 Thread-0
 Count = 111 Thread-0
 Count = 112 Thread-0
 Count = 113 Thread-0
 Count = 114 Thread-0
 Count = 115 Thread-0
 Count = 116 Thread-0
 Count = 117 Thread-0
 Count = 118 Thread-0
 Count = 119 Thread-0
 Count = 120 Thread-0
 Count = 121 Thread-0
 Count = 122 Thread-0
 Count = 123 Thread-0
 Count = 124 Thread-0
 Count = 125 Thread-0
 Count = 126 Thread-0
 Count = 127 Thread-0
 Count = 128 Thread-0
 Count = 129 Thread-0
 Count = 130 Thread-0
 Count = 131 Thread-0
 Count = 132 Thread-0
 Count = 133 Thread-0
 Count = 134 Thread-0
 Count = 135 Thread-0
 Count = 136 Thread-0
 Count = 137 Thread-0
 Count = 138 Thread-0
 Count = 139 Thread-0
 Count = 140 Thread-0
 Count = 141 Thread-0
 Count = 142 Thread-0
 Count = 143 Thread-0
 Count = 144 Thread-0
 Count = 145 Thread-0
 Count = 146 Thread-0
 Count = 147 Thread-0
 Count = 148 Thread-0
 Count = 149 Thread-0
 Count = 150 Thread-0
 Count = 151 Thread-0
 Count = 152 Thread-0
 Count = 153 Thread-0
 Count = 79 Thread-1                <<<<<<<
 Count = 155 Thread-1
 Count = 156 Thread-1
 Count = 157 Thread-1
 Count = 158 Thread-1
 Count = 159 Thread-1
 Count = 160 Thread-1
 Count = 161 Thread-1
 Count = 162 Thread-1
 Count = 163 Thread-1
 Count = 164 Thread-1
 Count = 165 Thread-1
 Count = 166 Thread-1
 Count = 167 Thread-1
 Count = 168 Thread-1
 Count = 169 Thread-1
 Count = 170 Thread-1
 Count = 171 Thread-1
 Count = 172 Thread-1
 Count = 173 Thread-1
 Count = 174 Thread-1
 Count = 175 Thread-1
 Count = 176 Thread-1
 Count = 177 Thread-1
 Count = 178 Thread-1
 Count = 179 Thread-1
 Count = 154 Thread-0
 Count = 180 Thread-0
 Count = 181 Thread-0
 Count = 182 Thread-0
 Count = 183 Thread-0
 Count = 184 Thread-0
 Count = 185 Thread-0
 Count = 186 Thread-0
 Count = 187 Thread-0
 Count = 188 Thread-0
 Count = 189 Thread-0
 Count = 190 Thread-0
 Count = 191 Thread-0
 Count = 192 Thread-0
 Count = 193 Thread-0
 Count = 194 Thread-0
 Count = 195 Thread-0
 Count = 196 Thread-0
 Count = 197 Thread-0
 Count = 198 Thread-0
 Count = 199 Thread-0
 Count = 200 Thread-0

Process finished with exit code 0

 */