package org.example.jmvlocttest;

public class SynchronizedTest {
    private static int count = 0;

    public static synchronized void increment() {
        count++;
    }

    public static void main(String[] args) {
        int numThreads = 20;
        Thread[] threads = new Thread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(() -> {
                while (true) {
                    increment();
                }
            });
            threads[i].start();
        }
    }
}
