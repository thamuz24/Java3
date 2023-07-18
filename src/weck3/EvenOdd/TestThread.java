package weck3.EvenOdd;

public class TestThread {
    public static void main(String[] args) throws InterruptedException {
        EvenThread evenThread = new EvenThread();
        OddThread oddThread = new OddThread();
        Thread thread = new Thread(oddThread);
        Thread thread1 = new Thread(evenThread);
        thread.start();
        thread.join();
        evenThread.start();

    }
}
