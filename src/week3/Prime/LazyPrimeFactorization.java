package week3.Prime;

public class LazyPrimeFactorization implements Runnable{
    @Override
    public void run(){
        long start = System.currentTimeMillis();
        for (int i = 2; i < 100000; i++) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.println(i);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("time lazy is: " + (end-start));
    }

}
