package weck3.EvenOdd;

public class OddThread implements Runnable{
    public OddThread() {}
    @Override
    public void run() {
        for (int i = 1; i < 10; i += 2) {
            System.out.println(i);
        }
    }

}
